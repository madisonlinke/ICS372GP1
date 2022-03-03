package edu.ics372.gp1.store;

public interface ItemList <T extends Matchable<K>, K>{
	public T search(K value) {
		  for (T element: elements) {
		    if (element.matches(value)) {
		      return element;
		    }
		  }
		  return null;
		}
}
