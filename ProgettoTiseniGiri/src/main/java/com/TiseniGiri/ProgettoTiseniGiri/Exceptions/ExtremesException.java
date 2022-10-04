package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter#between(java.util.List,
 *      Object, Object)
 *
 *      Class representing the exception which occurs in method between when the
 *      parameter top is lower than bottom
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class ExtremesException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ExtremesException's constructor
	 * 
	 * @param errorMessage message to log
	 */
	public ExtremesException(String errorMessage) {
		super(errorMessage);
	}
}
