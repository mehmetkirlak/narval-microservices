package com.narval.productservice.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import com.narval.productservice.dto.ProductDto;
import com.narval.productservice.model.Product;
import com.narval.productservice.repository.ProductRepository;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> productList = repository.findAll();
        List<ProductDto> productDtoList = Arrays.asList();

        for (Product product:productList) {
            productDtoList.add(new ProductDto(product.getName(), product.getPrice()));
        }

        return productDtoList;
    }

    public ProductDto getProductById(String id) {
        Product product = repository.findById(id).orElseThrow(RuntimeException::new);
        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice());
        return productDto;
    }



}
