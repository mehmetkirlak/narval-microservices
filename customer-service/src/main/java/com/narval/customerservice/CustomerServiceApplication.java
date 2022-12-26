package com.narval.customerservice;

import com.narval.customerservice.model.Customer;
import com.narval.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerServiceApplication implements CommandLineRunner {

	private final CustomerRepository repository;

	public CustomerServiceApplication(CustomerRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer("Mehmet","Kirlak","mehmet.kirlak@outlook.com","5321456935");
		Customer customer2 = new Customer("Jason","Statham","jason.statham@outlook.com","5987654321");
		Customer customer3 = new Customer("Ryan","Gosling","ryan.gosling@outlook.com","5318671291");

		List<Customer> customerList = repository.saveAll(Arrays.asList(customer1,customer2,customer3));

		System.out.println(customerList);
	}
}
