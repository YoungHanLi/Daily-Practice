import java.util.Objects;

//201824552_HW5
//Student.java

public class Student {
	private String name;
	private int year;
	
	
	public Student(String studentName, int schoolYear){
		name = studentName;
		year = schoolYear;
	}
	
	public String toString() {
		return String.format("[%s, %d학년]", name, year);
	}
	
	public boolean equals(Object otherStudent) {
		
		if(this == otherStudent)
			return true;
		if(otherStudent == null)
			return false;
		if(getClass() != otherStudent.getClass())
			return false;
		
		Student other = (Student)otherStudent;
		
		return Objects.equals(name, other.name)
				&& year == other.year;
		
		/*
		if(name == null || otherStudent.name == null)
			return false;
		if(name.equals(otherStudent.name) && year == otherStudent.year) {
			return true;
		}
		
		return false;*/
		
	}
	public int hashCode() {
		return 7*Objects.hashCode(name) + 13*Integer.hashCode(year);
	}
}
