/**
 * Appliance class
 * 
 * @author Kean
 *
 */
package edu.ics372.gp1.business.store;

import java.io.Serializable;

import edu.ics372.gp1.business.collections.Matchable;

public abstract class Appliance implements Matchable<String>, Serializable {
    
    protected String brand;
    protected String model;
    protected double cost;
    protected int stock;
    protected String applianceID;
    
    @Override
    public boolean matches(String customerID) {
        return this.applianceID.equals(customerID);
    }
    
    public Appliance(String brand, String model, double cost, int stock, String applianceID) {
        this.brand = brand;
        this.model = model;
        this.cost = cost;
        this.stock = stock;
        this.applianceID = applianceID;
    }
    
    public void addStock(int quantity) {
        stock += quantity;
    }
    
    public void removeStock(int quantity) {
    	if (stock < quantity) {
    		throw new IllegalArgumentException("Stock cannot be less than 0.");
    	}
        stock -= quantity;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

    public String getApplianceID() {
        return applianceID;
    }
    
}
