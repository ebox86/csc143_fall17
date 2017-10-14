package alohaAirlines2;

/**
 * 
 * Seat -- abstract seat class for Project2
 * @author evankoh
 * @version project 2
 */
public abstract class Seat {

	private final String seatId;
	private final int row;
	private final int col;
	private double calculatedPrice;
	private int recline;
	private mealType meal;
	private CustomerConfirmation confirmation;
	private Flight flight;
	private classType seatClass;
	
	/**
	 * Seat -- constructs s new Seat
	 * @param row -- the row index value of the seat
	 * @param col -- the column index value of the seat
	 * @param price -- the price of the seat
	 * @param recline -- the number of inches of recline room for the seat
	 * @param meal -- the meal choice for the seat
	 * @throws IllegalArgumentException
	 */
	public Seat(int row, int col, double price, int recline, mealType meal, Flight flight, classType seatClass) throws IllegalArgumentException {
		if(price <= 0.0){
			throw new IllegalArgumentException("price cannot be less than or equal to zero dollars");
		};
		if(row < 1 || row > 44){
			throw new IllegalArgumentException("seat row must be between 1 and 40, inclusive");
		};
		if(col < 1 || col > 8){
			throw new IllegalArgumentException("seat column must be between 1 and 6, inclusive");
		};
		if(recline <= 0){
			throw new IllegalArgumentException("seat cannot recline below 0 degrees");
		};
		this.row = row;
		this.col = col;
		seatId = row + getCharForNum(col);
		this.meal = meal;
		this.recline = recline;
		this.confirmation = null;
		this.flight = flight;
		this.seatClass = seatClass;
	}
	
	/**
	 * mealType -- enum which corresponds to the meal options available
	 */
	public enum mealType {
		Gourmet, Full, Snack
	}
	
	/**
	 * classType -- enum which corresponds to the class of the seat
	 */
	public enum classType {
		First, Comfort, Economy
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
		double tempPrice = 0.0;
		CustomerConfirmation tempCustomer = null;
		// check if there is a customerConfirmation set
		if(getCustomerConfirmation() != null){
			tempCustomer = getCustomerConfirmation();
		}
		// check for seatClass and club membership
		if(seatClass == seatClass.Economy){
			tempPrice = flight.getBasePrice();
			if(tempCustomer != null && tempCustomer.getClubMember()){
				// Aloha Club discount
				tempPrice -= (tempPrice * 0.02);
			}
		} else if(seatClass == seatClass.Comfort){
			tempPrice = flight.getBasePrice() * 1.5;
			if(tempCustomer != null && tempCustomer.getClubMember()){
				// Aloha Club discount
				tempPrice -= (tempPrice * 0.05);
			}
		} else if(seatClass == seatClass.First){
			tempPrice = flight.getBasePrice() * 2.0;
			if(tempCustomer != null && tempCustomer.getClubMember()){
				// Aloha Club discount
				tempPrice -= (tempPrice * 0.1);
			}
		}
		return tempPrice;
	}
	
	/**
	 * getRecline -- returns the recline value for the seat
	 * @return
	 */
	public int getRecline() {
		return recline;
	}
	
	public String getSeatId(){
		return seatId;
	}
	
	public classType getSeatClass(){
		return seatClass;
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
	public void setCustomerConfirmation(String name, String code, boolean member) throws Exception {
		confirmation = new CustomerConfirmation(name, code, member);
	}

	/**
	 * toString -- returns a string of all the seat information
	 */
	public String toString(){
		String returnString = "Seat number: " + getSeatId() + ", "
				+ " seatPrice: " + getCalculatedPrice() + ", "
				+ " meal: " + getMeal().toString() + ", "
				+ " recline: " + getRecline() + ", "
				+ " class: " + getSeatClass().toString();
		if(getCustomerConfirmation() != null){
			returnString += getCustomerConfirmation().toString();
		}
		return returnString;
	}
	
	// used to convert an integer value to its corresponding ASCII representation
	protected String getCharForNum(int i) {
	    char[] alphabet = "ABCDEFGH".toCharArray();
	    return Character.toString(alphabet[i - 1]);
	}
}