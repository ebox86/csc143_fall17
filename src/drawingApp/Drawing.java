package drawingApp;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Drawing -- used to create drawing objects, or shapes, for use on the canvas
 * @author evankoh
 *
 */
public class Drawing {
	private ShapeLibrary shapeLib;
	private ArrayList<DrawInstruction> instructions;
	private CanvasInstruction canvas;
	public Drawing(ShapeLibrary shapeLib, File file) {
		 this.shapeLib = shapeLib;
		 try {
			FileParser parser = new FileParser(file);
			instructions = parser.getInstructions();
			canvas = parser.getCanvasInstruction();
			this.shapeLib = shapeLib;
		} catch (FileNotFoundException e) {
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
			Color c = instruction.getColor();
			boolean f = instruction.getFilled();
			int oX = instruction.getRepeatOffsetX();
			int oY = instruction.getRepeatOffsetY();
			int sX = instruction.getStartingX();
			int sY = instruction.getStartingY();
			int scale = instruction.getScalePercent();
			int rotateAngle = instruction.getRotate();
			for( int i = 0; i < repeats; i++) {
				System.out.println(i);
				System.out.println(repeats);
				Polygon p = new Polygon();
				for(Point point : shape.getPoints()) {
					p.addPoint(sX + ((int)point.getX() * scale/100), sY + ((int)point.getY() * scale/100));
				}
				panel.getGraphics().setColor(c);
				panel.getGraphics().drawPolygon(p);
				if(f){
					panel.getGraphics().fill(p);
				}
				//double theta = (Math.PI * rotateAngle )/180;
				//panel.getGraphics().rotate(theta); 
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
