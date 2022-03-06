/**
 * This class implements an Inventory, which stores a list of all avaiable Appliance models.
 * This class is a singleton.
 * It has the inventory and appliances fields.
 * It has the getInstance and search methods.
 */
package edu.ics372.gp1.store;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Inventory implements ItemList<Appliance, String>, Serializable{
	/**
	 * This field stores the singleton Inventory object.
	 */
	private static Inventory inventory;
	/**
	 * This field stores all Appliance objects stored in this Inventory.
	 */
	private List<Appliance> appliances = new LinkedList<Appliance>();
	
	private Inventory() {
		
	}
	/**
	 * This method creates an Inventory if none yet exists.
	 * @return either the newly created or existing inventory
	 */
	public Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
			return inventory;
		}
	}
	/**
	 * This method searches the appliances field for an Appliance object with a matching applianceID
	 * @return the matching appliance or null, if no match is found.
	 */
	@Override
	public Appliance search(String applianceID) {
		for (Appliance model: appliances) {
			if (model.matches(applianceID)) {
				return model;
			}
		}
		return null;
	}

}