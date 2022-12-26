package com.narval.productservice;

import com.narval.productservice.model.Product;
import com.narval.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication implements CommandLineRunner {

	private final ProductRepository repository;

	public ProductServiceApplication(ProductRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product("Mouse", "599 tl");
		Product product2 = new Product("Monitor", "3299 tl");
		Product product3 = new Product("Klavye", "899 tl");

		List<Product> productList = repository.saveAll(Arrays.asList(product1, product2, product3));

		System.out.println(productList);
	}
}
