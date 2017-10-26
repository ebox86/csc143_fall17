package drawingApp;

import java.awt.Polygon;
import java.io.File;
import java.io.FileNotFoundException;

public class Drawing {
	private ShapeLibrary shapeLib;
	private ArrayList<DrawInstruction> instructions;
	private CanvasInstruction canvas;
	public Drawing(ShapeLibrary shapeLib, File file) {
		 shapeLib = shapeLib;
		 try {
			FileParser parser = new FileParser(file);
			instructions = parser.getInstructions();
			canvas = parser.getCanvasInstruction();
			this.shapeLib = shapeLib;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block Oh noooooo 
			e.printStackTrace();
		}
	
	}

	public void draw() {
		DrawingPanel panel = new DrawingPanel();
		panel.setBackground(canvas.getColorSolid());
		panel.setHeight(canvas.getHeight());
		panel.setWidth(canvas.getWidth());
		for(DrawInstruction instruction : instructions) {
		
			Shape shape = getShapeByName(instruction.getShapeName());
			int repeats = instruction.getRepeats();
			instruction.getColor();
			instruction.getFilled();
			int oX = instruction.getRepeatOffsetX();
			int oY = instruction.getRepeatOffsetY();
			int sX = instruction.getStartingX();
			int Sy = instruction.getStartingY();
			instruction.getScalePercent();
			for( int i =0; i < repeats; i ++ ) {
				Polygon p = new Polygon();
				for(Point point : shape.getPoints()) {
					p.addPoint((int)point.getX() + sX + oX, (int)point.getY() + sX + oY);
				}
				panel.getGraphics().drawPolygon(p);
			}
			
		
			
		}
		
	}
	
	private Shape getShapeByName(String name) {
		for(Shape shape : shapeLib.getShapeArray()) {
			if(shape.getName().equals(name)) {
				return shape;
			}
		}
		return null;
	}
	

}
