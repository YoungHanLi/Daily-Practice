package edu.pnu.shape;

import java.util.Objects;

public class Circle {
	private Point center;
	private int radius;
	
	private final static float PI = 3.14f;
	
	public Circle(){
		this.center = new Point();
		this.radius = 0;
	}
	
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}
	
	public String toString() {
		String str = "[ Circle " + center + " " + radius + " " + String.format("%.6f",radius*radius*PI) + "]";
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
