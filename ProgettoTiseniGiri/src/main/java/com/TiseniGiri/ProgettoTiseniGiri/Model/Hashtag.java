package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Arrays;

/**
 * The class representing an hashtag
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class Hashtag {

	/**
	 * The hashtag's text
	 */
	private String text;

	/**
	 * The hashtag's indices, which represents an array of integers indicating the
	 * offsets within the tweet text where the hashtag begins and ends.
	 */
	private int[] indices;

	/**
	 * Empty Hashtag constructor
	 */
	public Hashtag() {
	}

	/**
	 * Hashtag constructor with parameters
	 * 
	 * @param text    The hashtag's text
	 * @param indices The hashtag's indices, witch represents an array of integers
	 *                indicating the offsets within the tweet text where the hashtag
	 *                begins and ends.
	 */
	public Hashtag(String text, int[] indices) {
		super();
		this.text = text;
		this.indices = indices;
	}

	/**
	 * Get the hashtag's text
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the hashtag's text
	 * 
	 * @param text The hashtag's text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get the indices
	 * 
	 * @return indices
	 */
	public int[] getIndices() {
		return indices;
	}

	/**
	 * Set the indices
	 * 
	 * @param indices The hashtag's indices, witch represents an array of integers
	 *                indicating the offsets within the tweet text where the hashtag
	 *                begins and ends.
	 */
	public void setIndices(int[] indices) {
		this.indices = indices;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "Hashtag [text=" + text + ", indices=" + Arrays.toString(indices) + "]";
	}

}
