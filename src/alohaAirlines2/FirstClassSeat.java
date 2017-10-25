package alohaAirlines2;

public class FirstClassSeat extends Seat {

	/**
	 * FirstClass -- constructs a new First Class Seat (expensive seat)
	 * 
	 * @param row
	 *            the row index value of the seat
	 * @param col
	 *            the column index value of the seat
	 * @param flight
	 *            the flight the seat is associated with
	 * @throws Exception
	 */
	public FirstClassSeat(int row, int col, Flight flight) throws IllegalArgumentException {
		super(row, col, flight.getBasePrice(), 3, mealType.Gourmet, flight, classType.First);
	}
}