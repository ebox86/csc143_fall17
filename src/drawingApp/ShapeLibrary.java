package drawingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import drawingApp.Shape;

public class ShapeLibrary {

	private ArrayList<Shape> ShpArray = new ArrayList<Shape>();
	
	public ShapeLibrary() {
		Path path = Paths.get(System.getProperty("user.dir") + "/shapes");
		File directory = new File(path.toAbsolutePath().toString());
		File[] shapes = directory.listFiles();
       
        System.out.println("Deserialization starting");
        for (File file : shapes) {
      
	        try {
	            FileInputStream shapeFile = new FileInputStream(file);
	            System.out.println("file input");
	            ObjectInputStream in = new ObjectInputStream(shapeFile);
	            System.out.println("object input");
	            ShpArray.add((Shape)in.readObject());
	            System.out.println("add to array");
	            in.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("File Not Found!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            System.out.println(e);
	            //e.printStackTrace();
	        }
     
        }
        
        System.out.println("Deserialization complete\n");
	}

	public ArrayList<Shape> getShapeArray() {
		// TODO Auto-generated method stub
		return ShpArray;
	}
}
