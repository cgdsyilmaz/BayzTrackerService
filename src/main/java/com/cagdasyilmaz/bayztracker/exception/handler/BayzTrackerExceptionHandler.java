package com.cagdasyilmaz.bayztracker.exception.handler;

import com.cagdasyilmaz.bayztracker.alert.exception.AlertException;
import com.cagdasyilmaz.bayztracker.alert.exception.NoSuchAlertException;
import com.cagdasyilmaz.bayztracker.currency.exception.CurrencyAlreadyExistsException;
import com.cagdasyilmaz.bayztracker.currency.exception.CurrencyException;
import com.cagdasyilmaz.bayztracker.currency.exception.NoSuchCurrencyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class BayzTrackerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({CurrencyAlreadyExistsException.class})
	public ResponseEntity<Object> handleExistingCurrencyException(CurrencyAlreadyExistsException exception, WebRequest webRequest) {
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(),
			HttpStatus.CONFLICT, webRequest);
	}

	@ExceptionHandler({NoSuchCurrencyException.class, NoSuchAlertException.class})
	public ResponseEntity<Object> handleNoSuchObjectExceptions(RuntimeException exception, WebRequest webRequest) {
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}

	@ExceptionHandler({CurrencyException.class, AlertException.class})
	public ResponseEntity<Object> handleRemainingExceptions(RuntimeException exception, WebRequest webRequest) {
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
	}
}
