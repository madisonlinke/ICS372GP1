package edu.ics372.gp1.business.store;

public class KitchenRange extends Appliance {
	public KitchenRange(String brand, String model, double cost) {
		super(brand, model, cost);
	}

	public String toString() {
		return this.brand + "\t" + this.model + "\t" + this.cost + "\t" + this.stock + "\t" + this.applianceID;
	}
}
