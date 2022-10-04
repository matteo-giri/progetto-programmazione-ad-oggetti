package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * Class representing the exception thrown when the returned list is empty
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class EmptyListException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * EmptyListException's constructor
	 * 
	 * @param message message to log
	 */
	public EmptyListException(String message) {
		super(message);
	}

}
