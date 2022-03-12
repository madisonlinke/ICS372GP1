package edu.ics372.gp1.business.collections;

/**
 * 
 * Matchable interface for generic object comparisons.
 * 
 * @author jpham
 *
 * @param <K>
 */
public interface Matchable<K> {

	boolean matches(K other);

}
