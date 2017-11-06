package elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ElementList myElements = new ElementList();
    	String path = Paths.get(".").toString() + "/src/elements/";
    	File f = new File(path + "elements.txt");
    	
    	try {
			myElements.loadDataFromFile(f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	/*
    	 while(myElements.iterator().hasNext()){
    	 
    		Element e = myElements.iterator().next();
    		System.out.println(e.toString());
    	}
    	*/
    	//System.out.println(myElements.toString());
    	System.out.println(myElements.toString());
    	myElements.sortedAdd(new Element(200, "T", "Testium", 0.011));
    	System.out.println(myElements.size());
    	System.out.println(myElements.toString());
    	//System.out.println(myElements.get(10).toString());
	}

}
