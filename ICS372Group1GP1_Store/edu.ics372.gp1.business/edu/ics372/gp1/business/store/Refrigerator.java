/**
 * Refrigerator class
 * 
 * @author Kean
 *
 */
package edu.ics372.gp1.business.store;

public class Refrigerator extends Appliance {

	private int capacity;
	private static final long serialVersionUID = 1L;

	public Refrigerator(String brand, String model, double cost, String applianceID, int capacity) {
		super(brand, model, cost, applianceID);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return this.brand + "\t" + this.model + "\t" + this.cost + "\t" + this.stock + "\t" + this.applianceID + "\t"
				+ this.capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}