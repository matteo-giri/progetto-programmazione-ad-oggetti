package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * Class representing the exception thrown when the requested number of tweets
 * is higher than the actual tweets' number
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class OutOfReachException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * OutOfReachException's constructor
	 * 
	 * @param message message to log
	 */
	public OutOfReachException(String message) {
		super(message);
	}
}
