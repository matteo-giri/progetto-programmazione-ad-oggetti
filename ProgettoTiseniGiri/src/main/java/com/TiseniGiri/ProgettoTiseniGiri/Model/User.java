package com.TiseniGiri.ProgettoTiseniGiri.Model;

/**
 * The class representing the User
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class User {

	/**
	 * The user's id
	 */
	private String id;

	/**
	 * The user's name
	 */
	private String name;

	/**
	 * The number of followers of the user
	 */
	private int followers_count;

	/**
	 * The number of friends of the user
	 */
	private int friends_count;

	/**
	 * The number of tweets the user liked
	 */
	private int favourites_count;

	/**
	 * The number of tweets created by the user
	 */
	private int statuses_count;

	/**
	 * If true, the user has a verified account
	 */
	private boolean verified;

	/**
	 * Empty User constructor
	 */
	public User() {
	}

	/**
	 * User constructor with parameters
	 * 
	 * @param id               The user's id
	 * @param name             The user's name
	 * @param followers_count  The number of followers of the user
	 * @param friends_count    The number of friends of the user
	 * @param favourites_count The number of tweets the user liked
	 * @param statuses_count   The number of tweets created by the user
	 * @param verified         If true, the user has a verified account
	 */
	public User(String id, String name, int followers_count, int friends_count, int favourites_count,
			int statuses_count, boolean verified) {
		super();
		this.id = id;
		this.name = name;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
		this.favourites_count = favourites_count;
		this.statuses_count = statuses_count;
		this.verified = verified;
	}

	/**
	 * Get the id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the id
	 * 
	 * @param id The user's id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the user's name
	 * 
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the user's name
	 * 
	 * @param name The user's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the number of followers
	 * 
	 * @return followers_count
	 */
	public int getFollowers_count() {
		return followers_count;
	}

	/**
	 * Set the number of followers
	 * 
	 * @param followers_count The number of followers of the user
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	/**
	 * Get the number of friends
	 * 
	 * @return friends_count
	 */
	public int getFriends_count() {
		return friends_count;
	}

	/**
	 * Set the number of friends
	 * 
	 * @param friends_count The number of friends of the user
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}

	/**
	 * Get the number of tweets liked by the user
	 * 
	 * @return favourites_count
	 */
	public int getFavourites_count() {
		return favourites_count;
	}

	/**
	 * Set the number of tweets liked by the user
	 * 
	 * @param favourites_count The number of tweets the user liked
	 */
	public void setFavourites_count(int favourites_count) {
		this.favourites_count = favourites_count;
	}

	/**
	 * Get the number of tweets created by the user
	 * 
	 * @return statuses_count  
	 */
	public int getStatuses_count() {
		return statuses_count;
	}

	/**
	 * Set the number of tweets created by the user
	 * 
	 * @param statuses_count The number of tweets created by the user
	 */
	public void setStatuses_count(int statuses_count) {
		this.statuses_count = statuses_count;
	}

	/**
	 * Get the verified status
	 * 
	 * @return boolean
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * Set the verified status
	 * 
	 * @param verified  If true, the user has a verified account
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", followers_count=" + followers_count + ", friends_count="
				+ friends_count + ", favourites_count=" + favourites_count + ", statuses_count=" + statuses_count
				+ ", verified=" + verified + "]";
	}
}
