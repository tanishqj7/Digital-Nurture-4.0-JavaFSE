package com.example.orm.Country;

import com.example.orm.Country.Model.Country;
import com.example.orm.Country.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;



@SpringBootApplication
public class CountryApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CountryApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
}
