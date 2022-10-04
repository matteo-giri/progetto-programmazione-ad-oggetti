package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.OutOfReachException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * Class used to get a certain number of tweets
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class NumberFilter {

	/**
	 * This method gets a certain number of tweets from a list of tweets
	 * 
	 * @throws NegativeNumberException
	 * @throws OutOfReachException
	 * @param list list of tweets 
	 * @param num number of tweets user wants to get
	 * @return a list of tweets
	 */
	public List<Tweet> getNumberOfTweets(List<Tweet> list, Object num) {
		if ((int) num < 0)
			throw new NegativeNumberException("You can only obtain a positive number of Tweets");
		if (list.size() < (int) num)
			throw new OutOfReachException(
					"The number of tweets you're tring to get exceeds the number of tweets found");
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (int i = 0; i < (int) num; i++)
			list1.add(list.get(i));
		return list1;
	}
}
