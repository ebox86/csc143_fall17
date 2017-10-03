package alohaAirlines;

public class Seat {

	private final String seatId;
	private final int row;
	private final int col;
	private double price;
	private int recline;
	private mealType meal;
	private String confirmationId;
	private CustomerConfirmation confirmation;
	
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
	
	public enum mealType {
		Gourmet, Full, Snack
	}
	
	public CustomerConfirmation getCustomerConfirmation(){
		return this.confirmation;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Seat number: " + this.seatId + ", "
				+ " price: " + this.price + ", "
				+ " meal: " + this.meal + ", "
				+ " recline: " + this.recline);
		return sb.toString();
	}
	
	private String getCharForNum(int i) {
	    char[] alphabet = "ABCDEF".toCharArray();
	    return Character.toString(alphabet[i - 1]);
	}
}