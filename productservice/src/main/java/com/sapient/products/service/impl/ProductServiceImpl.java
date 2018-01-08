package com.sapient.products.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sapient.products.exception.ProductNotFoundException;
import com.sapient.products.model.ErrorVo;
import com.sapient.products.model.GenericResponse;
import com.sapient.products.model.Product;
import com.sapient.products.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Value("${product.code}")
	private String productCode;

	@Value("${product.name}")
	private String productName;

	@Value("${product.colur}")
	private String productColor;

	@Value("${product.cost}")
	private String productCost;

	@Value("${product.type}")
	private String productType;

	@Value("${product.quantity}")
	private String productQty;

	@Value("${product.inStock}")
	private boolean isAvailable;

	@Override
	public GenericResponse<Product> populateProductDetails(String prductCode) {

		GenericResponse<Product> productResponse = new GenericResponse<Product>();
		
		try {
			// Given product code matches with the configurable product code then product
			// details from configurable file will be populated
			if (productCode.equals(prductCode)) {

				Product product = new Product();
				product.setAvailable(isAvailable);
				product.setProductColor(productColor);
				product.setProductId(productCode);
				product.setProductName(productName);
				product.setProductQty(productQty);
				product.setProductType(productType);
				productResponse.setStatusCode("200");
				productResponse.setStatusMessage("Sucess");
				productResponse.setData(product);
				
			}

			else {

				throw new ProductNotFoundException("No Product found for the given Product Id " + prductCode);
			}
		} catch (ProductNotFoundException productNotFoundException) {

			//Formation of error Vo

			productResponse.setStatusCode("404");
			productResponse.setStatusMessage("Resource Not Found");

			ErrorVo error = new ErrorVo();
			error.setErrorCode("404");
			error.setErrorMessage(productNotFoundException.getMessage());

			productResponse.setErrors(error);
			
		}

		return productResponse;
	}

}
