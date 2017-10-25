package drawingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ShapeLibrary {

	ArrayList ShpArray = new ArrayList<Shape>();
	
	public ShapeLibrary() {
		File shapeDir = new File("shapes");
		File[] folderContents = shapeDir.listFiles();
        // Deserialize
        System.out.println("Deserialization starting");
        try {
            FileInputStream shapeFile = new FileInputStream("people.ser");
            ObjectInputStream in = new ObjectInputStream(peopleFile);
            int peopleCount = (int)in.readObject();
            for (int idx = 0; idx < peopleCount; idx++) {
                collegePeople[idx] = (Person)in.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("Disk Error!");
        } catch (ClassNotFoundException e) {
            System.out.println("Internal Error!");
        }
        System.out.println("Deserialization complete\n");
	}
}
