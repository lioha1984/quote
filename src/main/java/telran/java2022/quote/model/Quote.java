package telran.java2022.quote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "date")
@Document(collection = "quotes")
public class Quote {
	@Id
	String date;
	@Setter
	long open;
	@Setter
	long high;
	@Setter
	long low;
	@Setter
	long close;
}
