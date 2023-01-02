package telran.java2022.quote.dao;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.quote.model.Quote;

public interface QuoteRepository extends CrudRepository<Quote, String> {
//	Stream<Quote> findByDateCreatedBetween(LocalDate from, LocalDate to);
}
