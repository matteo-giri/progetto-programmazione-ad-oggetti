package com.TiseniGiri.ProgettoTiseniGiri.Utility;

/**
 * Class that sets the correct url for the API request
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class UrlSetter {

	/**
	 * Standard url
	 */
	private static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=@UnivPoliMarche&count=100";

	/**
	 * Get the correct url with topic and num
	 * 
	 * @param topic the topic of the tweets to get
	 * @param num   the number of tweets to get
	 * @return the url
	 */
	public static String getUrl(String topic, int num) {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + topic
				+ "&count=" + num;
		return url;
	}

}
