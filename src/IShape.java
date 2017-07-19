
public class IShape extends Shape {
	
	public IShape(int height, int width) {
		super(height, width);
		calculateArea();
	}
	
	public void calculateArea() {
		int area = height*width;
		this.setArea(area);
	}
}
