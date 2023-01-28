package telran.java2022.quote.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Price {
	LocalDate date;
	@Setter
	double open;
	@Setter
	double high;
	@Setter
	double low;
	@Setter
	double close;
}
