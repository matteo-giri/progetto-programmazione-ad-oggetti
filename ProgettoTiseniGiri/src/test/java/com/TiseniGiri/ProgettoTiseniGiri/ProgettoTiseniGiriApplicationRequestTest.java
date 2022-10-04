package com.TiseniGiri.ProgettoTiseniGiri;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.*;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.*;
import com.TiseniGiri.ProgettoTiseniGiri.Model.*;

public class ProgettoTiseniGiriApplicationRequestTest {

	private Map<String, String> metadata1 = new HashMap<String, String>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		{
			put("iso_language_code", "it");
			put("result_type", "recent");
		}
	};
	private Tweet t1;
	private Tweet t2;
	private List<Tweet> list = new ArrayList<Tweet>();
	private List<Tweet> list1 = new ArrayList<Tweet>();
	private FavoritesFilter fav = new FavoritesFilter();
	private RetweetsStats ret = new RetweetsStats();
	private TimeFilter time = new TimeFilter();
	private UserFilter username = new UserFilter();
	private Date datetop;
	private Date datebottom;
	private Date datetweet;
	private final SimpleDateFormat Twitterformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy",Locale.ENGLISH);


	@BeforeEach
	void setUp() throws Exception {
		t1 = new Tweet((long) 1, "Mon Jul 06 02:00:00 +0000 2020", metadata1,
				new User("1234", "Antonio Fiore", 200, 57, 1300, 700, false), 5, 3, "it", new Entities(new Hashtag[] {
						new Hashtag("ciao", new int[] { 3, 4 }), new Hashtag("salve", new int[] { 7, 5 }) }));
		t2 = new Tweet((long) 1, "Sun Jul 05 05:00:00 +0000 2020", metadata1,
				new User("1234", "Andrea Caporaletti", 100, 153, 2356, 911, false), 12, 8, "it",
				new Entities(new Hashtag[] { new Hashtag("grandecapo", new int[] { 3, 4 }) }));
		list.add(t2);
		list.add(t1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void lowerTest() {
		list1 = fav.lower(list, 7);
		assertTrue(list1.get(0).getFavorite_count() < 7);
	}

	@Test
	void greaterTest() {
		list1 = fav.greater(list, 7);
		assertTrue(list1.get(0).getFavorite_count() > 7);
	}

	@Test
	void betweenTest() {
		list1 = fav.between(list, 7, 2);
		assertTrue(list1.get(0).getFavorite_count() < 7 && list1.get(0).getFavorite_count() > 2);
	}
	
	@Test
	void equalTest() {
		list1 = fav.equal(list, 3);
		assertTrue(list1.get(0).getFavorite_count() == 3);
	}
	
	@Test
	void timeTest() throws ParseException {
		list1 = time.between(list, "Tue Jul 07 05:00:00 +0000 2020" , "Sun Jul 05 21:00:00 +0000 2020");
		datetop = Twitterformatter.parse("Tue Jul 07 05:00:00 +0000 2020");
		datebottom = Twitterformatter.parse("Sun Jul 05 21:00:00 +0000 2020");
		datetweet = Twitterformatter.parse(list1.get(0).getCreated_at());
		assertTrue(datetweet.after(datebottom) && datetweet.before(datetop));
	}
	
	@Test
	void userTest() {
		list1 = username.stringSearch(list, "Antonio Fiore");
		assertTrue(list1.get(0).getUser().getName().equals("Antonio Fiore"));
	}
	
	@Test
	void averageTest() {
		assertEquals(8.5, ret.average(list));
	}

	@Test
	void frequencyTest() {
		assertEquals(1, ret.frequency(list, 12));
	}

	@Test
	void standardDeviationTest() {
		assertEquals(3.5, ret.standardDeviation(list));
	}

}
