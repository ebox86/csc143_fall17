package Wearables;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Demo {
	public static void main(String[] args){
		Wearables myWearables = new Wearables();
		String path = Paths.get(".").toString() + "/src/wearables/";
    	File f = new File(path + "Wearables.txt");
    	
    	try {
			myWearables.loadDataFromFile(f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	//System.out.println(myWearables.toString());
    	int[] myIntArr = myWearables.getRankIndicies();
    	//myWearables.getRankReport(myIntArr);
    	System.out.println(myWearables.getRankReport(myIntArr));
	}
}
