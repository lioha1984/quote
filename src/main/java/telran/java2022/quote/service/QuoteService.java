package telran.java2022.quote.service;


import telran.java2022.quote.dto.DatePeriodDto;
import telran.java2022.quote.dto.QuoteDto;
import telran.java2022.quote.dto.QuoteUpdateDto;

public interface QuoteService {
	Boolean addQuote(QuoteDto quoteDto);
	
	QuoteDto removeQuote(String date);
	
	QuoteDto updateQuote(String date, QuoteUpdateDto quoteUpdateDto);
	
	QuoteDto findQuote(String date);
	
	Iterable<QuoteDto> findBetweenDates(DatePeriodDto datePeriodDto);
	
	
}
