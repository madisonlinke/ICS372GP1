package edu.ics372.gp1.store;

import java.io.Serializable;

import edu.ics372.gp1.collections.Matchable;

public class Backorder implements Matchable<String>, Serializable{
	String id;
	Appliance[] appliances;
	int[] quantities;
	
	public Backorder(Appliance[] appliances, int[] quantities) {
		this.appliances = appliances;
		this.quantities = quantities;
	}
	
	@Override
	public boolean matches(String other) {
		// TODO Auto-generated method stub
		return false;
	}

	public Appliance[] getAppliances() {
		return appliances;
	}
	
	public int[] getQuantities() {
		return quantities;
	}
	
	@Override
	public String toString() {
		String print = "Backorder: " + id + "\n";
		for (int index = 0; index < appliances.length; index++) {		
			print += "Appliance: " + appliances[index].getApplianceID() + 
			" Quantity: " + quantities[index] + "\n";
		}
		return print;
	}
}