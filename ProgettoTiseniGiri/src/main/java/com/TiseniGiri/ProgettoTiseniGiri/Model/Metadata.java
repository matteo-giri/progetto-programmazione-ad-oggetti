
package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Class who models and gives metadata to the user
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class Metadata {
	/**
	 * A map which contains all the metadata of the tweets
	 */
	private static TreeMap<String, String[]> tweetMetadata = new TreeMap<String, String[]>() {
		/**
		 * serial version ID of map
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", new String[] { "Description: tweet's id", "type:long" });
			put("created_at",
					new String[] { "Description: the date in which the tweet was posted on the page", "type:String" });
			put("metadata", new String[] {
					"Description: map containing the two fields, iso_language_code, and result_type(recent,mixed or popular) ",
					"type:Map<String><String>" });
			put("user",
					new String[] {
							"Description: an object containing information about the user who posted a specific tweet",
							"type:Object" });
			put("retweet_count",
					new String[] { "Description: count of retweets of the current tweet", "type:Integer" });
			put("favorite_count",
					new String[] { "Description: count of favorites of the current tweet", "type:Integer" });
			put("lang", new String[] { "Description: language of tweet text", "type:String" });
			put("entities", new String[] { "Description: an object containing an array of hashtags", "type:Object" });
		}
	};
	/**
	 * A map which contains all the metadata of the user
	 */
	private static TreeMap<String, String[]> userMetadata = new TreeMap<String, String[]>() {
		/**
		 * serial version ID of map
		 */
		private static final long serialVersionUID = 2L;

		{
			put("id", new String[] { "Description: user's id", "type:String" });
			put("name", new String[] { "Description: user's name and surname ", "type:String" });
			put("followers_count",
					new String[] { "Description: the number of follwers of the users ", "type:Integer" });
			put("friends_count", new String[] { "Description: the number of friends of the users ", "type:Integer" });
			put("favourites_count", new String[] { "Description: number of tweet's the user liked", "type:Integer" });
			put("statuses_count", new String[] { "Description: number of tweets created by the user", "type:Integer" });
			put("verified", new String[] { "Description: tells if the user has a verified account", "type:boolean" });
		}
	};
	/**
	 * A map which contains all the metadata of the hashtags
	 */
	private static TreeMap<String, String[]> hashtagsMetadata = new TreeMap<String, String[]>() {
		/**
		 * serial version ID of map
		 */
		private static final long serialVersionUID = 3L;

		{
			put("text", new String[] { "Description: text of the hashtag", "type:String" });
			put("indices", new String[] {
					"Description:  they indicates the offsets within the tweet text where the hashtag begins and ends. ",
					"type: Array of Integers" });
		}
	};

	/**
	 * The Map which contains all the metadata
	 */
	private static HashMap<String, TreeMap<String, String[]>> Metadata = new HashMap<String, TreeMap<String, String[]>>() {
		/**
		 * serial version Id of map
		 */
		private static final long serialVersionUID = 4L;

		{
			put("Tweet's Metadata", tweetMetadata);
			put("User's Metadata", userMetadata);
			put("Hashtag's Metadata", hashtagsMetadata);

		}
	};

	/**
	 * method used to get metadata
	 * 
	 * @return a HashMap of three maps of metadata
	 */
	public static HashMap<String, TreeMap<String, String[]>> getMetadata() {
		return Metadata;
	}

}