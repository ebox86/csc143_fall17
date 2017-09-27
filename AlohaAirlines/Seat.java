package AlohaAirlines;

public class Seat {

	private final String id;
	private int row;
	private int col;
	private double price;
	private int recline;
	private String meal;
	
	public void Seat(int row, int col, double price, int recline, String meal){
		if(price < 0.0) return;
		if(row < 0 || row > 40) return;
		if(col < 0 || col > 6) return;
		if(recline < 0) return;
	}
}
