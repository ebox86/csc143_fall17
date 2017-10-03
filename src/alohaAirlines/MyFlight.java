package alohaAirlines;

public class MyFlight {

	public static void main(String[] args) throws Exception {
		System.out.println("### welcome to Aloha Airlines\n###\n"
				+ "### Central Booking System\n"
				+ "### (c) 1984 Aloha Airlines - Rights Reserved");

		Flight myFlight = new Flight("A11", "OHR", "SEA", "2017/01/01");		
		System.out.print(myFlight.SeatMap());
	}
	

}
