package alohaAirlines2;

public class EconomySeat extends Seat {

	private double calculatedPrice;

	/**
	 * EconomySeat -- constructs a new Economy Seat (cheap seat)
	 * 
	 * @param row
	 *            the row index value of the seat
	 * @param col
	 *            the column index value of the seat
	 * @param flight
	 *            the flight the seat is associated with
	 * @throws Exception
	 */
	public EconomySeat(int row, int col, Flight flight) throws IllegalArgumentException {
		super(row, col, flight.getBasePrice(), 3, mealType.Snack, flight, classType.Economy);
	}
}