package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

/**
 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter#greater(java.util.List,
 *      Object)
 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter#lower(java.util.List,
 *      Object)
 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter#equal(java.util.List,
 *      Object) 
 * Class representing the exception thrown when the parameter "par" in methods greater, lower and equal is negative
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class NegativeNumberException extends RuntimeException {

	/**
	 * serial version ID of this exception
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * NegativeNumberException's constructor
	 * 
	 * @param message message to log
	 */
	public NegativeNumberException(String message) {
		super(message);
	}

}
