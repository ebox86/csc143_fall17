package elements;

public class Element implements Comparable<Element> {
	private static int atomicNum;
	private static String symbol;
	private static String name;
	private static double atomicMass;
	
	/**
	 * Constructs a new Element object
	 * @param atomicNum
	 * @param symbol
	 * @param name
	 * @param atomicMass
	 */
	public Element(int atomicNum, String symbol, String name, double atomicMass){
		Element.atomicNum = atomicNum;
		Element.symbol = symbol;
		Element.name = name;
		Element.atomicMass = atomicMass;
	}

	/**
	 * returns atomic number of element
	 * @return
	 */
	public static int getAtomicNum() {
		return atomicNum;
	}

	/**
	 * returns symbol of element
	 * @return
	 */
	public static String getSymbol() {
		return symbol;
	}

	/**
	 * returns name of element
	 * @return
	 */
	public static String getName() {
		return name;
	}

	/**
	 * returns atomic mass of element
	 */
	public static double getAtomicMass() {
		return atomicMass;
	}
	
	/**
	 * returns a string representation of the element object
	 */
	public String toString(){
		return Element.atomicNum + " " + Element.symbol + " " + Element.name + " " + Element.atomicMass;
	}

	/**
	 * used to compare two element objects
	 */
	@Override
	public int compareTo(Element e) {
	    int cmp = Integer.compare(atomicNum, e.getAtomicNum());
	    if (cmp == 0) {
	    	cmp = symbol.compareTo(e.getSymbol());
	    }
	    if (cmp == 0) {
	    	cmp = name.compareTo(e.getName());
	    }
	    if (cmp == 0) {
	    	cmp = Double.compare(atomicMass, e.getAtomicMass());
	    }
	    return cmp;
	}
}
