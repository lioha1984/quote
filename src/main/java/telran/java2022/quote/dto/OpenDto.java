package telran.java2022.quote.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java2022.quote.model.Price;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenDto {
	List<Price> prices;

}
