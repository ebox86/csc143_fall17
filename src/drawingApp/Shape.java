package drawingApp;

import java.io.Serializable;

/**
 * drawingApp -- used to draw shapes to the canvas
 * @author evankoh
 *
 */
public class Shape implements Serializable {
	
	private static final long serialVersionUID = 9064162150981715910L;
	private String name;
	private ArrayList<Point> points;
	
	public Shape(String name) {
        setName(name);
        points = new ArrayList<Point>();
	}
    
    public void setName(String name) {
        this.name = name;
    }
    
	public void addPoint(Point point) {
		points.add(point);
	}

	public String getName() {
		return name;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
}
