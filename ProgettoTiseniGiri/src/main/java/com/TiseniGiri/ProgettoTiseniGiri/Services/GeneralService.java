package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Metadata;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Downloader;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Parser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The general service used to retrieve the tweets without filters or stats
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class GeneralService {

	/**
	 * Method used to get all the tweets requested
	 * 
	 * @param url the url that rapresents the request to the Twitter's API
	 * @return a list of tweets
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static List<Tweet> getTweets(String url) throws JsonMappingException, JsonProcessingException {
		String data = Downloader.downloadData(url);
		List<Tweet> tweets = Parser.dataParser(data);
		return tweets;
	}

	/**
	 * Method used to obtain the metadata
	 * 
	 * @return a hashmap of metadata
	 */
	public static Object getTheMetadata() {
		return Metadata.getMetadata();
	}
}
