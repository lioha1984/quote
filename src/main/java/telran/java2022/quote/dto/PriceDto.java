package telran.java2022.quote.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceDto {
	LocalDate date;
	Double open;
	Double high;
	Double low;
	Double close;
}
