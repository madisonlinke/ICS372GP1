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
public class RepairPlan implements Matchable<String>, Serializable{

	private double cost;
	private String applianceID;
	private List<Customer> subscribers = new ArrayList<Customer>();

	public RepairPlan(double cost, String applianceID, List<Customer> subscribers) {
		super();
		this.cost = cost;
		this.applianceID = applianceID;
		this.subscribers = subscribers;
	}

	// Charges all subscribers of this plan
	public void chargePlan() {

	}

	/**
	 * Adds a customer to the list of customers subscribed to this specific plan
	 * 
	 * @param customer
	 */
	public void enrollCustomer(Customer customer) {
		subscribers.add(customer);
	}
	
	@Override
	public boolean matches(String customerID) {
		return this.applianceID.equals(customerID);
	}

	// may need to modify hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(applianceID, cost, subscribers);
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
		return Objects.equals(applianceID, other.applianceID)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(subscribers, other.subscribers);
	}

	@Override
	public String toString() {
		return "RepairPlan [cost=" + cost + ", applianceId=" + applianceID + ", subscribers=" + subscribers.toString()
				+ "]";
	}

	// need to implement save
}
