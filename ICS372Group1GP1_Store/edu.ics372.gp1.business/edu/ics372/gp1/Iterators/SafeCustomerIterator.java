package edu.ics372.gp1.Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ics372.gp1.facade.Result;
import edu.ics372.gp1.store.Customer;

public class SafeCustomerIterator implements Iterator<Result> {
	private Iterator<Customer> iterator;
	private Result result = new Result();

	public SafeCustomerIterator(Iterator<Customer> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Result next() {
		if (iterator.hasNext()) {
			result.setCustomerFields(iterator.next());
		} else {
			throw new NoSuchElementException("No such element");
		}
		return result;
	}
}
