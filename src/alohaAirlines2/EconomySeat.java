package alohaAirlines2;

public class EconomySeat extends Seat {

	private final String seatId;
	private final int row;
	private final int col;
	private double calculatedPrice;
	private int recline;
	private mealType meal;
	private CustomerConfirmation confirmation;
	private Flight flight;
	
	/**
	 * Seat -- constructs s new Seat
	 * @param row -- the row index value of the seat
	 * @param col -- the column index value of the seat
	 * @param price -- the price of the seat
	 * @param recline -- the number of inches of recline room for the seat
	 * @param meal -- the meal choice for the seat
	 * @throws Exception
	 */
	public EconomySeat() throws Exception {
		super(col, col, calculatedPrice, col, null, flight);
	}
	
	/**
	 * mealType -- enum which corresponds to the meal options available
	 */
	public enum mealType {
		Gourmet, Full, Snack
	}
	
	/**
	 * setMeal -- sets the mealType for a seat
	 * @param meal
	 */
	public void setMeal(mealType meal) {
		this.meal = meal;
	}
	
	/**
	 * getMeal -- returns the mealType for a seat
	 * @return
	 */
	public mealType getMeal() {
		return meal;
	}
	
	/**
	 * getPrice -- returns the price of a seat
	 * @return
	 */
	public double getCalculatedPrice() {
		return calculatedPrice;
	}
	
	/**
	 * getRecline -- returns the recline value for the seat
	 * @return
	 */
	public int getRecline() {
		return recline;
	}
	
	/**
	 * CustomerConfirmation -- returns the customer confirmation for a seat
	 * @return the confirmation object
	 */
	public CustomerConfirmation getCustomerConfirmation(){
		return this.confirmation;
	}
	
	/**
	 * setCustomerConfirmation -- sets the customer confirmation upon booking
	 * @param name -- the customer name
	 * @param code -- the confirmation code itself
	 * @throws Exception
	 */
	public void setCustomerConfirmation(String name, String code) throws Exception {
		confirmation = new CustomerConfirmation(name, code);
	}

	/**
	 * toString -- returns a string of all the seat information
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Seat number: " + this.seatId + ", "
				+ " basePrice: " + flight.getBasePrice() + ", "
				+ " meal: " + this.meal + ", "
				+ " recline: " + this.recline);
		return sb.toString();
	}
	
	// used to convert an integer value to its corresponding ASCII representation
	private String getCharForNum(int i) {
	    char[] alphabet = "ABCDEF".toCharArray();
	    return Character.toString(alphabet[i - 1]);
	}
}