package telran.java2022.quote.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.java2022.quote.model.Price;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuoteDto {
	String nameQuote;
	List<Price> prices;
}
