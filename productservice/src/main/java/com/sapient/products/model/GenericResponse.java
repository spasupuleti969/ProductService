package com.sapient.products.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response POJO for sending response Object to the client
 * 
 * @author spasup
 *
 * @param <T>
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

	private String statusCode;
	private String statusMessage;

	// In case of Success data will be populated
	private T data;

	// in case of failures error VO will be populated
	private ErrorVo errors;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ErrorVo getErrors() {
		return errors;
	}

	public void setErrors(ErrorVo errors) {
		this.errors = errors;
	}

}
