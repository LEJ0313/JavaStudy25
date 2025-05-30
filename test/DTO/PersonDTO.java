package test.DTO;

public class PersonDTO { //부모
	
	protected String name; // 이름
	protected String ID; // 아이디
	protected String PW; // 비밀번호

	public PersonDTO(String name, String iD, String pW) {
		super();
		this.name = name;
		this.ID = iD;
		this.PW = pW;
	}
	public PersonDTO() {		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public String getPW() {
		return PW;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", ID=" + ID + ", PW=" + PW + "]";
	}					
}
