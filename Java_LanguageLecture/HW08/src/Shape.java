import java.util.Objects;

public abstract class Shape {
	private int width;
	private int height;
	private float area;
	
	public Shape() {
		this.width = 0;
		this.height = 0;
		this.area = 0;
	}
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getArea() {
		return area;
	}
	
	public void setArea(float area) {
		this.area = area; 
	}
	
	public abstract float computeArea();

	@Override
	public int hashCode() {
		return Objects.hash(area, height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Float.floatToIntBits(area) == Float.floatToIntBits(other.area) && height == other.height
				&& width == other.width;
	}
	
}
