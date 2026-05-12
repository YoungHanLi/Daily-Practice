import java.util.Scanner;

enum Command{
	ADD, LIST, SUM, INVALID, QUIT
};


public class ArrayEnum {
	public static void main(String [] args) {
		int index=0;
		int [] values;
		values = new int[100];
		
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			final Command command = getCommand(scanner);
			if(command == Command.QUIT) {
				System.out.println("Bye!");
				break;
			}
			switch(command) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index]= newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index));
				break;
			case INVALID:
				System.out.println("Invalid Command");
				default: break;
			}
		}
		scanner.close();
	}
	
	public static Command getCommand(Scanner scanner) {
		String outStr = scanner.next();
		outStr = outStr.toUpperCase();
		if(outStr.equals("ADD"))
			return Command.ADD;
		else if(outStr.equals("LIST"))
			return Command.LIST;
		else if(outStr.equals("SUM"))
			return Command.SUM;
		else if(outStr.equals("QUIT"))
			return Command.QUIT;
		else
			return Command.INVALID;
	}
	
	public static int getValue(Scanner inStr) {
		int n= inStr.nextInt();
		return n;
	}
	
	public static int getSum(int[] values, int index) {
		int sum=0;
		
		for(int i=0; i<index; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	public static void printList(int[] values, int index) {
		for(int i=0; i<index; i++) {
			System.out.printf("%d ", values[i]);
		}
	}
}

