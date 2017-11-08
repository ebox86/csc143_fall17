package Wearables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Wearables -- used to build, store and output a list of wearable gadgets and accessories
 * @author evan kohout
 *
 */
public class Wearables {

	private Wearable[] wearArr;
	private Integer[] rankArr;
	private double[] priceArr;
	private String[] companyArr;
	
	public Wearables() {
	}
	
	/**
	 * Takes a file of wearables as input and loads them into a wearable array, as new Wearable objects
	 * @param file
	 * @throws FileNotFoundException
	 */
	public void loadDataFromFile(File file) throws FileNotFoundException{
		int size;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			size = Integer.parseInt(br.readLine()); // first line, store for array size
			br.readLine(); // second line, discard
		    String line;
		    int pos = 0;
		    // initialize arrays
		    wearArr = new Wearable[size];
		    rankArr = new Integer[size];
		    priceArr = new double[size];
		    companyArr = new String[size];
			while ((line = br.readLine()) != null){
	            String[] fileParts = line.split("@");
	            Wearable w = new Wearable(Integer.parseInt(fileParts[0]), fileParts[1], Double.parseDouble(fileParts[2]), fileParts[3], fileParts[4], fileParts[5],
	            		fileParts[6], fileParts[7], fileParts[8], fileParts[9], fileParts[10]);
	            // generate arrays
	            wearArr[pos] = w;
	            rankArr[pos] = w.getRanking();
	            priceArr[pos] = w.getPrice();
	            companyArr[pos] = w.getCompanyName();
	            pos++;
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * returns an int array of the index values from the wearables array, sorted by rank
	 * @return the int array
	 */
	public int[] getRankIndices(){
		return new UniqueIndex<Integer>(rankArr).getArrayIndices();
	}

	/*
	 * Not implemented yet
	public void getPriceIndicies(){
		return new NonUniqueIndex<Double>(priceArr).getArrayIndicies();
	}
	*/
	
	/*
	 * Not implemented yet
	public void getCompanyIndicies(){
		
	}
	*/
	
	/**
	 * Returns a String containing a report of the wearable devices, sorted by rank
	 * @param idxArr the input array of indices
	 * @return
	 */
	public String getRankReport(int[] idxArr){
		String s = "Wearables Rank Report: \n"
				+ "Rank\tProduct Name\n"
				+ "====\t============\n";
		for(int i = 0; i < idxArr.length; i++){
			s += "#" + wearArr[idxArr[i]].getRanking() + ":\t" + wearArr[idxArr[i]].getName() + "\n";
		}
		return s;
	}
	
	/**
	 * toString method used to return a list of all wearable objects currently present
	 */
	@Override
	public String toString() {
		String s =  "Wearables [toString()=\n";
		for(int i = 0; i < wearArr.length; i++){
			s += wearArr[i].toString() + "\n";
		}
		return s;
	}
}
