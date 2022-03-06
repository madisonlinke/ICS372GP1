package edu.ics372.gp1.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Repair plan object class
 * 
 * @author jpham
 *
 */
public class RepairPlan {

	private double cost;
	private String applianceId;
	private List<Customer> subscribers = new ArrayList<Customer>();

	public RepairPlan(double cost, String applianceId, List<Customer> subscribers) {
		super();
		this.cost = cost;
		this.applianceId = applianceId;
		this.subscribers = subscribers;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	// Charges all subscribers of this plan
	public void chargePlan() {

	}

	/**
	 * Adds a customer to the list of customers subscribed to this specific plan
	 * 
	 * @param customer
	 */
	public void enrollCustomerInRepairPlan(Customer customer) {
		subscribers.add(customer);
	}

	// may need to modify hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(applianceId, cost, subscribers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepairPlan other = (RepairPlan) obj;
		return Objects.equals(applianceId, other.applianceId)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(subscribers, other.subscribers);
	}

}
