package edu.ics372.gp1.business.store;

public class Furnace extends Appliance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxHeatOutput;

	public Furnace(String brand, String model, double cost, int stock, String applianceID, int maxHeatOutput) {
		super(brand, model, cost, stock, applianceID);
		this.maxHeatOutput = maxHeatOutput;
	}

	public int getMaxHeatOutput() {
		return maxHeatOutput;
	}

	public void setMaxHeatOutput(int maxHeatOutput) {
		this.maxHeatOutput = maxHeatOutput;
	}

	@Override
	public String toString() {
		return "Furnace [maxHeatOutput=" + maxHeatOutput + ", brand=" + brand + ", model=" + model + ", cost=" + cost
				+ ", stock=" + stock + ", applianceID=" + applianceID + "]";
	}

}
