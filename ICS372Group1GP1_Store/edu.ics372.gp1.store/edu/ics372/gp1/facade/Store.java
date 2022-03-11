
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
	private double salesRevenue;
	private double repairPlanRevenue;

	private Store() {
		salesRevenue = 0;
		repairPlanRevenue = 0;
	}

	public static Store getInstance() {
		if (store == null) {
			return store = new Store();
		} else {
			return store;
		}
	}

	public boolean enrollInRepairPlan(String customerID, String applianceID) {
		Customer customer = customerList.search(customerID);
		RepairPlan repairPlan = repairPlanList.search(applianceID);
		if (customer.equals(null) || repairPlan.equals(null)) {
			return false;
		} else {
			return repairPlan.enrollCustomer(customer);
		}
	}

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

	public void chargeAllRepairPlans() {
		Iterator<RepairPlan> repairPlans = repairPlanList.getRepairPlans();
		while (repairPlans.hasNext()) {
			repairPlans.next().chargePlan();
		}
	}

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
