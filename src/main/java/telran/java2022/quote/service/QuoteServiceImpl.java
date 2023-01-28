package telran.java2022.quote.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.quote.dao.QuoteRepository;
import telran.java2022.quote.dto.DatePeriodDto;
import telran.java2022.quote.dto.PriceDto;
import telran.java2022.quote.dto.QuoteDto;
import telran.java2022.quote.exceptions.PriceNotFoundException;
import telran.java2022.quote.exceptions.QuoteNotFoundException;
import telran.java2022.quote.model.Price;
import telran.java2022.quote.model.Quote;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
	final QuoteRepository quoteRepository;
	final ModelMapper modelMapper;

	@Override
	public QuoteDto findQuote(String name) {
		Quote quote = quoteRepository.findById(name).orElseThrow(() -> new QuoteNotFoundException(name));
		return modelMapper.map(quote, QuoteDto.class);
	}

	@Override
	public Iterable<PriceDto> findBetweenDates(String name, DatePeriodDto datePeriodDto) {
		return quoteRepository.findByDateCreatedBetween(name, datePeriodDto.getDateFrom(), datePeriodDto.getDateTo())
				.map(p -> modelMapper.map(p, PriceDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public PriceDto findByOpen(String name, double open) {
//		return quoteRepository.findByOpen(name, open)
//				.map(p -> modelMapper.map(p, PriceDto.class))
//				.collect(Collectors.toList());
//		
//		List<Price> price = quoteRepository.findByOpen(name, open);//orElseThrow(() -> new PriceNotFoundException(open));
		Price price = quoteRepository.findPriceObj(name, open).orElseThrow(() -> new PriceNotFoundException(open));
		return modelMapper.map(price, PriceDto.class);
	}
	
	private LocalDate convertDate(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
	}

}
