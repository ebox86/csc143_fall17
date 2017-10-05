package alohaAirlines2;

/**
 * CustomerConfirmation -- creates a new CustomerConfirmation object
 * @author Evan Kohout
 *
 */
public class CustomerConfirmation {
	private String customerName;
	private String confirmationCode;
	private double bookedPrice;
	
	/**
	 * CustomerConfirmation -- saves a booked flight and bounds it to a seat
	 * @param customerName
	 * @param confirmationCode
	 * @throws Exception
	 */
	public CustomerConfirmation(String customerName, String confirmationCode) throws Exception {
		if(customerName == null || customerName.isEmpty()){
			throw new Exception("customer name cannot be empty");
		}
		if(confirmationCode == null || confirmationCode.isEmpty()){
			throw new Exception("confirmation code must be passed");
		}
		this.customerName = customerName;
		this.confirmationCode = confirmationCode;
	}
	
	/** 
	 * toString -- overridden toString method
	 */
	public String toString(){
		return "customer confirmation: " + this.confirmationCode + ", customer name: " + this.customerName;
	}
}