package api;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JsonUtil {

	private static final Logger LOGGER = Logger.getLogger(JsonUtil.class
			.getName());

	public static void convertObjectToJson(Object object, OutputStream output)
			throws IOException, IllegalArgumentException,
			IllegalAccessException {

		LOGGER.info("Log API: " + LOGGER.getName());

		if (object == null) {

			LOGGER.warning("Log Api: Parameter Object is null, NullPointerException occur");

			throw new NullPointerException("Object is null");
		}

		if (output == null) {

			LOGGER.warning("Parameter Output is null, NullPointerException occur");

			throw new NullPointerException("Object Output is null");
		}

		LOGGER.info("Log Api: Start converter Object");

		output.write(getAttributes(object).getBytes());

	}

	private static String getAttributes(Object object)
			throws IllegalArgumentException, IllegalAccessException {

		if (object == null) {

			LOGGER.info("Log Api: Object attribute is null");

			return "";

		}

		if (List.class.isInstance(object)) {

			LOGGER.info("Log Api: Conveting Attribute type List");

			List<Object> list = List.class.cast(object);

			List<String> elements = new ArrayList<String>();

			for (Object obj : list) {

				elements.add(getObjects(obj));

			}

			return String.format("[%1$s]", String.join(",", elements));

		} else

		{
			LOGGER.info("Log Api: Conveting Attribute");
			return getObjects(object);
		}

	}

	private static String getObjects(Object object)
			throws IllegalAccessException {

		List<String> attributes = new ArrayList<String>();

		for (Field field : object.getClass().getDeclaredFields()) {

			LOGGER.info("Log Api: Get Field: " + object.getClass() + " "
					+ field.getName());

			Object value = getValue(object, field);

			if (!(value == "")) {

				attributes.add(String.format("\"%1$s\":%2$s", field.getName(),
						value));

			}

		}

		return String.format("{%1$s}", String.join(",", attributes));
	}

	private static Object getValue(Object object, Field field)
			throws IllegalArgumentException, IllegalAccessException {

		field.setAccessible(true);

		if (List.class.isInstance(field.get(object))) {

			return listElements(field.get(object));

		}

		if (field.getType().isPrimitive()) {

			return field.get(object).toString();

		}

		if (String.class.equals(field.getType())) {

			return String.format("\"%1$s\"", field.get(object).toString());

		}

		return getAttributes(field.get(object));
	}

	private static String listElements(Object object)
			throws IllegalArgumentException, IllegalAccessException {
		List<String> elements = new ArrayList<String>();
		for (Object el : (List) object) {
			elements.add(getAttributes(el));
		}
		return String.format("[%1$s]", String.join(",", elements));
	}
}
