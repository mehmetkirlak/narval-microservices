package com.narval.customerservice.client;

import com.narval.customerservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", path = "/v1/product")
public interface ProductServiceClient {
    @GetMapping
    ResponseEntity<List<ProductDto>> getAllProducts();

    @GetMapping("/product/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable String id);

}
