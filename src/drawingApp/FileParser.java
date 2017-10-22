package drawingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

	public FileParser(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
	}

}
