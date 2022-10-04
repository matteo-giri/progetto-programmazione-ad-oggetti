package com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * The abstract class which is super type of every class realizing a numerical
 * type filter
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 * 
 */
public abstract class NumericalFilter {

	/**
	 * This method selects every tweet with a parameter greater than "par"
	 * 
	 * @param list list to be filtered 
	 * @param par parameter which is used for filtering operation
	 * @return a list of tweets
	 */
	public abstract List<Tweet> greater(List<Tweet> list, Object par);

	/**
	 * This method selects every tweet with a parameter lower than "par"
	 * 
	 * @param list list to be filtered
	 * @param par parameter who is used for filtering operation
	 * @return a list of tweets
	 */
	public abstract List<Tweet> lower(List<Tweet> list, Object par);

	/**
	 * This method selects every tweet with a parameter equal to "par"
	 * 
	 * @param list list to be filtered
	 * @param par parameter who is used for filtering operation
	 * @return a list of tweets
	 */
	public abstract List<Tweet> equal(List<Tweet> list, Object par);

	/**
	 * This method selects every tweet with a parameter which is between "top" and
	 * "bottom"
	 * 
	 * @param list list to be filtered
	 * @param top parameter who is used for filtering operation
	 * @param bottom parameter who is used for filtering operation
	 * @return a list of tweets
	 */
	public List<Tweet> between(List<Tweet> list, Object top, Object bottom) {
		if ((int) top <= (int) bottom)
			throw new ExtremesException("The top value must be higher that the bottom value");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1 = greater(list, bottom);
		list1 = lower(list1, top);
		return list1;
	}
}
