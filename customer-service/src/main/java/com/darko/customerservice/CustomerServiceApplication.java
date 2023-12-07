package com.darko.customerservice;

import com.darko.customerservice.config.GlobalConfig;
import com.darko.customerservice.entities.Customer;
import com.darko.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			Customer customer1 = Customer.builder()
					.firstName("Nono")
					.lastName("Barakouda")
					.email("nono@gmai.com")
					.build();
			customerRepository.save(customer1);

			Customer customer2 = Customer.builder()
					.firstName("Ball")
					.lastName("Pantin")
					.email("ball@gmai.com")
					.build();
			customerRepository.save(customer2);
		};
	}
}
