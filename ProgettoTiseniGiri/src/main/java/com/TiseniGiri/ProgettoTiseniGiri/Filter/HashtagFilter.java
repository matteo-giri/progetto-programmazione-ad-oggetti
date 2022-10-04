package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.*;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * Class realizing filters for the Hashtag parameter
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class HashtagFilter extends NumericalFilter implements StringFilter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tweet> greater(List<Tweet> list, Object num) {
		if ((int) num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of hashtags");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t -> t.getEntities().getHashtags().length <= (int) num);
		return list1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tweet> lower(List<Tweet> list, Object num) {
		if ((int) num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of hashtags");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t -> t.getEntities().getHashtags().length >= (int) num);
		return list1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tweet> equal(List<Tweet> list, Object num) {
		if ((int) num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of hashtags");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t -> t.getEntities().getHashtags().length != (int) num);
		return list1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tweet> stringSearch(List<Tweet> list, Object word) {
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			boolean flag = false;
			for (int i = 0; i < t.getEntities().getHashtags().length; i++) {
				if (String.valueOf(word).equals(t.getEntities().getHashtags()[i].getText()))
					flag = true;
			}
			if (flag)
				list1.add(t);
		}
		return list1;
	}

}
