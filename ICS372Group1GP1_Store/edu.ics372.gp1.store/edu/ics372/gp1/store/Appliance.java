//Kean Jaycox
//ICS 372 Group Project 1
package edu.ics372.gp1.store;

public abstract class Appliance implements Matchable<String>{
    
    private String brand;
    private String model;
    private double cost;
    private int stock;
    private String applianceID;
    
    @Override
    public boolean matches(String customerID) {
        return this.id.equals(customerID);
    }
    
    public Appliance(String brand, String model, double cost, int stock, String applianceID) {
        this.brand = brand;
        this.model = model;
        this.cost = cost;
        this.stock = stock;
        this.applianceID = applianceID;
    }
    
    public void addStock() {
        
    }
    
    public void removeStock() {
        
    }
    
}
