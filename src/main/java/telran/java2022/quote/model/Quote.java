package telran.java2022.quote.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "nameQuote")
@Document(collection = "quotes")
public class Quote {
	@Id
	String nameQuote;
	List<Price> prices;
	
	public Quote(String nameQuote) {
		super();
		this.nameQuote = nameQuote;
		this.prices = new ArrayList<Price>();
	}
	
	public void addPrice(Price price) {
		prices.add(price);
	}
}
