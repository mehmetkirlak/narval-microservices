package com.narval.productservice.client;
import java.util.List;
import com.narval.productservice.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service", path = "/v1/customer")
public interface CustomerServiceClient {
    @GetMapping
    ResponseEntity<List<CustomerDto>> getAllCustomers();
    @GetMapping("/id/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id);
}
