package edu.ics372.gp1.facade;

// unsure how this matches library example. It appears to not be as reliant on 
import edu.ics372.gp1.store.Appliance;
import edu.ics372.gp1.store.Customer;
import edu.ics372.gp1.store.RepairPlan;

public abstract class DataTransfer {

	private String customerName;
	private String customerAddress;
	private String customerPhoneNumber;
	private String customerId;
	private double customerAccountBalance;
	private String applianceBrand;
	private String applianceModel;
	private String applianceID;
	private double applianceCost;
	private int applianceStock;
	private double repairPlanCost;
	private String repairPlanApplianceID;

	// needs repairplan fields

	/**
	 * This sets all fields to "none".
	 */
	public DataTransfer() {
		reset();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getCustomerAccountBalance() {
		return customerAccountBalance;
	}

	public void setCustomerAccountBalance(double customerAccountBalance) {
		this.customerAccountBalance = customerAccountBalance;
	}

	public void setCustomerFields(Customer customer) {
		customerName = customer.getName();
		customerAddress = customer.getAddress();
		customerPhoneNumber = customer.getPhoneNumber();
		customerId = customer.getId();
		customerAccountBalance = customer.getAccountBalance();
	}

	public String getApplianceBrand() {
		return applianceBrand;
	}

	public void setApplianceBrand(String applianceBrand) {
		this.applianceBrand = applianceBrand;
	}

	public String getApplianceModel() {
		return applianceModel;
	}

	public void setApplianceModel(String applianceModel) {
		this.applianceModel = applianceModel;
	}

	public String getApplianceID() {
		return applianceID;
	}

	public void setApplianceID(String applianceID) {
		this.applianceID = applianceID;
	}

	public double getApplianceCost() {
		return applianceCost;
	}

	public void setApplianceCost(double applianceCost) {
		this.applianceCost = applianceCost;
	}

	public int getApplianceStock() {
		return applianceStock;
	}

	public void setApplianceStock(int applianceStock) {
		this.applianceStock = applianceStock;
	}

	public void setApplianceFields(Appliance appliance) {
		applianceBrand = appliance.getBrand();
		applianceModel = appliance.getModel();
		applianceID = " ";// what is appliance ID going to be?
		applianceCost = appliance.getCost();
		applianceStock = appliance.getStock();
	}

	public void setRepairPlanFields(RepairPlan repairPlan) {
		// needs work
		repairPlanCost = repairPlan.getCost();
		repairPlanApplianceID = repairPlan.getApplianceID();
	}

	/**
	 * Sets all String fields to "none"
	 */
	public void reset() {
		name = "No such customer";
		address = "No such customer";
		phoneNumber = "No such customer";
		id = "Invalid customer id";
		accountBalance = 0;
		brand = "No such model";
		model = "No such model";
		cost = 0;
		stock = 0;
		applianceID = "No such model";

	}
}
