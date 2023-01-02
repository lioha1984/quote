package telran.java2022.quote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.quote.dto.QuoteDto;
import telran.java2022.quote.dto.QuoteUpdateDto;
import telran.java2022.quote.service.QuoteService;

@RestController
@RequestMapping("/quote")
@RequiredArgsConstructor
public class QuoteController {
	final QuoteService quoteService;
	
	@PostMapping("/")
	public boolean addQuote(@RequestBody QuoteDto quoteDto) {
		return quoteService.addQuote(quoteDto);
	}
	
	@GetMapping("/{date}")
	public QuoteDto findQuote(@PathVariable String date) {
		return quoteService.findQuote(date);
	}
	
	@DeleteMapping("/{date}")
	public QuoteDto removeQuote(@PathVariable String date) {
		return quoteService.removeQuote(date);
	}

	@PutMapping("/{date}")
	public QuoteDto editQuote(@PathVariable String date, @RequestBody QuoteUpdateDto quoteUpdateDto) {
		return quoteService.updateQuote(date, quoteUpdateDto);
	}

}
