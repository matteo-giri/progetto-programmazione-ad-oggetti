package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Map;

/**
 * The class representing a tweet
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class Tweet {

	/**
	 * The tweet's id
	 */
	private long id;

	/**
	 * When the tweet was created
	 */
	private String created_at;

	/**
	 * The Tweet's metadata, it contains "iso_language_code" and "result_type"
	 */
	private Map<String, String> metadata;

	/**
	 * The user who created the tweet
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Model.User
	 */
	private User user;

	/**
	 * Number of times the tweet has been retweteed
	 */
	private int retweet_count;

	/**
	 * Number of times the tweet has been liked
	 */
	private int favorite_count;

	/**
	 * The tweets detected language
	 */
	private String lang;

	/**
	 * Object that contains the tweet's entities
	 * 
	 * @see com.TiseniGiri.ProgettoTiseniGiri.Model.Entities
	 */
	private Entities entities;

	/**
	 * Empty Tweet constructor
	 */
	public Tweet() {
	}

	/**
	 * Tweet constructor with parameters
	 * 
	 * @param id             The tweet's id
	 * @param created_at     When the tweet was created
	 * @param metadata       The Tweet's metadata, it contains "iso_language_code"
	 *                       and "result_type"
	 * @param user           The user who created the tweet
	 * @param retweet_count  Number of times the tweet has been retweteed
	 * @param favorite_count Number of times the tweet has been liked
	 * @param lang           The tweets detected language
	 * @param entities       Object that contains the tweet's entities
	 */
	public Tweet(long id, String created_at, Map<String, String> metadata, User user, int retweet_count,
			int favorite_count, String lang, Entities entities) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.metadata = metadata;
		this.user = user;
		this.retweet_count = retweet_count;
		this.favorite_count = favorite_count;
		this.lang = lang;
		this.entities = entities;
	}

	/**
	 * Get the id
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the id
	 * 
	 * @param id The tweet's id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the date and time
	 * 
	 * @return the date and time the tweet has been created
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * Set the date and time
	 * 
	 * @param created_at When the tweet was created
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * Get the metadata
	 * 
	 * @return metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * Set the metadata
	 * 
	 * @param metadata The Tweet's metadata, it contains "iso_language_code"
	 */
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Return the user who created the tweet
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the user who created the tweet
	 * 
	 * @param user The user who created the tweet
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Return the number of retweets
	 * 
	 * @return retweet_count
	 */
	public int getRetweet_count() {
		return retweet_count;
	}

	/**
	 * Set the number of retweets
	 * 
	 * @param retweet_count Number of times the tweet has been retweteed
	 */
	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	/**
	 * Return the number of likes
	 * 
	 * @return favorite_count
	 */
	public int getFavorite_count() {
		return favorite_count;
	}

	/**
	 * Set the number of likes
	 * 
	 * @param favorite_count Number of times the tweet has been liked
	 */
	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	/**
	 * Return the tweet's language
	 * 
	 * @return lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Set the tweet's Language
	 * 
	 * @param lang The tweets language
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * Return the entities
	 * 
	 * @return entities
	 */
	public Entities getEntities() {
		return entities;
	}

	/**
	 * Set the entities
	 * 
	 * @param entities Object that contains the tweet's entities
	 */
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", created_at=" + created_at + ", metadata=" + metadata + ", user=" + user
				+ ", retweet_count=" + retweet_count + ", favorite_count=" + favorite_count + ", lang=" + lang
				+ ", entities=" + entities + "]";
	}
}
