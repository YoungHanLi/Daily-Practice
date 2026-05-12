import java.util.*;

public class Line implements MyComparable{
	private final Point point1, point2;
	
	public Line() {
		this.point1 = new Point();
		this.point2 = new Point();
	}
	
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
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
		int xDistance = (point2.getX()-point1.getX());
		int yDistance = (point2.getY()-point1.getY());
		int distance = xDistance*xDistance + yDistance*yDistance;
		return (long)Math.sqrt(distance);
	}
	
	public String toString() {
		String str = "[" + this.point1.toString() + ' ' + this.point2.toString() + ' ' + Math.round(getSize()) + "]";
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point1, point2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(point1, other.point1) && Objects.equals(point2, other.point2);
	}
}
