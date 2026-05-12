import java.util.*;

public class RectangleManager {

	private List<Rectangle> rectangles = new ArrayList<>();
	private Scanner scannerObject;
	
	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in);
		RectangleManager manager = new RectangleManager(scannerObject);
		while(true) {
			System.out.println("Enter a command:[create width height, zoom id ratio or quit]");
			final String command = scannerObject.next();
			if(command.equalsIgnoreCase("create")) { manager.create(); }
			else if(command.equalsIgnoreCase("zoom")) { manager.zoom(); }
			else if(command.equalsIgnoreCase("showAll")) { manager.showAll(); }
			else if(command.equalsIgnoreCase("quit")) { System.out.println("Bye"); break;}
		}
		scannerObject.close();
		
	}
	
	public RectangleManager(Scanner scannerObject){
		this.scannerObject = scannerObject;
	}
	
	public void create() {
		try {
			int width = this.scannerObject.nextInt();
			int height = this.scannerObject.nextInt();
			if(width <= 0 || height <=0)	throw new InvalidRectangleException(width, height);
			Rectangle newRectangle = new Rectangle(width, height);
			rectangles.add(newRectangle);
			System.out.print(newRectangle.toString());
			System.out.print(" is added at ");
			System.out.println(rectangles.size() - 1);
		}
		catch(InputMismatchException e1) {
			System.out.println("입력된 인자의 형식이 맞지 않습니다.");
		}
		catch(InvalidRectangleException exception) {
			System.out.print("사각형의 넓이와 높이는 양수이어야 합니다.");
			System.out.println(exception.getWidth() + " " + exception.getHeight());	
		}
	}
	
	public void zoom() {
		try {
			int index = this.scannerObject.nextInt();
			int mutiple = this.scannerObject.nextInt();
			
			Rectangle beforeRectangle = rectangles.get(index);
			System.out.println("Before: " + beforeRectangle);
			int width = mutiple*(rectangles.get(index).getWidth());
			int height = mutiple*(rectangles.get(index).getHeight());
			Rectangle zoomedRectangle = new Rectangle(width, height);
			rectangles.remove(index);
			rectangles.add(index, zoomedRectangle);
			System.out.println("After: " + zoomedRectangle);			
		}
		catch(IndexOutOfBoundsException exception) {
			System.out.print("존재하지 않는 배열의 원소를 접근했습니다.");
			System.out.println(exception);
		}
	}
	
	public void showAll() {
		for(Rectangle aRectangle : rectangles)
			System.out.println(aRectangle);
	}

}
