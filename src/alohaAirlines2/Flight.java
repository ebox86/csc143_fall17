package alohaAirlines2;
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
	private Seat[][] seatArr;
	private double basePrice;
	
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
				seatArr[i][j] = new Seat(i + 1, j + 1, 10.0, 6, Seat.mealType.Full, this);
			}
		}
	}
	
	/**
	 * getBookedCount -- returns an integer value of the number of booked seats on the flight
	 * @return
	 */
	public int getBookedCount(){
		int bookedSeatCount = 0;
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 6; j++){
				if(seatArr[i][j].getCustomerConfirmation() != null){
					bookedSeatCount++;
				}
			}
		}
		return bookedSeatCount;
	}
	
	public double getBasePrice(){
		return basePrice;
	}
	
	/**\
	 * getSeat -- used to retrieve a individual seat by seat number
	 * @param id -- the seat number used to identify the seat
	 * @return Seat -- the requested seat
	 */
	public Seat getSeat(int row, int col){
		return seatArr[row - 1][col - 1];
	}
	
	/**
	 * bookSeat -- books a seat with a passenger an the flight
	 * @param row -- the row of the seat
	 * @param col -- the column of the seat
	 * @param name -- the name of the passenger
	 * @param code -- the confirmation code to assign to the passenger
	 * @throws Exception
	 */
	public void bookSeat(int row, int col, String name, String code) throws Exception {
		Seat s = getSeat(row, col);
		if(s.getCustomerConfirmation() != null) {
			throw new Exception("seat already booked");
		}
		s.setCustomerConfirmation(name, code);
	}
	
	/**
	 * SeatMap -- a pseudo-graphical representation of the currently booked seats
	 * @return String representation of plane and seats
	 */
	public String seatMap(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString() + "\n\n   A B C   D E F\n");
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
	
	/**
	 * toString -- returns a string of the flight data
	 */
	public String toString(){
		return "Flt #" + this.id + " from " + this.origin +
		" to " + this.destination + ", " + this.date;
	}

	
}
