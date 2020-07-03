package com.in28minutes.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="currency-exchange-service",url="localhost:8081") // disable url when using ribbon
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// define a method to talk to currency exchange service
	// we have take the definition of the method from the currencyexchangeservice
	// make a few modifications interms of the return values
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			                                   @PathVariable("to") String to); 
		
	
}
