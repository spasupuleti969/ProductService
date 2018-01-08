package com.sapient.products.exception;

/**
 * Exception class to throw custom user defined exception
 * 
 * @author spasup
 *
 */
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5782609368531678113L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
