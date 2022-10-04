package com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * The Interface implemented by all the classes filtering tweets parameters with
 * a String
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public interface StringFilter {

	/**
	 * Method stringSearch search all tweets with a string parameter which is the
	 * same as "word"
	 * 
	 * @param list list to be filtered
	 * @param word string parameter used to filter list
	 * @return list of tweets
	 */
	public List<Tweet> stringSearch(List<Tweet> list, Object word);

}
