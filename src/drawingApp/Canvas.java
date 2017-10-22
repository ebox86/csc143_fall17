package drawingApp;

public class Canvas {
	
	private int width;
	private int height;
	private int red;
	private int green;
	private int blue;
	
	public Canvas(){
		
	}

	public void addField(String[] keyValue) {
		String key = keyValue[0];
		int value = Integer.parseInt(keyValue[1]);
		switch(key){
		case "width":
				this.setWidth(value);
				break;
		case "height":
			this.setHeight(value);
			break;
		case "red":
			this.setRed(value);
			break;
		case "green":
			this.setGreen(value);
			break;
		case "blue":
			this.setBlue(value);
			break;
	}
		
	}

	private void setBlue(int value) {
		this.red = value;
		
	}

	private void setGreen(int value) {
		this.green = value;
		
	}

	private void setRed(int value) {
		this.red = value;
		
	}

	private void setHeight(int value) {
		this.height = value;
	}

	private void setWidth(int value) {
		this.width = value;	
	}
}
