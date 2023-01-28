package telran.java2022.quote.exceptions;

public class PriceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6952550028444204207L;

	public PriceNotFoundException(double open) {
		super("Price with open = " + open + " not found");

	}
}
