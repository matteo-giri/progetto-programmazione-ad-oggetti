package com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.*;

/**
 * The class handling the Spring exceptions
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
@ControllerAdvice
public class SpringExceptionResolver {

	/**
	 * Object of class error
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler.Error
	 */
	private Error error;

	/**
	 * Handler of a NoSuchMethodExeption
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see java.lang.NoSuchMethodException
	 */
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<Error> NoSuchMethodHandler(NoSuchMethodException e) {
		error = new Error(
				"The method you tried to reach doesn't exist, be sure you write the right method's name and right number of parameters in your request",
				e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a ClassNotFoundException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see java.lang.ClassNotFoundException
	 */
	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<Error> ClassNotFoundHandler(ClassNotFoundException e) {
		error = new Error(
				"The parameter you tried to reach doesn't exist, be sure you write the right parameter's name in your request",
				e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a ExtremesException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException
	 */
	@ExceptionHandler(ExtremesException.class)
	public ResponseEntity<Error> ExtremesExceptionHandler(ExtremesException e) {
		error = new Error("The top value must be higher that the bottom value in a between filter", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a OutOfReachException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.OutOfReachException
	 */
	@ExceptionHandler(OutOfReachException.class)
	public ResponseEntity<Error> OutOfReachExceptionHandler(OutOfReachException e) {
		error = new Error("The number of tweets you're tring to get exceeds the number of tweets found", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a NegativeNumberException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException
	 */
	@ExceptionHandler(NegativeNumberException.class)
	public ResponseEntity<Error> NegativeNumberExceptionHandler(NegativeNumberException e) {
		error = new Error("You must enter a positive number", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a ClassCastException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see java.lang.ClassCastException
	 */
	@ExceptionHandler(ClassCastException.class)
	public ResponseEntity<Error> ClassCastExceptionHandler(ClassCastException e) {
		error = new Error("You must enter the correct type for the parameters", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a IncorrectDateFormatException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.IncorrectDateFormatException
	 */
	@ExceptionHandler(IncorrectDateFormatException.class)
	public ResponseEntity<Error> IncorrectDateFormatExceptionHandler(IncorrectDateFormatException e) {
		error = new Error(
				"Date's format is incorrect, please use the following format: 'MMM dd HH:mm:ss yyyy' Ex: 'Jan 01 00:00:00 1970' ",
				e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a DuplicatedKeyException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.DuplicatedKeyException
	 */
	@ExceptionHandler(DuplicatedKeyException.class)
	public ResponseEntity<Error> DuplicatedKeyExceptionHandler(DuplicatedKeyException e) {
		error = new Error("Found duplicated keys, please make sure you put different id for each request", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler of a EmptyListException
	 * 
	 * @param e The exception that generated the error
	 * @return an error
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.EmptyListException
	 */
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<Error> EmptyListExceptionHandler(EmptyListException e) {
		error = new Error("List is empty, there are no tweets on which make stats", e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}
}
