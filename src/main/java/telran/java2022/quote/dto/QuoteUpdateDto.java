package telran.java2022.quote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuoteUpdateDto {
	long open;
	long high;
	long low;
	long close;
}
