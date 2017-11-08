package Wearables;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 * Used to test functionality and output from the Wearables class
 * @author evan kohout
 */
public class Demo {
	public static void main(String[] args){
		// creates a new Wearables object
		Wearables myWearables = new Wearables();
		String path = Paths.get(".").toString() + "/src/wearables/";
    	File f = new File(path + "Wearables.txt");
    	
    	try {
    		// loads data file into the myWearables object
			myWearables.loadDataFromFile(f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	// tests toString output
    	//System.out.println(myWearables.toString());
    	
    	// tests the getRankIndices method and stores output to an int array
    	int[] myIntArr = myWearables.getRankIndices();
    	// passes the output from the above method as a parameter for getRankReport method
    	// tests output from getRankReport method
    	System.out.println(myWearables.getRankReport(myIntArr));
	}
}
