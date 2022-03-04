package edu.ics372.gp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public void chargePlan() {

	}

	public void enrollCustomerInRepairPlan(Customer customer) {
		subscribers.add(customer);
	}

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
