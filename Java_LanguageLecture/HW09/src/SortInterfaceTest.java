import java.util.*;
enum OperationKind { ADDL, ADDC, SORTA, SORTD, CLEAR, LIST ,QUIT, INVALID};
enum SortKind {ASCENDING, DESENDING};

public class SortInterfaceTest {

	private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>();
	
	public static void main(String[] args) {
		while (true) {
			final OperationKind op = getOperation(scanner);
			if(op == OperationKind.QUIT) {
				System.out.println("Bye");
				break;
			}
			if(op == OperationKind.INVALID) {
				System.out.println("Invalid Operation");
				continue;
			}
			switch(op) {
			case ADDL:{
				final Line newLine = createLine(scanner);
				comparableList.add(newLine);
				System.out.println(newLine);
				break;
			}
			case ADDC:{
				final Circle newCircle = createCircle(scanner);
				comparableList.add(newCircle);
				System.out.println(newCircle);
				break;
			}
			case SORTA:{
				sortList(comparableList, SortKind.ASCENDING);
				break;
			}
			case SORTD:{
				sortList(comparableList, SortKind.DESENDING);
				break;
			}
			case CLEAR:{
				comparableList.clear();
				break;
			}
			case LIST:{
				System.out.println(comparableList);
				break;
			}
			default: break;
			}
		}

	}
	
	private static OperationKind getOperation(final Scanner scanner) {
		System.out.print("Enter Operation String! ");
		final String operation = scanner.next();
		
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			kind = OperationKind.INVALID;
		}
		return kind;	
	}
	
	private static Line createLine(final Scanner scanner) {
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		Point point1 = new Point(x1, y1);
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		Point point2 = new Point(x2, y2);
		Line newLine = new Line(point1, point2);
		return newLine;
	}
	
	private static Circle createCircle(final Scanner scanner) {
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		Point point = new Point(x, y);
		int radius = scanner.nextInt();
		Circle newCircle = new Circle(point, radius);
		return newCircle;
	}
	
	private static void sortList(List<MyComparable> comparableList, SortKind Kind) {
		MyComparable temp;
		if(Kind == SortKind.ASCENDING) {
			for(int i=0; i<comparableList.size()-1; i++) {
				for(int j=i+1; j<comparableList.size(); j++) {
					if(comparableList.get(i).compareTo(comparableList.get(j)) > 0) {
						temp = comparableList.get(i);
						comparableList.set(i, comparableList.get(j));
						comparableList.set(j, temp);
					}
				}
			}
		}
		else if(Kind == SortKind.DESENDING) {
			for(int i=0; i<comparableList.size()-1; i++) {
				for(int j=i+1; j<comparableList.size(); j++) {
					if(comparableList.get(i).compareTo(comparableList.get(j)) < 0) {
						temp = comparableList.get(i);
						comparableList.set(i, comparableList.get(j));
						comparableList.set(j, temp);
					}
				}
			}
		}
	}
	

}
