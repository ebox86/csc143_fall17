package drawingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

	public FileParser(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\n");
        
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Scanner s2 = new Scanner(line);
            s2.useDelimiter(",");
            if(line.contains("width")){
            	Canvas c = new Canvas();
            	while(s2.hasNext()){
            		String kvpCanvas = s2.next();
            		c.addField(kvpCanvas.split("="));
            	}
            } else {
            	while(s2.hasNext()){
            		
            	}
            }
        }
        scanner.close();
	}

}
