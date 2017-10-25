package drawingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ShapeLibrary {

	ArrayList<Shape> ShpArray = new ArrayList<Shape>();
	
	public ShapeLibrary() {
		File directory = new File("src/drawingApp/shapes");
		File[] shapes = directory.listFiles();
        // Deserialize
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
	            System.out.println("Disk Error!");
	        } catch (ClassNotFoundException e) {
	            System.out.println(e);
	        }
        System.out.println("Deserialization complete\n");
        }
	}
}
