package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.Comparator;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForFavorites;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForRetweets;

/**
 * Class representing filter for engagement parameters(Retweets and Favorites)
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class EngagementFilter {

	/**
	 * Object of class ComparatorForRetweets
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForRetweets
	 */
	private ComparatorForRetweets c = new ComparatorForRetweets();

	/**
	 * Object of class ComparatorForFavorites
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForFavorites
	 */
	private ComparatorForFavorites f = new ComparatorForFavorites();

	/**
	 * @see java.util.Comparator<Tweet>
	 */
	private Comparator<Tweet> cmp = c.thenComparing(f);

	/**
	 * Object of class number filter
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Filter.NumberFilter
	 */
	private NumberFilter n = new NumberFilter();

	/**
	 * This method firstly sort tweets for engagement parameters and then chooses a
	 * certain number of tweets from the list
	 * 
	 * @param list to be filtered
	 * @param num  parameter which is used for filtering operation
	 * @return list of tweets
	 */
	public List<Tweet> sortForRetweets(List<Tweet> list, Object num) {
		list.sort(cmp);
		list = n.getNumberOfTweets(list, num);
		return list;
	}

}