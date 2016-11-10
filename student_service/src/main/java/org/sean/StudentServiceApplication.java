package org.sean;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
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
