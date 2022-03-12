package edu.ics372.gp1.facade;

public class Result extends DataTransfer {

	public static final int APPLIANCE_NOT_FOUND = 1;
	public static final int OPERATION_COMPLETED = 2;
	public static final int OPERATION_FAILED = 3;
	public static final int NO_SUCH_CUSTOMER = 4;
	// may need additional fields here. need to discuss.

	private int resultCode;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

}
