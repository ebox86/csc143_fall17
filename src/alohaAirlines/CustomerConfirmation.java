package alohaAirlines;

public class CustomerConfirmation {
	private String customerName;
	private String confirmationCode;
	
	public CustomerConfirmation(String customerName, String confirmationCode) throws Exception {
		if(customerName != null && !customerName.isEmpty()){
			throw new Exception("customer name cannot be empty");
		}
		if(confirmationCode != null && !confirmationCode.isEmpty()){
			throw new Exception("confirmation code must be passed");
		}
		this.customerName = customerName;
		this.confirmationCode = confirmationCode;
	}
}