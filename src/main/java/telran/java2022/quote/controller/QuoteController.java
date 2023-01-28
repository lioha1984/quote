package telran.java2022.quote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.quote.dto.DatePeriodDto;
import telran.java2022.quote.dto.PriceDto;
import telran.java2022.quote.dto.QuoteDto;
import telran.java2022.quote.service.QuoteService;

@RestController
@RequestMapping("/quote")
@RequiredArgsConstructor
public class QuoteController {
	final QuoteService quoteService;
	
	@GetMapping("/{name}")
	public QuoteDto findQuote(@PathVariable String name) {
		return quoteService.findQuote(name);
	}

	@PostMapping("/{name}")
	public Iterable<PriceDto> findByPeriod(@PathVariable String name, @RequestBody DatePeriodDto period) {
		return quoteService.findBetweenDates(name, period);
	}
	
	@PostMapping("/{name}/{open}")
	public PriceDto findByOpen(@PathVariable String name, @PathVariable double open) {
		return quoteService.findByOpen(name, open);
	}
}
