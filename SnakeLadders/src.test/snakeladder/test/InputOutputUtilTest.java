package snakeladder.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.BeforeClass;
import org.junit.Test;

import snakeLadders.Util.InputOutputUtil;

public class InputOutputUtilTest {

	/**
	 * Tests if the readFromKeyboard() id providing correct output after reading from stream
	 */
	@Test
	public void test() {
		
		byte [] input= "y".getBytes();
		InputStream iStream= new ByteArrayInputStream(input);
		BufferedReader reader= new BufferedReader(new InputStreamReader(iStream));
		
		String choice=InputOutputUtil.readFromKeyboard(reader);
		assertNotEquals("n", choice);   //Negative test case
		assertEquals("y", choice);
	}

}
