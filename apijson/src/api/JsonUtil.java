package api;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

	public static void parseJson(Object object, OutputStream output)
			throws IOException, IllegalArgumentException, IllegalAccessException {

		output.write(getAttributes(object).getBytes());

	}

	private static String getAttributes(Object object) throws IllegalArgumentException, IllegalAccessException {

		if (object == null) {

			return null;

		}

		List<String> attributes = new ArrayList<String>();

		for (Field field : object.getClass().getDeclaredFields()) {

			attributes.add(String.format("\"%1$s\" : %2$s", field.getName(), getValue(object, field)));

		}

		return String.format("{%1$s}", String.join(",", attributes));
	}

	private static Object getValue(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {

		field.setAccessible(true);

		if (field.getType().isPrimitive()) {

			return field.get(object).toString();

		}

		if (String.class.equals(field.getType())) {

			return String.format("\"%1$s\"", field.get(object).toString());

		}

		return getAttributes(field.get(object));
	}

}
