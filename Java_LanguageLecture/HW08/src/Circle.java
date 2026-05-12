import java.util.Objects;

public class Circle extends Shape{
	private final static float PI = 3.141592f;
	
	private Point center;
	private int radius;
	
	public Circle() {
		//super();
		this.center = new Point();
		this.radius = 0;
	}
	
	public Circle(Point center, int radius) {
		//super();
		this.center = center;
		this.radius = radius;
		setArea(computeArea());
	}
	
	public float computeArea() {
		return PI * (float)radius * (float)radius;
	}
	
	@Override
	public String toString() {
		return "Circle " + center + " " + getArea();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(center, radius);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Objects.equals(center, other.center) && radius == other.radius;
	}
}
