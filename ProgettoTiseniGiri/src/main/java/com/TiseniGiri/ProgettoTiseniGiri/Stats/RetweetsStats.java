package com.TiseniGiri.ProgettoTiseniGiri.Stats;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.EmptyListException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces.Stat;

/**
 * Class used to obtain statistics on the parameter Reetwets_count in a given
 * tweets's list
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class RetweetsStats implements Stat {

	/**
	 * @throws EmptyListException {@inheritDoc}
	 */
	@Override
	public Double average(List<Tweet> list) {
		if (list.isEmpty())
			throw new EmptyListException("List is empty, there are no tweets on which make stats");
		Double sum = 0.0;
		for (Tweet t : list) {
			sum += t.getRetweet_count();
		}
		return (sum / (double) list.size());
	}

	/**
	 * @throws EmptyListException {@inheritDoc}
	 */
	@Override
	public Double frequency(List<Tweet> list, Object num) {
		if (list.isEmpty())
			throw new EmptyListException("List is empty, there are no tweets on which make stats");
		int count = 0;
		for (Tweet t : list) {
			if (t.getRetweet_count() == (int) num)
				count++;
		}
		return (double) count;
	}

	/**
	 * @see #average(List)
	 * @throws EmptyListException {@inheritDoc}
	 */
	@Override
	public Double standardDeviation(List<Tweet> list) {
		if (list.isEmpty())
			throw new EmptyListException("List is empty, there are no tweets on which make stats");
		Double avg = average(list);
		Double sum = 0.0;
		for (Tweet t : list) {
			sum += Math.pow((t.getRetweet_count() - avg), 2.0);
		}
		return Math.sqrt(sum / list.size());
	}

}
