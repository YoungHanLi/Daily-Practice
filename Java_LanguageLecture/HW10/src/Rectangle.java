import java.util.Objects;

public class Rectangle {
	private int width, height;
	
	public Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	
	public String toString() {
		String str = "Rectangle: width " + this.width + ", height " + this.height;
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
