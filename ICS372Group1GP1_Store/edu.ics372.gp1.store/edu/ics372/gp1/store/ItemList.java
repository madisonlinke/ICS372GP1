package edu.ics372.gp1.store;

public interface ItemList<T extends Matchable<K>, K> {
	/**
	 * Checks if a given value matches the identifier for an item stored in this
	 * list. Returns the item if found, otherwise, null is returned.
	 * 
	 * @param value
	 * @return
	 */
	public T search(K value);

	public String listAll();
}