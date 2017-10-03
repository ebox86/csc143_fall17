package alohaAirlines;

public class MyFlight {

	public static void main(String[] args) throws Exception {
		System.out.println("### welcome to Aloha Airlines\n###\n"
				+ "### Central Booking System\n"
				+ "### (c) 1984 Aloha Airlines - Rights Reserved");

		Flight myFlight = new Flight("A11", "OHR", "SEA", "2017/01/01");		
		System.out.println(myFlight.SeatMap());
		Seat tempSeat = myFlight.getSeat(34, 5);
		System.out.println(tempSeat.toString());
		System.out.println(myFlight.getBookedCount());
		
	}

}
