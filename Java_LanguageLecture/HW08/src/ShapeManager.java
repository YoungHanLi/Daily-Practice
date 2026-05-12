import java.util.*;

public class ShapeManager {
	private List<Shape> shapes = new ArrayList<>();
	
	public void addList(Shape newShape) {
		if(newShape instanceof Shape)
			shapes.add(newShape);
	}
	
	public void addAshape(final Scanner scanner) {
		/*final Scanner scanner = new Scanner(System.in);*/
		final String shapeType = scanner.next();
		final Shape newShape;
		switch(shapeType.toUpperCase()) {
		case "T":
			newShape = createTriangle(scanner);
			break;
		case "C":
			newShape = createCircle(scanner);
			break;
		case "R":
			newShape = createRectangle(scanner);
			break;
		default:
			return;
		}
		System.out.println(newShape);
		addList(newShape);
	}
	
	public void printAshape(final Scanner scanner) {
		if(1>shapes.size()) {
			System.out.println("None");
			return;
		}
		final String shapeType = scanner.next();
		switch(shapeType.toUpperCase()) {
		case "T":
			printAllTriangle();
			break;
		case "C":
			printAllCircle();
			break;
		case "R":
			printAllRectangle();
			break;
		default:
			break;
		}
	}
	
	public void printAllShape() {
		if(1>shapes.size()) {
			System.out.println("None");
			return;
		}
		for(int i=0; i<shapes.size();i++) {
			System.out.println(shapes.get(i));
		}
	}
	
	public void printTotalArea() {
		float total = 0f;
		for(int i=0; i<shapes.size();i++)
			total += shapes.get(i).getArea();
		System.out.println(total);
	}
	
	public void clear() {
		int clearedNum = shapes.size();
		if(shapes != null)
			shapes.clear();
		System.out.println(clearedNum);
	}

	public Shape createTriangle(final Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		
		Triangle newShape = new Triangle(width, height);
		return newShape;
	}
	
	public Shape createRectangle(final Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		
		Rectangle newShape = new Rectangle(width, height);
		return newShape;
	}
	
	public Shape createCircle(final Scanner scanner) {
		final int xpos = scanner.nextInt();
		final int ypos = scanner.nextInt();
		final int radius = scanner.nextInt();
		
		Point center = new Point(xpos, ypos);
		Circle newShape = new Circle(center, radius);
		return newShape;
	}
	
	public void printAllTriangle() {
		int count = 0;
		for(int i=0; i<shapes.size(); i++) {
			if(shapes.get(i) instanceof Triangle) {
				System.out.println(shapes.get(i));
				count++;
			}
		}
		if(count == 0)
			System.out.println("None");
	}
	
	public void printAllCircle() {
		int count = 0;
		for(int i=0; i<shapes.size(); i++) {
			if(shapes.get(i) instanceof Circle) {
				System.out.println(shapes.get(i));
				count++;
			}
				
		}
		if(count == 0)
			System.out.println("None");
	}
	
	public void printAllRectangle() {
		int count = 0;
		for(int i=0; i<shapes.size(); i++) {
			if(shapes.get(i) instanceof Rectangle) {
				System.out.println(shapes.get(i));
				count++;
			}
		}
		if(count == 0)
			System.out.println("None");
	}

	@Override
	public int hashCode() {
		return Objects.hash(shapes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShapeManager other = (ShapeManager) obj;
		return Objects.equals(shapes, other.shapes);
	}
	
}
