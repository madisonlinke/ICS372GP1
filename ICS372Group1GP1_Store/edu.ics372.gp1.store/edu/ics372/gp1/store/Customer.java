package edu.ics372.gp1.store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jpham
 *
 */
public class Customer {

	private String name;
	private String address;
	private String phoneNumber;
	private String id;
	private static final String CUSTOMER_STRING = "C";
	private static int idCounter;
	private List<Appliance> appliances = new ArrayList<Appliance>();// appliances owned by customer

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

	public static void save(ObjectOutputStream output) throws IOException {
		output.writeObject(idCounter);
	}

	public static void retrieve(ObjectInputStream input) throws IOException, ClassNotFoundException {
		idCounter = (int) input.readObject();
	}
}
