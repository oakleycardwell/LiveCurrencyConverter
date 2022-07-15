package com.example.CurrencyConverter.Controller;

import com.example.CurrencyConverter.Model.Currency;
import com.example.CurrencyConverter.Repository.CurrencyRepository;
//import com.example.CurrencyConverter.Controller.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static com.example.CurrencyConverter.Controller.IDGenerator.generateID;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyRepository repository;

    @PostMapping("/addCurrency")
    public String saveCurrency(@RequestBody Currency currency){
        //currency.setId(generateID(currency.getSymbol()));
        repository.save(currency);

        return "Currency added successfully";
    }

    @GetMapping("/getAllCurrencies")
    public List<Currency> getCurrencies(){
        return repository.findAll();
    }

    /*@GetMapping("/getRate/{symbol}")
    public double getRate(@PathVariable String symbol){
        return repository.findById(generateID(symbol)).get().getRate();
    }*/

    @DeleteMapping("/delete/{id}")
    public String deleteCurrency(@PathVariable int id){
        repository.deleteById(id);

        return "Deleted currency successfully";
    }

}
