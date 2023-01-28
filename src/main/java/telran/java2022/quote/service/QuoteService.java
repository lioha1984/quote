package telran.java2022.quote.service;


import telran.java2022.quote.dto.DatePeriodDto;
import telran.java2022.quote.dto.PriceDto;
import telran.java2022.quote.dto.QuoteDto;

public interface QuoteService {
	QuoteDto findQuote(String name);
	
	Iterable<PriceDto> findBetweenDates(String name, DatePeriodDto datePeriodDto);

	PriceDto findByOpen(String name, double open);
	
	
}
