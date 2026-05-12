package edu.pnu.edit;
import java.util.*;

public class Editor {
	private List<Object> shapes = new ArrayList<>();
	
	
	void add(Object aShape) {
		shapes.add(aShape);
	}
	
	void clear() {
		if(shapes != null)
			shapes.clear();
	}
	void list() {
		System.out.print('[');
		for(int i=0; i<shapes.size();i++) {
			if(i!=0)
				System.out.print(", ");
			System.out.print(shapes.get(i));
		}
		System.out.println(']');
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
		Editor other = (Editor) obj;
		return Objects.equals(shapes, other.shapes);
	}
	
	
}
