package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.Comparator;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * @see java.util.Comparator
 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.EngagementFilter 
 * 
 * Class is used to create a comparator object which will be used in class 
 * EngagementFilter to sort tweets in a specific order
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class ComparatorForFavorites implements Comparator<Tweet> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(Tweet tweet1, Tweet tweet2) {
		return (tweet2.getFavorite_count() - tweet1.getFavorite_count());
	}

}
