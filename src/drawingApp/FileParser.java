package drawingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	private CanvasInstruction canvasInstruction;
	public CanvasInstruction getCanvasInstruction() {
		return canvasInstruction;
	}
	public void setCanvasInstruction(CanvasInstruction canvas) {
		this.canvasInstruction = canvas;
	}
	public ArrayList<DrawInstruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(ArrayList<DrawInstruction> instructions) {
		this.instructions = instructions;
	}
	private ArrayList<DrawInstruction> instructions;
	
	public FileParser(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\n");
        instructions = new ArrayList<DrawInstruction>();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Scanner s2 = new Scanner(line);
            if(line.contains("width")){
            	canvasInstruction = CanvasInstruction.readFromFile(s2);
            } else {
            	//System.out.println(line);
            	DrawInstruction instruction = DrawInstruction.readFromFile(s2);
            	instructions.add(instruction);
            	//System.out.println(instructions.size());
            }
        }
        scanner.close();
	}

}
