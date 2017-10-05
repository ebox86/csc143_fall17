package alohaAirlines;

public class MyFlight {

	/*
	 * This is a test class which is used to show the supplier code working
	 * with some dummy data i have added
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("### welcome to Aloha Airlines\n###\n"
				+ "### Central Booking System\n"
				+ "### (c) 1984 Aloha Airlines - Rights Reserved");

		Flight myFlight = new Flight("A1101", "OHR", "SEA", "2017/01/01");
		System.out.println(myFlight.toString());
		myFlight.bookSeat(3, 3, "Guy", "093234");
		myFlight.bookSeat(1, 4, "Guy", "093234");
		myFlight.bookSeat(30, 6, "bill", "123123");
		System.out.println(myFlight.seatMap());
		Seat tempSeat = myFlight.getSeat(3, 3);
		System.out.println(tempSeat.toString());
		System.out.println(tempSeat.getCustomerConfirmation().toString());
		System.out.println(tempSeat.toString());
		System.out.println(myFlight.getBookedCount());
		
	}

}
