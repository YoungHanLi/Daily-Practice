import java.util.Objects;

//201824552_HW5
//School.java

public class School {
	private String name;
	private int limit;
	
	private Student[] students;
	private int studentCount;
	
	//constructor
	public School(String str, int num) {
		name = str;
		limit = num;
		students = new Student[limit];
		studentCount = 0;
	}
	
	public String toString() {
		String msg = 
				"School Name: " + name + " Student Count: " + 
				studentCount + "\n";
		
		for(int i=0; i<studentCount; i++) {
			msg += "\t" + students[i] + "\n";
		}
		
		return msg;
	}
	
	public void addStudent(Student newstudent) {
		studentCount++;
		students[studentCount-1] = newstudent;
		
	}
	
	public void removeAllStudent() {
		for(int i=0;i<studentCount;i++)
			students[i] = null;
		studentCount = 0;
	}
	
	public Student findStudent(String studentName, int schoolYear) {
		Student unidentified = new Student(studentName, schoolYear);
		
		for(int i=0; i<studentCount; i++) {
			if(unidentified.equals(students[i]))
				return students[i];
		}
		
		return null;
	}
	
	public boolean equals(Object otherSchool) {
		if(this == otherSchool)
			return true;
		if(otherSchool == null)
			return false;
		if(getClass() != otherSchool.getClass())
			return false;
		
		School other = (School) otherSchool;
		
		return Objects.equals(name, other.name)
				&& limit == other.limit
				&& Objects.equals(students, other.students)
				&& studentCount == other.studentCount;
	}
	
	public int hashCode() {
		return 7*Objects.hashCode(name) + 11*Integer.hashCode(limit)
			+ 13*Objects.hashCode(students) + 17*Integer.hashCode(studentCount);
	}
}
