import java.util.*;

public class Student {

	private final String name;
	private int year;
	private final School theSchool;
	
	public Student(School theSchool, String studentName
					,int schoolYear) {
		this.theSchool = theSchool;
		this.year = schoolYear;
		this.name = studentName;
	}
	
	public String toString() {
		String str = "[Name: " + name + ", School:"
					 + theSchool.toOnlyNameString()
					 + ", " + year + "학년]";
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, theSchool, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name)
				&& Objects.equals(theSchool, other.theSchool)
				&& year == other.year;
	}
	
}
