package alohaAirlines;
import java.text.SimpleDateFormat;

/**
 * Flight -- Constructs a new Flight object which composes of the plane and has all other needed items
 * @author evan kohout
 */
public class Flight {
	private final String id;
	private final String origin;
	private String destination;
	private String date;
	//private SimpleDateFormat date;
	private int bookedSeatCount;
	public Seat[][] seatArr;
	
	/**
	 * Flight -- constructs a new Flight object
	 * @param id -- the flight number
	 * @param origin -- the flight origin
	 * @param destination -- the flight destination
	 * @param date -- the flight date
	 * @throws Exception
	 */
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
		this.date = date;
		seatArr = new Seat[40][6];
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 6; j++){
				seatArr[i][j] = new Seat(i + 1, j + 1, 10.0, 6, Seat.mealType.Full);
			}
		}
	}
	
	/**
	 * getBookedCount -- returns an integer value of the number of booked seats on the flight
	 * @return
	 */
	public int getBookedCount(){
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 6; j++){
				if(seatArr[i][j].getCustomerConfirmation() != null){
					bookedSeatCount++;
				}
			}
		}
		return bookedSeatCount;
	}
	
	/**\
	 * getSeat -- used to retrieve a individual seat by seat number
	 * @param id -- the seat number used to identify the seat
	 * @return Seat -- the requested seat
	 */
	public Seat getSeat(int row, int col){
		return seatArr[row - 1][col];
	}
	
	/**
	 * SeatMap -- a pseudo-graphical representation of the currently booked seats
	 * @return String representation of plane and seats
	 */
	public String SeatMap(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nFlt #" + this.id + " from " + this.origin +
				" to " + this.destination + ", " + this.date +
				"\n\n   A B C   D E F\n");
		for(int i = 0; i < 41; i++){
			if(i != 0){
				sb.append("\n" + i + " ");
				for(int j = 0; j < 6; j++){
					if(seatArr[i-1][j].getCustomerConfirmation() != null){
						// This is some wonky looking string formatting for the seat map, but it works
						// TODO: Improve this later on
						if(j == 3){
							sb.append("  ");
						}
						if(i >= 10 && j == 0){
							sb.append("X");
						} else {
							sb.append(" X");
						}
					} else {
						if(j == 3){
							sb.append("  ");
						}
						if(i >= 10 && j == 0){
							sb.append("_");
						} else {
							sb.append(" _");
						}
					}
				}
			}
		}
		return sb.toString();
	}

	
}
