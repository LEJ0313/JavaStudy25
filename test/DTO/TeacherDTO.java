package test.DTO;

public class TeacherDTO extends PersonDTO{
	
	protected String TeacherID;
	
	public TeacherDTO(String name, String ID, String PW, String TeacherID) {
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.TeacherID = TeacherID;
		
	}
	public TeacherDTO() {
		super();
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

}
