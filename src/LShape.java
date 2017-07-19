
public class LShape extends Shape {
	private int lowerH, lowerW;
	
	public LShape(int height, int width, int lowerH, int lowerW) {
		super(height, width);
		calculateArea();
	}
	
	public void calculateArea() {
		int area = height*width - (height-lowerH)*(width-lowerW);
		this.setArea(area);
	}
	
	public int getLowerW() {
		return lowerW;
	}
	public void setLowerW(int lowerW) {
		this.lowerW = lowerW;
	}
	public int getLowerH() {
		return lowerH;
	}
	public void setLowerH(int lowerH) {
		this.lowerH = lowerH;
	}
}
