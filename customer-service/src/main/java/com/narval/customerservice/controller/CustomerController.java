package com.narval.customerservice.controller;

import com.narval.customerservice.dto.CustomerDto;
import com.narval.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable @NotEmpty String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<String> purchase(@PathVariable String id) {
        return ResponseEntity.ok(customerService.purchase(id));
    }

}
