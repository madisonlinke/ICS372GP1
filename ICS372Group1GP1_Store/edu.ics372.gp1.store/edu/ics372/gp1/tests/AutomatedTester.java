package edu.ics372.gp1.tests;

import edu.ics372.gp1.store.Customer;

public class AutomatedTester {
	private Store store;
	private String[] names = { "n1", "n2", "n3" };
	private String[] addresses = { "a1", "a2", "a3" };
	private String[] phones = { "p1", "p2", "p3" };
	private Customer[] customers = new Customer[3];
	private String[] ids = { "i1", "i2", "i3", "i4", "i5", "i6" };
	private Appliance[] appliances = new Appliance[6];

	/**
	 * Tests Member creation.
	 */
	// need to modify below more for testing.
	public void testAddCustomer() {
		for (int count = 0; count < customers.length; count++) {
			Request.instance().setCustomerAddress(addresses[count]);
			Request.instance().setCustomerName(names[count]);
			Request.instance().setCustomerPhone(phones[count]);
			Result result = store.instance().addCustomer(Request.instance());
			assert result.getResultCode() == Result.OPERATION_COMPLETED;
			assert result.getCustomerName().equals(names[count]);
			assert result.getCustomerPhone().equals(phones[count]);
		}
	}

	public void testAddBook() {
		for (int count = 0; count < books.length; count++) {
			Request.instance().setBookAuthor(authors[count]);
			Request.instance().setBookTitle(titles[count]);
			Request.instance().setBookId(ids[count]);
			Result result = Library.instance().addBook(Request.instance());
			assert result.getResultCode() == Result.OPERATION_COMPLETED;
			assert result.getBookTitle().equals(titles[count]);
			assert result.getBookId().equals(ids[count]);
		}
	}

	public void testSearchMembership() {
		Request.instance().setMemberId("M1");
		assert Library.instance().searchMembership(Request.instance()).getMemberId().equals("M1");
		Request.instance().setMemberId("M4");
		assert Library.instance().searchMembership(Request.instance()) == null;
	}

	public void testAll() {
		testAddMember();
		testAddBook();
		testSearchMembership();
	}

	public static void main(String[] args) {
		new AutomatedTester().testAll();
	}

}
