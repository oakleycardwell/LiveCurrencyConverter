package com.example.CurrencyConverter.Accessor;

import com.example.CurrencyConverter.UI.MainFrame;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class ExchangeRateUpdater {
    public static void main(String[] args){
        /** CODE TO MAKE GET REQUEST OF DATA **/
		/*try{
			OkHttpClient client = new OkHttpClient().newBuilder().build();

			Request request = new Request.Builder()
					.url("https://api.apilayer.com/exchangerates_data/latest?symbols=JPY&base=USD")
					.addHeader("apikey", "p3zegoIleMEFdgAGe2vSOsZVynEJXzfw")
					.method("GET", null)
      .build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
		}catch(IOException e){
			e.printStackTrace();
		}*/
        try {
            Object object = new JSONParser().parse("{\n" +
                    "         \"success\": true,\n" +
                    "         \"timestamp\": 1657740063,\n" +
                    "         \"base\": \"USD\",\n" +
                    "         \"date\": \"2022-07-13\",\n" +
                    "         \"rates\": {\n" +
                    "         \"JPY\": 137.320994\n" +
                    "         }\n" +
                    "         }");

            JSONObject json = (JSONObject) object;
            Map rates = (Map) json.get("rates"); //TODO stream map of rates into Currency objects and post them to the database
        } catch (ParseException e) {
            System.out.println("Failed to parse JSON file when updating database.");
            e.printStackTrace();
        }

        /** RESULTING JSON OBJECT
         {
         "success": true,
         "timestamp": 1657740063,
         "base": "USD",
         "date": "2022-07-13",
         "rates": {
         "JPY": 137.320994
         }
         }
         **/
    }
}
