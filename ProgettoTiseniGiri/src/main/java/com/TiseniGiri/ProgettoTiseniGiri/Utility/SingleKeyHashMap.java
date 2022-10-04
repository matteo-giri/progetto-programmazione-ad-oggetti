package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.HashMap;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.DuplicatedKeyException;


/**
 * Class created as an extension of class HashMap to throw exceptions when
 * there's a duplicated key in the map
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 * @param <K> key
 * @param <V> value
 */
public class SingleKeyHashMap<K, V> extends HashMap<K, V> {

	/**
	 * serial version ID of this map
	 */
	private static final long serialVersionUID = 100L;

	/**
	 * @throws DuplicatedKeyException {@inheritDoc}
	 */
	@Override
	public V put(K key, V value) {
		if (containsKey(key)) {
			throw new DuplicatedKeyException("duplicated key " + key);
		}
		return super.put(key, value);
	}
}
