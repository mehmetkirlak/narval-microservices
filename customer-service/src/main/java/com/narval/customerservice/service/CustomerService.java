package com.narval.customerservice.service;

import com.narval.customerservice.client.ProductServiceClient;
import com.narval.customerservice.dto.CustomerDto;
import com.narval.customerservice.dto.ProductDto;
import com.narval.customerservice.model.Customer;
import com.narval.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final ProductServiceClient productServiceClient;

    public CustomerService(CustomerRepository repository, ProductServiceClient productServiceClient) {
        this.repository = repository;
        this.productServiceClient = productServiceClient;
    }

    public List<CustomerDto> getAllCustomers() {
        return repository.findAll().stream().map(CustomerDto::convert).collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(String id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found... id : "+id));

        CustomerDto customerDto = new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone());
        return customerDto;
    }

    public String purchase(String productId) {
        ProductDto productDto = new ProductDto(
                productServiceClient.getProductById(productId).getBody().getId(),
                productServiceClient.getProductById(productId).getBody().getName(),
                productServiceClient.getProductById(productId).getBody().getPrice());

        return productDto.getName()+" is purchased. id of product : "+productDto.getId();
    }

}
