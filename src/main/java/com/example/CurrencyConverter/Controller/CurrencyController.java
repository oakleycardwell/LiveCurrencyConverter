package com.example.CurrencyConverter.Controller;

import com.example.CurrencyConverter.Model.Currency;
import com.example.CurrencyConverter.Repository.CurrencyRepository;
//import com.example.CurrencyConverter.Controller.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class CurrencyController {
    @Autowired
    private CurrencyRepository repository;

    @PostMapping("/addCurrency")
    public String saveCurrency(@RequestBody Currency currency){
        repository.save(currency);

        return "Currency added successfully";
    }

    @GetMapping("/getAllCurrencies")
    public List<Currency> getCurrencies(){
        return repository.findAll();
    }

    /*@GetMapping("/getRate/{symbol}")
    public double getRate(@PathVariable String symbol){
        return repository.findById();
    }*/

    @DeleteMapping("/delete/{id}")
    public String deleteCurrency(@PathVariable int id){
        repository.deleteById(id);

        return "Deleted currency successfully";
    }

}
