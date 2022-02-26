package com.cagdasyilmaz.bayztracker.exception.handler;

import com.cagdasyilmaz.bayztracker.alert.exception.AlertException;
import com.cagdasyilmaz.bayztracker.alert.exception.NoSuchAlertException;
import com.cagdasyilmaz.bayztracker.currency.exception.CurrencyAlreadyExistsException;
import com.cagdasyilmaz.bayztracker.currency.exception.CurrencyException;
import com.cagdasyilmaz.bayztracker.currency.exception.NoSuchCurrencyException;
import com.cagdasyilmaz.bayztracker.user.exception.UserAlreadyExistsException;
import com.cagdasyilmaz.bayztracker.user.exception.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BayzTrackerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({CurrencyAlreadyExistsException.class, UserAlreadyExistsException.class})
	public ResponseEntity<Object> handleExistingCurrencyException(RuntimeException exception, WebRequest webRequest) {
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

	@ExceptionHandler({UserException.class})
	public ResponseEntity<Object> handleUserException(RuntimeException exception, WebRequest webRequest) {
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException exception,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request) {

		String bodyOfResponse = exception.getMessage();
		return new ResponseEntity(bodyOfResponse, headers, status);
	}
}
