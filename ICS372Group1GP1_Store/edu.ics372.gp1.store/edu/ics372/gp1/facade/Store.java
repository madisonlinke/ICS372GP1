
package edu.ics372.gp1.facade;

import java.io.Serializable;
import java.util.Iterator;

import edu.ics372.gp1.store.BackorderList;
import edu.ics372.gp1.store.Customer;
import edu.ics372.gp1.store.CustomerList;
import edu.ics372.gp1.store.Inventory;
import edu.ics372.gp1.store.RepairPlan;
import edu.ics372.gp1.store.RepairPlanList;

public class Store implements Serializable {
	private static final long serialVersionUID = 1L;
	private Inventory inventory = Inventory.getInstance();
	private BackorderList backorderList = BackorderList.getInstance();
	private CustomerList customerList = CustomerList.getInstance();
	private RepairPlanList repairPlanList = RepairPlanList.getInstance();
	private static Store store;
	private double salesRevenue = 0;
	private double repairPlanRevenue = 0;

	/**
	 * Private constructor for this singleton class.
	 */
	private Store() {
	}

	/**
	 * Creates an instance of the Store class, if the singleton field is null.
	 * @return the store field, whether it is created 
	 */
	public static Store getInstance() {
		if (store == null) {
			return store = new Store();
		} else {
			return store;
		}
	}

	/**
	 * Adds a given customer (by ID) to a repair plan's (by appliance ID) list of subscribers
	 * @param customerID
	 * @param applianceID
	 * @return true if customer successfully enrolled in the plan
	 */
	public boolean enrollInRepairPlan(String customerID, String applianceID) {
		Customer customer = customerList.search(customerID);
		RepairPlan repairPlan = repairPlanList.search(applianceID);
		if (customer.equals(null) || repairPlan.equals(null)) {
			return false;
		} else {
			return repairPlan.enrollCustomer(customer);
		}
	}

	/**
	 * Removes a given customer (by ID) to a repair plan's (by appliance ID) list of subscribers
	 * @param customerID
	 * @param applianceID
	 * @return true if customer successfully removed from the plan
	 */
	public boolean withdrawFromRepairPlan(String customerID, String applianceID) {
		Customer customer = customerList.search(customerID);
		RepairPlan repairPlan = repairPlanList.search(applianceID);
		if (customer.equals(null) || repairPlan.equals(null)) {
			return false;
		} else {
			repairPlan.enrollCustomer(customer);
			return true;
		}
	}

	/**
	 * Charges each customer for every repair plan, adding the cost to the customer's account balance
	 * and the store's repair plan revenue
	 */
	public void chargeAllRepairPlans() {
		Iterator<RepairPlan> repairPlans = repairPlanList.getRepairPlans();
		while (repairPlans.hasNext()) {
			repairPlans.next().chargePlan();
		}
	}

	/**
	 * Adds a given amount, the cost for a repair plan, to the store's repair plan revenue.
	 * @param cost
	 */
	public void addRepairPlanRevenue(double cost) {
		repairPlanRevenue += cost;
	}

	// needs testing
	public void listAllCustomers() {
		customerList.listAll();
	}

	public void listAllCustomersRepairPlans() {
		repairPlanList.listAll();
	}
}