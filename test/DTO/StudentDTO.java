package test.DTO;

public class StudentDTO extends PersonDTO{
	
	protected String StudentID;

	public StudentDTO(String name, String ID, String PW, String StudentID) {
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.StudentID = StudentID;
		
	}
	public StudentDTO() {
		super();
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	
	
}
