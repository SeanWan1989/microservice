package org.sean;

import org.sean.dao.CityDao;
import org.sean.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sean.service.BlogService;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication implements CommandLineRunner {

//	@Autowired
//	private CityService cityService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		City city = this.cityService.selectCityById(1);
//		System.out.println(city);
//		city.setCountry("China");
//		this.cityService.updateCountryById(city);
	}

}
