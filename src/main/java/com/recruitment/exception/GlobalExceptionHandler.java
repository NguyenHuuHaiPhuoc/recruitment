package com.recruitment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.recruitment.dto.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(value = Exception.class)
	ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
		
		ApiResponse apiResponse = new ApiResponse(0, null, null, null, null);
		apiResponse.setStatus(400);
		apiResponse.setMessage(exception.getMessage());
		
		return ResponseEntity.badRequest().body(apiResponse);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(value = AppException.class)
	ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
		
		ErrorCode errorCode = exception.getErrorCode();
		
		ApiResponse apiResponse = new ApiResponse(0, null, null, null, null);
		apiResponse.setStatus(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());
		
		return ResponseEntity.badRequest().body(apiResponse);
	}
}
