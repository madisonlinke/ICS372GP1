/**
 * ClothWasher class
 * 
 * @author Kean
 *
 */
package edu.ics372.gp1.store;

public class ClothWasher extends Appliance{

    private RepairPlan repairPlan;
    
    public ClothWasher(String brand, String model, double cost, int stock, String applianceID) {
        super(brand, model, cost, stock, applianceID);
    }
    
    public void enrollRepairPlan(RepairPlan repairPlan) {
        //NEEDS WORK
    }
    
    public RepairPlan getRepairPlan() {
        return this.repairPlan;
    }
    
    @Override
    public String toString() {
        return this.brand + "\t" + this.model + "\t" + this.cost + "\t" + this.stock + "\t" + this.applianceID;
    }
}
