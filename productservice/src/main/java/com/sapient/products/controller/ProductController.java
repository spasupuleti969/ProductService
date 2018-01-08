package com.sapient.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.products.model.GenericResponse;
import com.sapient.products.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@SuppressWarnings("rawtypes")
	@GetMapping
	@RequestMapping(value = "/poduct")
	public GenericResponse getProductDetails(@RequestParam String productCode) {

		return productService.populateProductDetails(productCode);

	}

}
