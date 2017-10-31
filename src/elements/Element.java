package elements;

public class Element {
	private static int atomicNum;
	private static String symbol;
	private static String name;
	private static double atomicMass;
	
	public Element(int atomicNum, String symbol, String name, double atomicMass){
		Element.atomicNum = atomicNum;
		Element.symbol = symbol;
		Element.name = name;
		Element.atomicMass = atomicMass;
	}

	public static int getAtomicNum() {
		return atomicNum;
	}

	public static String getSymbol() {
		return symbol;
	}

	public static String getName() {
		return name;
	}

	public static double getAtomicMass() {
		return atomicMass;
	}
	
	public String toString(){
		return Element.atomicNum + " " + Element.symbol + " " + Element.name + " " + Element.atomicMass;
	}
	
}
