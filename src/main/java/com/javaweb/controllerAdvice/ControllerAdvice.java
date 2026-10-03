package com.javaweb.controllerAdvice;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.javaweb.model.ErrorResonse;

import customexeption.FieldRequeiredException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handlerArithmeticException(ArithmeticException ex, WebRequest request){
		ErrorResonse errorResonse = new ErrorResonse();
		errorResonse.setError(ex.getMessage());
		List<String>detailsList = new ArrayList<>();
		detailsList.add("số nguyên làm sao chia đc cho 0");
		errorResonse.setErrorStrings(detailsList);
		return new ResponseEntity<>(errorResonse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(FieldRequeiredException.class)
	public ResponseEntity<Object> handlerFieldRequeiredException(FieldRequeiredException ex, WebRequest request){
		ErrorResonse errorResonse = new ErrorResonse();
		errorResonse.setError(ex.getMessage());
		List<String>detailsList = new ArrayList<>();
		detailsList.add("nam null hoặc number null kiểm tra lại");
		errorResonse.setErrorStrings(detailsList);
		return new ResponseEntity<>(errorResonse, HttpStatus.BAD_GATEWAY);
	}
}
