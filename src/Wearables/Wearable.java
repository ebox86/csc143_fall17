package Wearables;

/**
 * Wearable -- creates a new wearable item used to describe a wearable product
 * @author Evan Kohout - project 5
 *
 */
public class Wearable {
	private String ranking;
	private String name;
	private double price;
	private String bodyLocation;
	private String category;
	private String companyName;
	private String companyURL;
	private String companyAddress;
	private String companyCity;
	private String companyState;
	private String companyCountry;
	
	/**
	 * generates a new wearable item
	 * @param ranking - rank of the item
	 * @param name - name of the wearable product
	 * @param price - price of the product
	 * @param bodyLocation - location where item is worn
	 * @param category - category item is part of
	 * @param companyName - company that produced the item
	 * @param companyURL - web address of the company
	 * @param companyAddress - address of the company
	 * @param companyCity - the city or locality of the company
	 * @param companyState - the state or providence of the company
	 * @param companyCountry - the country of origin of the company
	 */
	public Wearable(String ranking, String name, double price, String bodyLocation, String category, String companyName,
			String companyURL, String companyAddress, String companyCity, String companyState, String companyCountry) {
		this.ranking = ranking;
		this.name = name;
		this.price = price;
		this.bodyLocation = bodyLocation;
		this.category = category;
		this.companyName = companyName;
		this.companyURL = companyURL;
		this.companyAddress = companyAddress;
		this.companyCity = companyCity;
		this.companyState = companyState;
		this.companyCountry = companyCountry;
	}

	///////////////////////////////////////
	// GETTERS
	///////////////////////////////////////
	
	public String getRanking() {
		return ranking;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getBodyLocation() {
		return bodyLocation;
	}

	public String getCategory() {
		return category;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyURL() {
		return companyURL;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}
	
	///////////////////////////////////////
	// SETTERS
	///////////////////////////////////////

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setBodyLocation(String bodyLocation) {
		this.bodyLocation = bodyLocation;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyURL(String companyURL) {
		this.companyURL = companyURL;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}
	
	

}
