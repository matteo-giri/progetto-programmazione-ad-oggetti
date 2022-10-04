package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Arrays;

/**
 * The class representing the entities
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class Entities {

	/**
	 * Array of hashtags
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Model.Hashtag
	 */
	private Hashtag[] hashtags;

	/**
	 * Empty Entities constructor
	 */
	public Entities() {
	}

	/**
	 * Entities constructor with parameters
	 * 
	 * @param hashtags Array of hashtags
	 */
	public Entities(Hashtag[] hashtags) {
		super();
		this.hashtags = hashtags;
	}

	/**
	 * Get the array of hashtags
	 * 
	 * @return the hashtags
	 */
	public Hashtag[] getHashtags() {
		return hashtags;
	}

	/**
	 * Set the array of hashtags
	 * 
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags(Hashtag[] hashtags) {
		this.hashtags = hashtags;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "Entities [hashtags=" + Arrays.toString(hashtags) + "]";
	}

}
