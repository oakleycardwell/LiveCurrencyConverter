package com.example.CurrencyConverter.Controller;

public class IDGenerator {
    public static int generateID(String symbol){
        String stringID = "";
        for (int i = 0; i < symbol.length(); i++){
            stringID += symbol.charAt(i);
        }
        return Integer.parseInt(stringID);
    }
}
