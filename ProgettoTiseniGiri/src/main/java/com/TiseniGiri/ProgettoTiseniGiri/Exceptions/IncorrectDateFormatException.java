package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * Class representing the exception thrown when the date given by user does not
 * match the correct format
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class IncorrectDateFormatException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * IncorrectDateFormatException's constructor
	 * 
	 * @param message message to log
	 */
	public IncorrectDateFormatException(String message) {
		super(message);
	}
}
