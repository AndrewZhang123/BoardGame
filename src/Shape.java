
public abstract class Shape {
	protected int height, width, area;
	
	public Shape(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public abstract void calculateArea();
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
}
