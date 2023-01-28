package telran.java2022.quote.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;

import telran.java2022.quote.model.Price;
import telran.java2022.quote.model.Quote;

public interface QuoteRepository extends CrudRepository<Quote, String> {
	@Aggregation(pipeline = { 
			"{'$match': {'_id': ?0}}", 
			"{'$unwind': {'path': '$prices'}}",
			"{'$match': { 'prices.date': {$gte: ?1,$lte: ?2}}}",
			"{'$project': {"
							+ "'_id': 0, "
							+ "'open': '$prices.open', "
							+ "'date': '$prices.date',"
							+ "'high': '$prices.high',"
							+ "'low': '$prices.low', "
							+ "'close': '$prices.close'}}"
			})
	Stream<Price> findByDateCreatedBetween(String name, LocalDate from, LocalDate to);

	@Aggregation(pipeline = { 
			"{'$match': {'_id': ?0}}", 
			"{'$unwind': {'path': '$prices'}}",
			"{'$match': {'prices.open': ?1}}",
			"{'$project': {"
							+ "'_id': 0, "
							+ "'open': '$prices.open', "
							+ "'date': '$prices.date',"
							+ "'high': '$prices.high',"
							+ "'low': '$prices.low', "
							+ "'close': '$prices.close'}}"
			})
	Optional<Price> findPriceObj(String name, double value);
}
