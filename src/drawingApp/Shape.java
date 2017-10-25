package drawingApp;

import java.io.Serializable;

public class Shape implements Serializable {

	private String id;
	private String name;
	private String email;
	
	
	public Shape(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
	}

    public void setId(String id) {
        this.id = id;
    }
	
    public String getId()     {
        return id;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
	/**
	 * Returns the name of the shape
	 * @return name of shape
	 */
	public String getName() {
		return name;
	}

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
	
	public void addPoint(Point point) {
		
		
	}



}
