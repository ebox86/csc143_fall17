package Wearables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Wearables {

	private Wearable[] wearArr;
	private Integer[] rankArr;
	private double[] priceArr;
	private String[] companyArr;
	
	public Wearables() {
	}
	
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] getRankIndicies(){
		return new UniqueIndex<Integer>(rankArr).getArrayIndicies();
	}

	public void getPriceIndicies(){
		
	}
	
	public void getCompanyIndicies(){
		
	}
	
	public String getRankReport(int[] idxArr){
		String s = "Wearables Rank Report: ";
		for(int i = 0; i < idxArr.length; i++){
			s += wearArr[idxArr[i]].toString() + "\n";
		}
		return s;
	}
	
	@Override
	public String toString() {
		String s =  "Wearables [toString()=\n";
		for(int i = 0; i < wearArr.length; i++){
			s += wearArr[i].toString() + "\n";
		}
		return s;
	}
}
