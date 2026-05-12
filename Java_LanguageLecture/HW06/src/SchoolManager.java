import java.util.*;

public class SchoolManager {

	private List<School> schools = new ArrayList<>();

	public School findSchool(String schoolName) {
		 for(int i=0; i<schools.size(); i++) {
			 if(schools.get(i).getSchoolName().equals(schoolName))
				return schools.get(i);
		 }
		 
		 return null;
	}
	
	public School createSchool(String schoolName) {
		School newSchool = new School(schoolName);
		schools.add(newSchool);
		return newSchool;
	}
	
	public List<Student> findStudent(String studentName, int schoolYear) {
		List<Student> foundAllStudents = new ArrayList<>();
		for(int i=0; i<schools.size(); i++) {
			Student stranger = new Student(schools.get(i),studentName, schoolYear);
			Student foundStudent = (schools.get(i)).matchStudent(stranger);
			if(foundStudent != null)
					foundAllStudents.add(foundStudent);
		}
		
		return foundAllStudents;
		
		
	}
	
	public void removeAllSchools() {
		schools.clear();
	}
	
	public String toString() {
		String str = "Total School Count: " + schools.size() + "\n";
		String strAllStudent = "";
		for(int i=0; i<schools.size();i++) {
			str += schools.get(i).toString() + (String)"\n";
			strAllStudent = schools.get(i).allStudentList();
			str += strAllStudent;
				if(i!=schools.size()-1) str += (String)"\n";
		}
		
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(schools);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolManager other = (SchoolManager) obj;
		return Objects.equals(schools, other.schools);
	}
	
}
