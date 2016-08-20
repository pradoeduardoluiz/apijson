package test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import api.JsonUtil;

public class JsonTest {

	@Test
	public void testConvertSimple() {

		OutputStreamUtil output = new OutputStreamUtil();

		Person person = new Person();

		person.setId(1);
		person.setName("Luiz Eduardo do Prado");
		person.setNews(true);

		try {
			JsonUtil.parseJson(person, output);
			System.out.println(output.getResult());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fail("Not yet implemented");
	}

}
