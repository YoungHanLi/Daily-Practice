
public class Rectangle extends Shape {
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(int width, int height) {
		super(width, height);
		setArea(computeArea());
	}
	
	public float computeArea() {
		return (float)getWidth() * (float)getHeight();
	}
	
	@Override
	public String toString() {
		return "Rectangle " + getWidth() + " " + getHeight() + " " + getArea();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
