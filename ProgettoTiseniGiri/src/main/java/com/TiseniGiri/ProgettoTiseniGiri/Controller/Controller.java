package com.TiseniGiri.ProgettoTiseniGiri.Controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TiseniGiri.ProgettoTiseniGiri.Services.FilterService;
import com.TiseniGiri.ProgettoTiseniGiri.Services.GeneralService;
import com.TiseniGiri.ProgettoTiseniGiri.Services.StatsService;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.UrlSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The controller used to handle the user's requests
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
@RestController
public class Controller {

	/**
	 * General method used to handle the request of a number of tweets by a topic
	 * 
	 * @param topic the topic of the tweets
	 * @param num   the number of tweets requested
	 * @return List of tweets
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("/tweets")
	public ResponseEntity<Object> getTweets(
			@RequestParam(name = "topic", defaultValue = "@UnivPoliMarche") String topic,
			@RequestParam(name = "num", defaultValue = "100") int num)
			throws JsonMappingException, JsonProcessingException {
		return new ResponseEntity<>(GeneralService.getTweets(UrlSetter.getUrl(topic, num)), HttpStatus.OK);
	}
	/**
	 * General method used to handle the request of metadata
	 * @return the metadata
	 */ 
	@GetMapping("/metadata")
	public ResponseEntity<Object> getAllMetadata(){
		return new ResponseEntity<>(GeneralService.getTheMetadata(), HttpStatus.OK);
	}

	/**
	 * Method used to handle the request of a number of filtered tweets
	 * 
	 * @param topic   the topic of the tweets
	 * @param num     the number of tweets requested
	 * @param filters the filters to apply
	 * @return List of flitered tweets
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	@PostMapping("/tweets/filter")
	public ResponseEntity<Object> getFilteredTweets(
			@RequestParam(name = "topic", defaultValue = "@UnivPoliMarche") String topic,
			@RequestParam(name = "num", defaultValue = "100") int num, @RequestBody String filters)
			throws JsonMappingException, JsonProcessingException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
			ClassNotFoundException {
		return new ResponseEntity<>(FilterService.getFilteredTweets(UrlSetter.getUrl(topic, num), filters),
				HttpStatus.OK);
	}

	/**
	 * Method used to handle the request of statistics on a number of tweets by
	 * topic
	 * 
	 * @param topic the topic of the tweets
	 * @param num   the number of tweets requested
	 * @param stats the statistics to make
	 * @return a map of statistics
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
	@PostMapping("/tweets/stats")
	public ResponseEntity<Object> getStats(@RequestParam(name = "topic", defaultValue = "@UnivPoliMarche") String topic,
			@RequestParam(name = "num", defaultValue = "100") int num, @RequestBody String stats)
			throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		return new ResponseEntity<>(StatsService.getStats(UrlSetter.getUrl(topic, num), stats), HttpStatus.OK);
	}

	/**
	 * Method used to handle the request of statistics on a number of filtered
	 * tweets
	 * 
	 * @param topic    the topic of the tweets
	 * @param num      the number of tweets requested
	 * @param requests filters and stats
	 * @return a map of statistics
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
	@PostMapping("/tweets/filter/stats")
	public ResponseEntity<Object> getFilteredStats(
			@RequestParam(name = "topic", defaultValue = "@UnivPoliMarche") String topic,
			@RequestParam(name = "num", defaultValue = "100") int num, @RequestBody String requests)
			throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		return new ResponseEntity<>(StatsService.getFilteredStats(UrlSetter.getUrl(topic, num), requests),
				HttpStatus.OK);
	}
}
