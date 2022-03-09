package edu.ics372.gp1.store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jpham
 *
 */
public class Customer implements Matchable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String phoneNumber;
	private String id;
	private double accountBalance;
	private static final String CUSTOMER_STRING = "C";
	private static int idCounter;
	private List<Appliance> appliances = new ArrayList<Appliance>();// appliances owned by customer
	private List<RepairPlan> repairPlansEnrolledIn = new ArrayList<RepairPlan>();

	/**
	 * Customer constructor to accept name, address, and phoneNumber. Generates new
	 * member ID off of static variable
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */
	public Customer(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		id = CUSTOMER_STRING + idCounter++;
	}

	public void addAppliance(Appliance appliance) {
		appliances.add(appliance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<RepairPlan> getRepairPlansEnrolledIn() {
		return repairPlansEnrolledIn;
	}

	public void setRepairPlansEnrolledIn(List<RepairPlan> repairPlansEnrolledIn) {
		this.repairPlansEnrolledIn = repairPlansEnrolledIn;
	}

	@Override
	public boolean matches(String customerID) {
		return this.id.equals(customerID);
	}

	// may need to modify hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", id=" + id
				+ ", accountBalance=" + accountBalance + "]" + appliances.toString();
	}

	public static void save(ObjectOutputStream output) throws IOException {
		output.writeObject(idCounter);
	}

	public static void retrieve(ObjectInputStream input) throws IOException, ClassNotFoundException {
		idCounter = (int) input.readObject();
	}
}
