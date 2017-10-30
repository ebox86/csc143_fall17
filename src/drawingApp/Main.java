package drawingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    
	/**
	 * Main class for drawing app
	 * @param args
	 */
    public static void main(String[] args) {
    	/*
    	Utility utility = new Utility();
    	try {
			utility.createShapeLib();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    	Path folderPath = Paths.get(".");
    	String path = folderPath.toAbsolutePath().toString() + "/src/drawingApp/";
        ShapeLibrary shapeLib  = new ShapeLibrary();
        //Drawing drawing1 = new Drawing(shapeLib, new File(path + "Instruct-Simple.txt"));
        //Drawing drawing2 = new Drawing(shapeLib, new File(path + "Instruct-Rand.txt"));
        Drawing drawing3 = new Drawing(shapeLib, new File(path + "Instruct-RepeatOffset.txt"));
        //Drawing drawing4 = new Drawing(shapeLib, new File(path + "Instruct-Gradient.txt"));
        //Drawing drawing5 = new Drawing(shapeLib, new File(path + "Instruct-Rotate.txt"));
        
        //drawing5.draw();
        //drawing4.draw();
        drawing3.draw();
        //drawing2.draw();
        //drawing1.draw();
    }
   
}
