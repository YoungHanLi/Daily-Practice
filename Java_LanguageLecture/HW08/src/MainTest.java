import java.util.*;

enum OperationKind { ADD, PRINTALL, PRINT, REMOVEALL, TOTALAREA, QUIT, INVALID};

public class MainTest {
	private static ShapeManager Manager = new ShapeManager();
	
	public static void main(String [] args) {
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			final OperationKind op = getOperation(scanner);
			if(op == OperationKind.QUIT) {
				//System.out.println("Bye");
				break;
			}
			if(op == OperationKind.INVALID) {
				continue;
			}
			switch(op) {
			case ADD:{
				Manager.addAshape(scanner);
				break;
			}
			case PRINT:{
				Manager.printAshape(scanner);
				break;
			}
			case REMOVEALL:
				Manager.clear();
				break;
			case PRINTALL:
				Manager.printAllShape();
				break;
			case TOTALAREA:
				Manager.printTotalArea();
				break;
			default:
				break;	
			}
		}
		scanner.close();
	}
	
	private static OperationKind getOperation(final Scanner scanner) {
		//System.out.print("Enter Operation String! ");
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
}
