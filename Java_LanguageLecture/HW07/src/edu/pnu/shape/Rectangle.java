package edu.pnu.shape;

import java.util.Objects;

public class Rectangle {
	private int width, height;
	
	public Rectangle(){
		this.width = 0;
		this.height = 0;
	}
	
	public Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		String str = "[ Rectangle " + width + " " + height + " " + String.format("%.6f",(float)(width*height)) + "]";
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return height == other.height && width == other.width;
	}
}
