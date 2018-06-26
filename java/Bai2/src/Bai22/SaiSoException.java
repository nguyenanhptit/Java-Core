package Bai22;

public class SaiSoException extends Exception{
	private String so;
	public SaiSoException (String value) {
		this.so = value;
	}

	public String getMessage() {
		return "Gia tri\'" + this.so+ "\' khong phai la so!";
	}

}
