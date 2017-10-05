package alohaAirlines;

public class Seat {

	private final String seatId;
	private final int row;
	private final int col;
	private double price;
	private int recline;
	private mealType meal;
	private CustomerConfirmation confirmation;
	
	/**
	 * Seat -- constructs s new Seat
	 * @param row -- the row index value of the seat
	 * @param col -- the column index value of the seat
	 * @param price -- the price of the seat
	 * @param recline -- the number of inches of recline room for the seat
	 * @param meal -- the meal choice for the seat
	 * @throws Exception
	 */
	public Seat(int row, int col, double price, int recline, mealType meal) throws Exception {
		if(price <= 0.0){
			throw new Exception("price cannot be less than or equal to zero dollars");
		};
		if(row < 1 || row > 40){
			throw new Exception("seat row must be between 1 and 40, inclusive");
		};
		if(col < 1 || col > 6){
			throw new Exception("seat column must be between 1 and 6, inclusive");
		};
		if(recline <= 0){
			throw new Exception("seat cannot recline below 0 degrees");
		};
		this.row = row;
		this.col = col;
		seatId = row + getCharForNum(col);
		this.price = price;
		this.meal = meal;
		this.recline = recline;
		this.confirmation = null;
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
	 * setPrice -- sets the price of a seat
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * getPrice -- returns the price of a seat
	 * @return
	 */
	public double getPrice() {
		return price;
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
				+ " price: " + this.price + ", "
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