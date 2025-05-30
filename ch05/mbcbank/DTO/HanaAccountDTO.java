package ch05.mbcbank.DTO;

public class HanaAccountDTO extends AccountDTO{

	

	public HanaAccountDTO(String ano, String owner, int balance, String bankname) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankname = "하나";
		
		//생성자
	}
	
	public HanaAccountDTO() {
		//기본생성자
	}
	
}
