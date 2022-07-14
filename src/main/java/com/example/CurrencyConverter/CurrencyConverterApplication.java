package com.example.CurrencyConverter;


import com.example.CurrencyConverter.Model.Currency;
import com.example.CurrencyConverter.Repository.CurrencyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);

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

	/*@Bean
	CommandLineRunner runner(CurrencyRepository repository){
		return args -> {
			Currency currency = new Currency(
				"USD",
				1
			);
			repository.insert(currency);
		};


	}*/

}
