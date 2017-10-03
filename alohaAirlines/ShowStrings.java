package alohaAirlines;

public class ShowStrings {

	public static void main(String[] Args) throws Exception{
		Flight myFlight = new Flight("A11", "OHR", "SEA", "2017/01/01");
		Seat s1 = myFlight.getSeat(1, 3);
		System.out.println(s1.toString());
		System.out.println(myFlight.SeatMap());
		}

}
