function CheckAddDvd() {

	var dvdId = document.getElementById("dvdId");
	var name = document.getElementById("name");
	var unitPrice = document.getElementById("unitPrice");
	var unitsInStock = document.getElementById("unitsInStock");
	var description = document.getElementById("description");

	
	
	// dvd아아디 체크
	if (!check(/^DVD[0-9]{4,11}$/, dvdId,
		"[DVD 코드]\nDVD와 숫자를 조합하여 5~12자까지 입력하세요\n첫 글자는 반드시 DVD로 시작하세요"))
		return false;
		
	// dvd명 체크	
	if (name.value.length < 2 || name.value.length > 20) {
		alert("[DVD 제목]\n최소 2자에서 최대 20자까지 입력하세요");
		//name.select();
		name.focus();
		return false;
	}
	// dvd 가격 체크
	if (unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
		alert("[가격]\n숫자만 입력하세요");
		//unitPrice.select();
		unitPrice.focus();
		return false;
	}

	if (unitPrice.value < 0) {
		alert("[가격]\n음수를 입력할 수 없습니다");
		//unitPrice.select();
		unitPrice.focus();
		return false;
	} 

	// 재고 수 체크
	if (isNaN(unitsInStock.value)) {
		alert("[재고 수]\n숫자만 입력하세요");
		//unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	if (description.value.length < 100) {
		alert("[상세설명]\n최소 100자이상 입력하세요");
		//description.select();
		description.focus();
		return false;
	}
	
	function check(regExp, e, msg) {

		if (regExp.test(e.value)) {
			return true;
		}
		alert(msg);
		//e.select();
		e.focus();
		return false;
	}

	 document.newDvd.submit()
}