//201824552_HW5
//SchoolTest.java

import java.util.*;

enum OperationKind{
	ADD, FIND, CLEAR, LIST, INVALID, QUIT;
}

public class SchoolTest {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		School pnu = new School("PNU", 100);
		while(true) {
			final OperationKind op = getOperation();
			if(op == OperationKind.QUIT) {
				System.out.println("Bye");
				break;
			}
			if(op == OperationKind.INVALID) {
				System.out.println("Invalid Operation!");
				continue;
			}
			switch(op) {
			case ADD:{
				Student newStudent = createStudent();
				pnu.addStudent(newStudent);
				break;
			}
			case FIND:{
				findStudent(pnu);
				break;
			}
			case CLEAR:{
				pnu.removeAllStudent();
				break;
			}
			case LIST:{
				System.out.println(pnu);
				break;
			}
			default: 
				break;
			}
		}
	}
	
	private static OperationKind getOperation() {
		System.out.print("Enter Command String! ");
		String str = scanner.next();
		switch(str.toUpperCase()) {
		case "ADD":
			return OperationKind.ADD;
		case "FIND":
			return OperationKind.FIND;
		case "CLEAR":
			return OperationKind.CLEAR;
		case "LIST":
			return OperationKind.LIST;
		case "QUIT":
			return OperationKind.QUIT;
		}
		
		return OperationKind.INVALID;
	}
		
	private static void findStudent(final School school) {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		final Student foundStudent =
				school.findStudent(studentName, schoolYear);
		if(foundStudent != null)
			System.out.println(foundStudent);
		else
			System.out.println("Student Not Found with name " +
								studentName + " and year " + schoolYear);
	}
	
	private static Student createStudent() {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		return new Student(studentName, schoolYear);
	}

}