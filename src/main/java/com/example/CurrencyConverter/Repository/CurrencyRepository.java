package com.example.CurrencyConverter.Repository;

import com.example.CurrencyConverter.Model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyRepository extends MongoRepository<Currency, Integer> {

}
