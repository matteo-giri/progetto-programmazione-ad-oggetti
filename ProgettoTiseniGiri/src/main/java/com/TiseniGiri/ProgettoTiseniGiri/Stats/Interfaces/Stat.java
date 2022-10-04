package com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;


/**
 * This Interface is implemented by all the classes which realizes statistics on
 * a determined tweet's parameter
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public interface Stat {
	/**
	 * This method makes the arithmetic average of a numerical parameter in tweet's
	 * list
	 * 
	 * @param list list on which making statistic
	 * @return Double
	 */
	public Double average(List<Tweet> list);

	/**
	 * This method calculate how many times is founded a tweet with a certain value
	 * of a numerical parameter(example: Retweets,Hashtag size and Favorites)
	 * 
	 * @param list list on which making statistic
	 * @return Double
	 */
	public Double frequency(List<Tweet> list, Object num);

	/**
	 * This method makes the standard deviation of a numerical parameter in tweet's
	 * list
	 * 
	 * @param list list on which making statistics
	 * @return Double
	 */
	public Double standardDeviation(List<Tweet> list);

}
