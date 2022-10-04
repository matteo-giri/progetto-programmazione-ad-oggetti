package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.StringFilter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * Class representing filters for User class parameter "name"
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */

public class UserFilter implements StringFilter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Tweet> stringSearch(List<Tweet> list, Object word) {
		ArrayList<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			if (t.getUser().getName().equals(word))
				list1.add(t);
		}
		return list1;
	}

}
