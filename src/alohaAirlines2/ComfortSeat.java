package alohaAirlines2;

public class ComfortSeat extends Seat {

	/**
	 * ComfortSeat -- constructs a new Comfort Seat (mid-range seat)
	 * 
	 * @param row
	 *            the row index value of the seat
	 * @param col
	 *            the column index value of the seat
	 * @param flight
	 *            the flight the seat is associated with
	 * @throws IllegalArgumentException
	 */
	public ComfortSeat(int row, int col, Flight flight) throws IllegalArgumentException {
		super(row, col, flight.getBasePrice(), 6, mealType.Full, flight, classType.Comfort);
	}
}