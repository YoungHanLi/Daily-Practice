import java.util.*;
enum StringCommand{ ADD, REMOVE, CLEAN, QUIT, INVALID};

public class StringSetManager {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		String[] stringSet = new String[100];
		while(true) {
			final StringCommand command = getCommand(scanner);
			if(command==StringCommand.QUIT) {
				System.out.println("BYE!");break;
			}
			switch(command) {
			case ADD:{
				final String str = getString(scanner);
				executeAdd(stringSet, str);
				break;
			}
			case REMOVE:{
				final String str = getString(scanner);
				executeRemove(stringSet, str);
				break;
			}
			case CLEAN:{
				executeClear(stringSet);
				break;
			}
			default:
				System.out.println("Unknown Command!");
				break;
			}
			executePrint(stringSet);
		}
	}
	
	public static StringCommand getCommand(Scanner scanner) {
		String inStr=scanner.next();
//		inStr = inStr.toUpperCase();
		
		switch(inStr.toUpperCase()) {
		case "ADD":
			return StringCommand.ADD;
		case "REMOVE":
			return StringCommand.REMOVE;
		case "CLEAN":
			return StringCommand.CLEAN;
		case "QUIT":
			return StringCommand.QUIT;
//		default:
//			return StringCommand.INVALID;
		}
		return StringCommand.INVALID;
	}
	
	public static String getString(Scanner scanner) {
		String inStr=scanner.next();
		return inStr;
	}
	
	public static void executeAdd(String[] stringSet,final String str) {
		int i, size=0;
		
		/*
		if(stringSet[0]==null) {
			stringSet[0]=str;
			return;
		}
		*/

		for(i=0; stringSet[i]!=null && !(stringSet[i].equals("")); i++)
			size++;
		
		for(i=0; i<size; i++) {
			if(stringSet[i].equals(str)) {
				return;
			}
		}
	
		stringSet[i]=str;
	}
	
	public static void executeRemove(String[] stringSet, String str) {
		int i=0, size=0;
		
		if(stringSet[0]==null)
			return;
		else {
			for(i=0; stringSet[i]!=null && !(stringSet[i].equals("")); i++)
				size++;
		}
		
		for(i=0; i<size; i++) {
			if(stringSet[i].equals(str)) {
				for(;stringSet[i]!=null && !(stringSet[i].equals(""));i++) {
					stringSet[i]=stringSet[i+1];
				}
				return;
			}
		}
	}
	
	public static void executeClear(String[] stringSet) {
		for(int i=0; i<stringSet.length; i++)
			stringSet[i]="";
	}
	
	public static void executePrint(String[] stringSet) {
		int i=0, size=0;
		
		if(stringSet[0]==null)
			return;
		else {
		for(i=0; stringSet[i]!=null && !(stringSet[i].equals("")); i++)
			size++;
		}
		
		System.out.printf("Element Size: %d, Values = ", size);
		for(i=0; i<size; i++) {
			if(i!=0)
				System.out.print(", ");
			System.out.print(stringSet[i]);
		}
		System.out.println();
	}
}
