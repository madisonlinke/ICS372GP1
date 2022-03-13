package edu.ics372.gp1.business.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

import edu.ics372.gp1.business.facade.Request;
import edu.ics372.gp1.business.facade.Result;
import edu.ics372.gp1.business.facade.Store;

public class TesterUI {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static TesterUI testerUI;
	private static Store s1 = Store.getInstance();
	private int applianceType;

	private TesterUI() {

	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static TesterUI instance() {
		if (testerUI == null) {
			return testerUI = new TesterUI();
		} else {
			return testerUI;
		}
	}

//	private String applianceBrand;
//	private String applianceModel;
//	private String applianceID;
//	private double applianceCost;
//	private int applianceStock;
	public void addAppliance() {
		Request.instance().setApplianceBrand(getName("Enter Appliance Brand"));
		Request.instance().setApplianceModel(getName("Enter Appliance Model"));
		Request.instance().setApplianceCost(getDouble("Enter Cost"));
		System.out.println("1 = furnace");
		System.out.println("2 = Refrigerator");
		applianceType = getInt("Enter Appliance Type");

		switch (applianceType) {
		case 1:
			addFurnace();
			break;
		case 2:
			addRefrigerator();
			break;
		case 3:
			addKitchenRange();
			break;
		}

	}

	public void addFurnace() {
		Request.instance().setMaxHeatOutput(Integer.parseInt(getName("Enter Max Heat Output")));
		Result result = s1.addFurnace(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED) {
			System.out.println("Could not add member");
		} else {
			System.out.println(result.getCustomerName() + "'s id is " + result.getCustomerID());
		}
	}

	public void addRefrigerator() {
		Request.instance().setCapacity(Integer.parseInt(getName("Enter Capacity")));
		Result result = s1.addAppliance(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED) {
			System.out.println("Could not add member");
		} else {
			System.out.println(result.getApplianceModel() + "'s id is " + result.getApplianceID());
		}
	}

	public void addKitchenRange() {

		Result result = s1.addKitchenRange(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED) {
			System.out.println("Could not add member");
		} else {
			System.out.println(result.getApplianceModel() + "'s id is " + result.getApplianceID());
		}
	}

	public void addClothDryer() {

	}

	public void addNewCustomer() {
		Request.instance().setCustomerName(getName("Enter member name"));
		Request.instance().setCustomerAddress(getName("Enter address"));
		Request.instance().setCustomerPhoneNumber(getName("Enter phone"));
		Result result = s1.addCustomer(Request.instance());
		if (result.getResultCode() != Result.OPERATION_COMPLETED) {
			System.out.println("Could not add member");
		} else {
			System.out.println(result.getCustomerName() + "'s id is " + result.getCustomerID());
		}
	}

	public void purchaseModels() {
		do {
			Request.instance().setApplianceID(getName("Enter the appliance ID."));
			Request.instance().setBackorderQuantity(getInt("Enter the quantity to order."));
		} while (yesOrNo("Would you like to order another appliance?"));
	}

	public String getName(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				return line;
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);

	}

	public double getDouble(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer number = Integer.valueOf(item);
				return number.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	public int getInt(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer number = Integer.valueOf(item);
				return number.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	public void getCustomer() {
		Iterator<Result> iterator = s1.getCustomers();
		System.out.println("List of members (name, address, phone, id)");
		while (iterator.hasNext()) {
			Result result = iterator.next();
			System.out.println(result.getCustomerName() + " " + result.getCustomerAddress() + " "
					+ result.getCustomerPhoneNumber() + " " + result.getCustomerID());
		}
		System.out.println("End of listing");
	}

	public void process() {
		s1.addCustomer("Joe", "123 fake st", "5555555555");
		s1.addCustomer("Moe", "123 fake st", "5555555555");
		System.out.println(s1.getCustomers());
		Iterator<Result> itr = s1.getCustomers();

		getCustomer();
		addAppliance();
	}

	private boolean yesOrNo(String prompt) {
		String more = getName(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TesterUI.instance().process();
	}
}
