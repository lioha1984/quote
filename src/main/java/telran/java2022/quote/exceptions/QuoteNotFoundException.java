package telran.java2022.quote.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuoteNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6952550028444204207L;

	public QuoteNotFoundException(String date) {
		super("Quote with date = " + date + " not found");

	}
}
