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
	private Seat[] first;
	private Seat[] comfort;
	private Seat[] economy;
	private int firstRow;
	private int comfortRow;
	private int economyRow;
	
	/**
	 * Flight -- constructs a new Flight object
	 * @param id -- the flight number
	 * @param origin -- the flight origin
	 * @param destination -- the flight destination
	 * @param date -- the flight date
	 * @throws Exception
	 */
	public Flight (String id, String origin, String destination, String date, double basePrice) throws IllegalArgumentException {
		if(id == null || id.isEmpty()){
			throw new IllegalArgumentException("flight id must be specified");
		}
		if(origin == null || origin.isEmpty()){
			throw new IllegalArgumentException("flight origin must be specified");
		}
		if(destination == null || destination.isEmpty()){
			throw new IllegalArgumentException("flight destination must be specified");
		}
		if(origin.length() > 3){
			throw new IllegalArgumentException("flight origin airport code invalid");
		}
		if(destination.length() > 3){
			throw new IllegalArgumentException("flight destination airport code invalid");
		}
		if(date == null || date.isEmpty()){
			throw new IllegalArgumentException("flight date must be specified");
		}
		if(basePrice <= 0.0){
			throw new IllegalArgumentException("base price must be specified and > 0.0");
		}
		SimpleDateFormat sd = new SimpleDateFormat();
		this.basePrice = basePrice;
		this.id = id;
		this.origin = origin.toUpperCase();
		this.destination = destination.toUpperCase();
		this.date = date;
		this.first = new Seat[6];
		this.comfort = new Seat[8];
		this.economy = new Seat[30];
		this.firstRow = 4;
		this.comfortRow = 6;
		this.economyRow = 8;
		seatArr = new Seat[3][];
		for(int i = 0; i < economy.length; i++){
			for(int j = 0; j < economyRow; j++){
				economy[j] = new EconomySeat(i + 1, j + 1, this);
			}
		}
		for(int i = 0; i <= comfort.length; i++){
			for(int j = 0; j < comfortRow; j++){
				comfort[j] = new ComfortSeat(i + 1, j + 1, this);
			}
		}
		for(int i = 0; i <= first.length; i++){
			for(int j = 0; j < firstRow; j++){
				first[j] = new FirstClassSeat(i + 1, j + 1, this);
			}
		}
		seatArr[0] = this.economy;
		seatArr[1] = this.comfort;
		seatArr[2] = this.first;
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
	
	/**
	 * getBasePrice -- returns the basePrice of the flight
	 * @return basePrice of the flight
	 */
	public double getBasePrice(){
		return basePrice;
	}
	
	/**
	 * setBasePrice -- sets the basePrice of the flight
	 */
	public void setBasePrice(double basePrice){
		this.basePrice = basePrice;
	}
	
	/**\
	 * getSeat -- used to retrieve a individual seat by seat number
	 * @param id -- the seat number used to identify the seat
	 * @return Seat -- the requested seat
	 */
	public Seat getSeat(int row, int col, String seatClass){
		return seatArr[row - 1][col -1];
		/*
		if(seatClass == "Economy"){
			Seat tempSeatArr = seatArr[0][row];
			return tempSeatArr;
		} else if(seatClass == "Comfort") {
			Seat[] tempSeatArr = seatArr[1];
			return tempSeatArr[row - 1][col -1];
		}
		*/
	}
	
	/**
	 * bookSeat -- books a seat with a passenger an the flight
	 * @param row -- the row of the seat
	 * @param col -- the column of the seat
	 * @param name -- the name of the passenger
	 * @param code -- the confirmation code to assign to the passenger
	 * @throws Exception
	 */
	public void bookSeat(int row, int col, String name, String code, String seatClass, boolean clubMember) throws Exception {
		Seat s = null;
		if(seatClass == "Economy"){
			s = new EconomySeat(row, col, this);
		} else if (seatClass == "Comfort"){
			s = new ComfortSeat(row, col, this);
		} else {
			s = new FirstClassSeat(row, col, this);
		}
		if(s.getCustomerConfirmation() != null) {
			throw new IllegalArgumentException("seat already booked");
		}
		s.setCustomerConfirmation(name, code, clubMember);
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
