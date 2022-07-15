package com.example.CurrencyConverter.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import static com.example.CurrencyConverter.Controller.IDGenerator.generateID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Currency")
public class Currency {
    @Id
    private int id;
    private String symbol;
    private double rate;

    /*public Currency(String symbol, double rate) {
        id = generateID(symbol);
        this.symbol = symbol;
        this.rate = rate;
    }*/
}
