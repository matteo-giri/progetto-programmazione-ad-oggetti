package com.TiseniGiri.ProgettoTiseniGiri;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.*;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.*;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Services.FilterService;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.*;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.UrlSetter;
import com.fasterxml.jackson.databind.JsonMappingException;
//import org.junit.rules.ExpectedException;

@SpringBootTest
class ProgettoTiseniGiriApplicationExceptionTests {
	
	private String Json;
	private String Url;
	private List<Tweet> list = new ArrayList<Tweet>();
	private FavoritesStats fav = new FavoritesStats();
	private RetweetsFilter ret = new RetweetsFilter();
	private TimeFilter time = new TimeFilter();
	private HashtagFilter hash = new HashtagFilter();
	private NumberFilter number = new NumberFilter();
	//public final ExpectedException exception = ExpectedException.none();
	
	@BeforeEach
	void setUp() throws Exception {
		Json = "{\"1\": [\"Time\",\"greater\", \"Jul 06 03:00:00 2020\"],\"1\": [\"Hashtag\",\"greater\", 5]}";
		Url = UrlSetter.getUrl("@UnivPoliMarche", 100);
	    
	}
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	
	@Test
	void duplicatedKeyTest() {
		assertThrows(JsonMappingException.class, ()->FilterService.getFilteredTweets(Url,Json));
	}
	
	@Test
	void emptyListTest() {
		assertThrows(EmptyListException.class, ()->fav.average(list));
	}
	
	@Test
	void extremesTest() {
		assertThrows(ExtremesException.class, ()->ret.between(list, 3, 5));
	}
	
	@Test
	void incorrectDateFormatTest() {
		assertThrows( IncorrectDateFormatException.class, ()->time.greater(list, "06 00:00:00 2020"));
	}
	
	@Test
	void negativeNumberTest() {
		assertThrows( NegativeNumberException.class, ()->hash.lower(list, -3));
	}
	
	@Test
	void outOfReachTest() {
		assertThrows( OutOfReachException.class, ()->number.getNumberOfTweets(list, 1000));
	}
    
}
