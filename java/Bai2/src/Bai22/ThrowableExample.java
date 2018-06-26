package Bai22;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {
	private static Integer integer;

	public static int toNumber(String value) throws SaiSoException {
		try {
			Integer interger = new Integer(value);
			return integer.intValue();
		} catch (NumberFormatException e) {
			throw new SaiSoException(value);
		}
	}

	private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());

	public static void main(String[] args) {
		try {
			System.out.println("number= " + toNumber("23"));
		} catch (SaiSoException e) {
			System.err.println(e.getMessage());
			LOGGER.log(Level.WARNING, e.getMessage());
		}
	}
}