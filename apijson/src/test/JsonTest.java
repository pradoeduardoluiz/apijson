package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import api.JsonUtil;

public class JsonTest {

	OutputStreamUtil output = null;

	@Test
	public void testNullObject() {

		output = new OutputStreamUtil();

		Person person = null;

		try {
			JsonUtil.convertObjectToJson(person, output);
			fail("Error converting object, Null Object!");
		} catch (NullPointerException e) {
			assertEquals("Object is null", e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testNullOutputObject() {

		Person person = new Person();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);
		person.setFather(null);

		try {
			JsonUtil.convertObjectToJson(person, output);
			fail("Error converting object, Null Output Object!");
		} catch (NullPointerException e) {
			assertEquals("Object Output is null", e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testConvertObjectToJsonPrimitive() {

		String expected = "{\"id\":1,\"name\":\"Luiz Eduardo do Prado\",\"news\":true}";

		output = new OutputStreamUtil();

		Person person = new Person();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);
		person.setFather(null);

		try {

			JsonUtil.convertObjectToJson(person, output);
			assertEquals(expected, output.getResult());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

	@Test
	public void testConvetObjectToJsonComplex() {

		String expected = "{\"id\":1,\"name\":\"Luiz Eduardo do Prado\",\"news\":true,\"Father\":{\"id\":2,\"name\":\"Raul do Prado\",\"news\":false}}";

		output = new OutputStreamUtil();

		Person person = new Person();
		Person father = new Person();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);

		father.setId(2);
		father.setName("Raul do Prado");
		father.setNews(false);

		person.setFather(father);

		try {
			JsonUtil.convertObjectToJson(person, output);
			assertEquals(expected, output.getResult());

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testConvetObjectWithListToJson() {

		String expected = "{\"id\":1,\"name\":\"Luiz Eduardo do Prado\",\"news\":true,\"Father\":{\"id\":2,\"name\":\"Raul do Prado\",\"news\":false},\"children\":[{\"id\":3,\"name\":\"Dante\",\"news\":false}]}";

		output = new OutputStreamUtil();

		Person person = new Person();
		Person father = new Person();
		Person child = new Person();

		List<Person> children = new ArrayList<Person>();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);

		father.setId(2);
		father.setName("Raul do Prado");
		father.setNews(false);
		person.setFather(father);

		child.setId(3);
		child.setName("Dante");
		child.setNews(false);

		children.add(child);

		person.setChildren(children);

		try {
			JsonUtil.convertObjectToJson(person, output);
			assertEquals(expected, output.getResult());

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testConvertListObjectToJson() {

		String expected = "[{\"id\":1,\"name\":\"Luiz Eduardo do Prado\",\"news\":true,\"Father\":{\"id\":2,\"name\":\"Raul do Prado\",\"news\":false}},{\"id\":2,\"name\":\"Raul do Prado\",\"news\":false},{\"id\":3,\"name\":\"Dante\",\"news\":false}]";

		output = new OutputStreamUtil();

		Person person = new Person();
		Person father = new Person();
		Person child = new Person();

		List<Person> people = new ArrayList<Person>();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);

		father.setId(2);
		father.setName("Raul do Prado");
		father.setNews(false);
		person.setFather(father);

		child.setId(3);
		child.setName("Dante");
		child.setNews(false);

		people.add(person);
		people.add(father);
		people.add(child);

		try {
			JsonUtil.convertObjectToJson(people, output);
			assertEquals(expected, output.getResult());

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
