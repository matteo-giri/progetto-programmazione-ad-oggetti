package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.SingleKeyHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The service used to make statistics on a list of tweets
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class StatsService extends GeneralService {

	/**
	 * Object of class ExecuterForServices
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices
	 */
	static ExecuterForServices executer = new ExecuterForServices();

	/**
	 * Method used to make stats on a non-filtered list of tweets
	 * 
	 * @param url   the url that represents the request to the Twitter's API
	 * @param stats string representing the stats to make
	 * @return a map of statistics
	 * @see #statCycler(Map, List)
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
	public static Map<String, List<String>> getStats(String url, String stats) throws JsonMappingException,
			JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		List<Tweet> tweets = getTweets(url);

		SingleKeyHashMap<String, List<Object>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(stats, SingleKeyHashMap.class);

		return statCycler(request, tweets);
	}

	/**
	 * Method used to make stats on a filtered list of tweets
	 * 
	 * @param url      the url that represents the request to the Twitter's API
	 * @param requests String representing the filters and the stats to make
	 * @return a map of statistics
	 * @see #statCycler(Map, List)
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
	public static Map<String, List<String>> getFilteredStats(String url, String requests) throws JsonMappingException,
			JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		SingleKeyHashMap<String, List<Object>> filters = null;
		SingleKeyHashMap<String, List<Object>> stats = null;

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.readValue(requests, ObjectNode.class);
		filters = mapper.readValue(node.get("filters").toString(), SingleKeyHashMap.class);
		stats = mapper.readValue(node.get("stats").toString(), SingleKeyHashMap.class);
		String filterString = mapper.writeValueAsString(filters);
		List<Tweet> filteredTweets = FilterService.getFilteredTweets(url, filterString);

		return statCycler(stats, filteredTweets);
	}

	/**
	 * Method used to cycle thru each stat
	 * 
	 * @param stats          map of stats to make
	 * @param filteredTweets list of tweets already filtered
	 * @return a map of statistics
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices#ExecuteStat(List,
	 *      String, String)
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Services.ExecuterForServices#ExecuteStat(List,
	 *      String, String, Object)
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Map<String, List<String>> statCycler(Map<String, List<Object>> stats, List<Tweet> filteredTweets)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		Map<String, List<String>> completedStats = new HashMap<String, List<String>>();

		for (Map.Entry<String, List<Object>> entry : stats.entrySet()) {
			String parameter = entry.getValue().get(0).toString(); //parameter on which make the stat
			String stat = entry.getValue().get(1).toString(); // type of stat to be done
			List<String> list = new ArrayList<String>();
			list.add(parameter);
			list.add(stat);
			if (entry.getValue().size() == 2)
				list.add(String.valueOf(executer.ExecuteStat(filteredTweets, parameter, stat)));
			else
				list.add(
						String.valueOf(executer.ExecuteStat(filteredTweets, parameter, stat, entry.getValue().get(2))));
			completedStats.put(entry.getKey(), list);
		}

		return completedStats;
	}
}
