package org.sean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class BookServiceApplication {

	@Autowired
	private DiscoveryClient discoveryClient;

	public static RestTemplate restTemplate;

	@Bean
	public RestTemplate initRestTemplate(){
		restTemplate = new RestTemplate();
		return  restTemplate;
	}

	@RequestMapping("/bookinfo")
	public String bookinfo(){
		List<ServiceInstance> list = discoveryClient.getInstances("student_service");
		if (list != null && list.size() > 0 ) {
			ServiceInstance serviceInstance =  list.get(0);
			return restTemplate.getForEntity(serviceInstance.getUri()+"/blog",String.class).getBody();
		}
		return "no instance";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}
