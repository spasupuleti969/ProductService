package com.sapient.products.service;

import org.springframework.stereotype.Service;

import com.sapient.products.model.GenericResponse;
import com.sapient.products.model.Product;

@FunctionalInterface
@Service
public interface ProductService {

	public GenericResponse<Product> populateProductDetails(String productCode);

}
