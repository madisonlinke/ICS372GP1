package edu.ics372.gp1.facade;

import java.io.Serializable;
import edu.ics372.gp1.store.*;

public class Store implements Serializable{
	private static final long serialVersionUID = 1L;
	private Inventory inventory = Inventory.getInstance();
	private BackorderList backorderList = BackorderList.getInstance();
	private CustomerList customerList = CustomerList.getInstance();
	private static Store store;
	
	private Store() {
	}
	
	public static Store getInstance() {
		if (store == null) {
			return store = new Store();
		} else {
			return store;
		}
	}
}
