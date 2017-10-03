package alohaAirlines;

import java.text.SimpleDateFormat;

import alohaAirlines.Seat.mealType;

public class Flight {
	private final String id;
	private final String origin;
	private String destination;
	private String date;
	//private SimpleDateFormat date;
	private int bookedSeatCount;
	private Seat[][] seatArr;
	
	public Flight (String id, String origin, String destination, String date) throws Exception {
		if(id == null || id.isEmpty()){
			throw new Exception("flight id must be specified");
		}
		if(origin == null || origin.isEmpty()){
			throw new Exception("flight origin must be specified");
		}
		if(destination == null || destination.isEmpty()){
			throw new Exception("flight destination must be specified");
		}
		if(origin.length() > 3){
			throw new Exception("flight origin airport code invalid");
		}
		if(destination.length() > 3){
			throw new Exception("flight destination airport code invalid");
		}
		if(date == null || date.isEmpty()){
			throw new Exception("flight date must be specified");
		}
		SimpleDateFormat sd = new SimpleDateFormat();
		this.id = id;
		this.origin = origin.toUpperCase();
		this.destination = destination.toUpperCase();
		this.seatArr = seatArr;
		this.date = date;
		seatArr = new Seat[40][6];
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 6; j++){
				Seat seat = new Seat(i + 1, j + 1, 10.0, 6, Seat.mealType.Full);
			}
		}
	}
	
	public Seat getSeat(String id){
		int row = Character.getNumericValue(id.charAt(0));
		int col = id.charAt(1) - '0';
		return seatArr[row][col];
	}
	
	public String SeatMap(){
		StringBuilder sb = new StringBuilder();
		sb.append("Flt #" + this.id + " from " + this.origin + 
				" to " + this.destination + ", " + this.date +
				"\t\tA\tB\tC\t\tD\tE\tF");
		for(int i = 0; i < 40; i++){
			sb.append(i + "\n\t");
			for(int j = 0; j < 6; j++){
				System.out.println(seatArr[i][j].toString());
				if(seatArr[i][j].getCustomerConfirmation() != null){
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
		}
		return sb.toString();
	}

	
}
