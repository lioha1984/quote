package telran.java2022.quote.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.quote.dao.QuoteRepository;
import telran.java2022.quote.dto.DatePeriodDto;
import telran.java2022.quote.dto.QuoteDto;
import telran.java2022.quote.dto.QuoteUpdateDto;
import telran.java2022.quote.exceptions.QuoteNotFoundException;
import telran.java2022.quote.model.Quote;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
	final QuoteRepository quoteRepository;
	final ModelMapper modelMapper;

	@Override
	public Boolean addQuote(QuoteDto quoteDto) {
		Quote quote = quoteRepository.findById(quoteDto.getDate()).orElse(null); 
		if (quote != null) {
			return false;
		}
		quote = modelMapper.map(quoteDto, Quote.class);
		quoteRepository.save(quote);
		return true;
	}

	@Override
	public QuoteDto removeQuote(String date) {
		Quote quote = quoteRepository.findById(date).orElseThrow(() -> new QuoteNotFoundException(date));
		
		if (quote == null) {
			return null;
		}
		
		quoteRepository.delete(quote);
		
		return modelMapper.map(quote, QuoteDto.class);
	}

	@Override
	public QuoteDto updateQuote(String date, QuoteUpdateDto quoteUpdateDto) {
		Quote quote = quoteRepository.findById(date).orElseThrow(() -> new QuoteNotFoundException(date));
		
		quote.setClose(quoteUpdateDto.getClose());
		quote.setOpen(quoteUpdateDto.getOpen());
		quote.setHigh(quoteUpdateDto.getHigh());
		quote.setLow(quoteUpdateDto.getLow());
		
		quoteRepository.save(quote);
		
		return modelMapper.map(quote, QuoteDto.class);
	}

	@Override
	public QuoteDto findQuote(String date) {
		Quote quote = quoteRepository.findById(date).orElseThrow(() -> new QuoteNotFoundException(date));
		return modelMapper.map(quote, QuoteDto.class);
	}

	@Override
	public Iterable<QuoteDto> findBetweenDates(DatePeriodDto datePeriodDto) {
//		return quoteRepository.findByDateCreatedBetween(datePeriodDto.getDateFrom(), datePeriodDto.getDateTo())
//				.map(p -> modelMapper.map(p, QuoteDto.class))
//				.collect(Collectors.toList());
		return null;
	}
	
	private LocalDate convertDate(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
	}

}
