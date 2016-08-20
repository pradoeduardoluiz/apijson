package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import api.JsonUtil;

public class JsonTest {

	OutputStreamUtil output = null;

	@Test
	public void testConvertPojoToJsonPrimitive() {

		output = new OutputStreamUtil();

		Person person = new Person();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);
		person.setFather(null);

		try {

			JsonUtil.convertObjectToJson(person, output);

			if (!output.getResult().equals(parseJsonGson(person))) {

				fail("Objeto convertido esta errado");

			}

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

	private String parseJsonGson(Object object) {
		// TODO Auto-generated method stub

		Gson gson = new Gson();

		return gson.toJson(object);
	}

	@Test
	public void testConvetPojoWithObjectComplexToJson() {

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
	public void testConvetPojoWithListToJson() {
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
			System.out.println(parseJsonGson(people));
			System.out.println(output.getResult());

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
