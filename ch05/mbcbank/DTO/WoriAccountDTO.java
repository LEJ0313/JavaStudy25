package ch05.mbcbank.DTO;

public class WoriAccountDTO extends AccountDTO{

	public WoriAccountDTO(String ano, String owner, int balance, String bankname){
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankname = "우리";
		
		//생성자
	}
	
	public WoriAccountDTO() {
		//기본생성자
	}
	
}
