package test;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamUtil extends OutputStream {

	private StringBuffer serialized = new StringBuffer();

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub

		serialized.append(b);

	}

	public void write(byte[] bytes) {

		serialized.append(new String(bytes));

	}
	

	public String getResult() {

		return serialized.toString();

	}

}
