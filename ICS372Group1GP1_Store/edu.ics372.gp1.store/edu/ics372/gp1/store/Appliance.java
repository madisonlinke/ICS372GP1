/**
 * Appliance class
 * 
 * @author Kean
 *
 */
package edu.ics372.gp1.store;

public abstract class Appliance implements Matchable<String>{
    
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
    
    public void addStock() {
        //NEEDS WORK
    }
    
    public void removeStock() {
        //NEEDS WORK
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
