package edu.ics372.gp1.store;

public class Dishwasher extends Appliance{

	private static final long serialVersionUID = 1L;

	public Dishwasher(String brand, String model, double cost, int stock, String applianceID) {
		super(brand, model, cost, stock, applianceID);
	}
	
	 @Override
	 public String toString() {
		 return this.brand + "\t" + this.model + "\t" + this.cost + "\t" + this.stock + "\t" + this.applianceID;
	 }
}