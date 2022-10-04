package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * The executer for the services
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class ExecuterForServices {

	/**
	 * Method that executes the filters with one parameter
	 * 
	 * @param tweets    a list of tweets
	 * @param parameter the parameter you want to work with
	 * @param filter    the filter you want to execute
	 * @param par       parameter passed from the request
	 * @return a list of tweets
	 * @see java.lang.reflect.Method
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Tweet> filteredTweets = new ArrayList<Tweet>();
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getMethod(filter, List.class, Object.class);
		filteredTweets = (List<Tweet>) method.invoke(typeFilter, tweets, par);
		return filteredTweets;
	}

	/**
	 * Method that executes the filters with two parameters
	 * 
	 * @param tweets    a list of tweets
	 * @param parameter the parameter you want to work with
	 * @param filter    the filter you want to execute
	 * @param par1      parameter passed from the request
	 * @param par2      parameter passed from the request
	 * @return a list of tweets
	 * @see java.lang.reflect.Method
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par1, Object par2)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getMethod(filter, List.class, Object.class, Object.class);
		List<Tweet> filteredTweets = (List<Tweet>) method.invoke(typeFilter, tweets, par1, par2);
		return filteredTweets;
	}

	/**
	 * Method that executes the statistics with one parameter
	 * 
	 * @param tweets    a list of tweets
	 * @param parameter the parameter you want to work with
	 * @param stat      the stat you want to execute
	 * @return a double
	 * @see java.lang.reflect.Method
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public double ExecuteStat(List<Tweet> tweets, String parameter, String stat)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Stats." + parameter + "Stats");
		Object typeStat = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getMethod(stat, List.class);
		double completedStat = (double) method.invoke(typeStat, tweets);
		return completedStat;
	}

	/**
	 * Method that executes the statistics with two parameters
	 * 
	 * @param tweets    a list of tweets
	 * @param parameter the parameter you want to work with
	 * @param stat      the stat you want to execute
	 * @param par       parameter passed from the request
	 * @return a double
	 * @see java.lang.reflect.Method
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public double ExecuteStat(List<Tweet> tweets, String parameter, String stat, Object par)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Stats." + parameter + "Stats");
		Object typeStat = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getMethod(stat, List.class, Object.class);
		double completedStat = (double) method.invoke(typeStat, tweets, par);
		return completedStat;
	}
}
