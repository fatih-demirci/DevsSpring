package com.devs.devs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devs.devs.core.utilities.exceptions.BusinessException;
import com.devs.devs.core.utilities.exceptions.BusinessExceptionProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class DevsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DevsApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public BusinessExceptionProblemDetails handleBusinessException(BusinessException businessException) {
		return new BusinessExceptionProblemDetails(businessException.getMessage());
	}

}
