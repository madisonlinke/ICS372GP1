package edu.ics372.gp1.Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ics372.gp1.business.facade.Result;
import edu.ics372.gp1.business.store.RepairPlan;

public class SafeRepairPlanIterator implements Iterator<Result> {
	private Iterator<RepairPlan> iterator;
	private Result result = new Result();

	public SafeRepairPlanIterator(Iterator<RepairPlan> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Result next() {
		if (iterator.hasNext()) {
			result.setRepairPlanFields(iterator.next());
		} else {
			throw new NoSuchElementException("No such element");
		}
		return result;
	}
}