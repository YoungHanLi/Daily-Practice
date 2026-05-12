package solution;
import java.util.*;

public class RectangleMainStream {

	public static void main(String[] args) {
		List<Rectangle> list0 = new ArrayList<>();
		for(int i=0; i<10; i++) {
			Rectangle r = new Rectangle(i+10, i+10);
			list0.add(r);
		}
		
		list0.stream()
		.filter(element0 -> element0.getArea() >= 200)
		.filter(element1 -> element1.getWidth() % 2 == 0)
		.map(element2 -> element2.getName().toUpperCase())
		.forEach(element3 -> System.out.println(element3));

	}

}
