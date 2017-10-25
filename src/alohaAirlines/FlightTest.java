package alohaAirlines;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class FlightTest {

	/*
	 * tests a flight
	 */
	@Test
	public void FlightTest() throws Exception {
		Flight myFlight = new Flight("A1101", "OHR", "SEA", "2017/01/01");
		Assert.assertEquals(myFlight.toString(), "Flt #A1101 from OHR to SEA, 2017/01/01");
		myFlight.bookSeat(3, 3, "Guy", "093234");
		Assert.assertEquals(myFlight.getSeat(3, 3), "Seat number: 3C,  price: 10.0,  meal: Full,  recline: 6");
	}

}
