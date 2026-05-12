import java.util.*;

public class School {
	private final String name;
	private List<Student> students = new ArrayList<>();
	
	public School(final String name){
		this.name = name;
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public String getSchoolName() {
		return name;
	}

	
	public Student matchStudent(Student stranger){
		
		for(int i=0; i<students.size();i++) {
			if(stranger.equals(students.get(i)))
				return students.get(i);
		}
		
		return null;
	}
	
	public String allStudentList() {
		
		String strAllStudentList = "";
		
		for(int i=0; i<students.size(); i++) {
			strAllStudentList += students.get(i) 
					+ (String)"\n";
		}
		
		
		return strAllStudentList;
	}
	
	public String toString() {
		
		String str = "School Name: " + (String)name
				+ " Student Count: " + students.size();
		
		return str;
	}
	
	public String toOnlyNameString() {
		
		String str = name;
		
		return str;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(name, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		return Objects.equals(name, other.name)
				&& Objects.equals(students, other.students);
	}
	
	

}
