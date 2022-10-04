package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.IncorrectDateFormatException;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * This Class filters list of tweets in according to a given date or time
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class TimeFilter extends NumericalFilter {

	/**
	 * Date object representing the parsed date given in input by user
	 * 
	 * @see java.util.Date
	 */
	private Date userDate;
	/**
	 * Date object representing the second parsed date given in input by user when he wants to use between method
	 * 
	 * @see java.util.Date
	 */
	private Date userDate1;

	/**
	 * Date object representing the parsed date of the current tweet
	 * 
	 * @see java.util.Date
	 */
	private Date tweetDate;

	/**
	 * SimpleDateFormat object used for parsing the String object representing the
	 * current tweet's date and the String object representing the date given in
	 * input by user
	 */
	private final SimpleDateFormat twitterFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy",
			Locale.ENGLISH);

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> greater(List<Tweet> list, Object stringDate) {
		userDate = new Date();
		tweetDate = new Date();
		try {
			userDate = twitterFormatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				tweetDate = twitterFormatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new IncorrectDateFormatException("Date's format is incorrect");
			}
			if (userDate.before(tweetDate))
				list1.add(t);
		}
		return list1;
	}

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> lower(List<Tweet> list, Object stringDate) {
		userDate = new Date();
		tweetDate = new Date();
		try {
			userDate = twitterFormatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				tweetDate = twitterFormatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if (userDate.after(tweetDate))
				list1.add(t);
		}
		return list1;
	}

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> equal(List<Tweet> list, Object stringDate) {
		userDate = new Date();
		tweetDate = new Date();
		try {
			userDate = twitterFormatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				tweetDate = twitterFormatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if (userDate.equals(tweetDate))
				list1.add(t);
		}
		return list1;
	}

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> between(List<Tweet> list, Object stringDateTop, Object stringDateBottom) {
		userDate = new Date();
		tweetDate = new Date();
		try {
			userDate = twitterFormatter.parse((String) stringDateTop);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		try {
			userDate1 = twitterFormatter.parse((String) stringDateBottom);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		if (userDate.before(userDate1))
			throw new ExtremesException("The top value must be higher that the bottom value");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1 = greater(list, stringDateBottom);
		list1 = lower(list1, stringDateTop);
		return list1;
	}
}


