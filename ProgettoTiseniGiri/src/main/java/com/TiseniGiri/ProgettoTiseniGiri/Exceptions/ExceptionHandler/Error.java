package com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The class representing a Spring error
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 * @see com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler.SpringExceptionResolver
 */
public class Error {
	/**
	 * The timestamp of the error
	 */
	private Timestamp timeStamp;
	/**
	 * The message to be printed
	 */
	private String message;
	/**
	 * The trace of the exception that generated the error
	 */
	private String trace;
	/**
	 * The exception that generated the error
	 */
	private Exception e;

	/**
	 * Error constructor
	 * 
	 * @param message The message to be printed
	 * @param e       The exception that generated the error
	 */
	public Error(String message, Exception e) {
		this.message = message;
		this.e = e;
	}

	/**
	 * Get the message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message
	 * 
	 * @param message The message to be printed
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the trace of the exception
	 * 
	 * @return trace
	 */
	public String getTrace() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		trace = sw.toString();
		return trace;
	}

	/**
	 * Set the trace of the exception
	 * 
	 * @param trace The trace of the exception that generated the error
	 */
	public void setTrace(String trace) {
		this.trace = trace;
	}

	/**
	 * Get the timestamp
	 * 
	 * @return timeStamp
	 */
	public Timestamp getTimeStamp() {
		Date date = new Date();
		long time = date.getTime();
		timeStamp = new Timestamp(time);
		return timeStamp;
	}

	/**
	 * Set the timestamp
	 * 
	 * @param timeStamp The timestamp of the error
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}
