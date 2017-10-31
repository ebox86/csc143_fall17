package elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		ElementList myElements = new ElementList();
    	Path p = Paths.get(".");
    	String path = p.toAbsolutePath().toString() + "/src/elements/";
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
    	System.out.println(myElements.get(1).toString());
	}

}
