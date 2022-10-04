package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * @see com.TiseniGiri.ProgettoTiseniGiri.Utility.SingleKeyHashMap 
 * Class representing the exception of two identical keys in the same SingleKeyHashMap
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class DuplicatedKeyException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 6L;

	/**
	 * DuplicatedKeyException's constructor
	 * 
	 * @param message message to log
	 */
	public DuplicatedKeyException(String message) {
		super(message);
	}

}
