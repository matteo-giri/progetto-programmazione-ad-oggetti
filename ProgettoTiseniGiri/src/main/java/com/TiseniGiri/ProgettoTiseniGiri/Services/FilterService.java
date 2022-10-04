package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.SingleKeyHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The service used to filter a list of tweets
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class FilterService extends GeneralService {

	/**
	 * Object of class ExecuterForServices
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices
	 */
	static ExecuterForServices executer = new ExecuterForServices();

	/**
	 * Method used to filter a list of tweets
	 * 
	 * @param url     the url that represents the request to the Twitter's API
	 * @param filters string representing the filters to do
	 * @return a list of filtered tweets
	 * @see #filterCycler(Map, List)
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public static List<Tweet> getFilteredTweets(String url, String filters) throws JsonMappingException,
			JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Tweet> tweets = getTweets(url);

		SingleKeyHashMap<String, List<Object>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(filters, SingleKeyHashMap.class);

		return filterCycler(request, tweets);
	}

	/**
	 * Method used to cycle thru each filter
	 * 
	 * @param filters string representing the filters to do
	 * @param tweets  list of tweets retrieved from the API
	 * @return a list of tweets
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices#ExecuteFilter(List,
	 *      String, String, Object)
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices#ExecuteFilter(List,
	 *      String, String, Object, Object)
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static List<Tweet> filterCycler(Map<String, List<Object>> filters, List<Tweet> tweets)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		for (Map.Entry<String, List<Object>> entry : filters.entrySet()) {
			String parameter = entry.getValue().get(0).toString();
			String filter = entry.getValue().get(1).toString();

			if (entry.getValue().size() == 3)
				tweets = executer.ExecuteFilter(tweets, parameter, filter, entry.getValue().get(2));
			else
				tweets = executer.ExecuteFilter(tweets, parameter, filter, entry.getValue().get(2),
						entry.getValue().get(3));
		}

		return tweets;
	}

}
