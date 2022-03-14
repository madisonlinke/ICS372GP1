package edu.ics372.gp1.business.store;

public class DishWasher extends Appliance{

	private static final long serialVersionUID = 1L;

	public DishWasher(String brand, String model, double cost, String applianceID) {
		super(brand, model, cost, applianceID);
	}
	
	 @Override
	 public String toString() {
		 return this.brand + "\t" + this.model + "\t" + this.cost + "\t" + this.stock + "\t" + this.applianceID;
	 }
}