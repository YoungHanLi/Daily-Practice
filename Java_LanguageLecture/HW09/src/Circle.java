import java.util.*;

public class Circle implements MyComparable{
	private final Point center;
	private final int radius;
	
	public Circle() {
		this.center = new Point();
		this.radius = 0;
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public int compareTo(final MyComparable other) {
		if(getSize() > other.getSize())
			return 1;
		else if(getSize() == other.getSize())
			return 0;
		else
			return -1;
	}
	
	public long getSize() {
		return (long)(radius*radius*Math.PI);
	}
	
	public String toString() {
		String str = "[" + this.center.toString() + ' ' + radius + ' ' + getSize() + "]";
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(center, radius);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Objects.equals(center, other.center) && radius == other.radius;
	}
}
