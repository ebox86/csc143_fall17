package alohaAirlines;

public class Seat {

	private String seatId;
	private int row;
	private int col;
	private double price;
	private int recline;
	private String meal;
	private String confirmationId;
	
	public Seat(int row, int col, double price, int recline, String meal){
		if(price < 0.0) return;
		if(row < 0 || row > 40) return;
		if(col < 0 || col > 6) return;
		if(recline < 0) return;
		this.row = row;
		this.col = col;
		seatId = row + getCharForNum(col);
		this.price = price;
		this.meal = meal;
	}
	
	private String getCharForNum(int i) {
	    char[] alphabet = "ABCDEF".toCharArray();
	    return Character.toString(alphabet[i]);
	}
}
