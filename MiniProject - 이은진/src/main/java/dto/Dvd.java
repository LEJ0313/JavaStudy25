package dto;

import java.io.Serializable;

public class Dvd implements Serializable {

	private static final long serialVersionUID = -4274700572038677000L;

	private String dvd_id; 		  		 //DVD ID
	private String dvd_name;			//DVD 이름
	private int  dvd_unitPrice; 	    //DVD 가격
	private String dvd_author;			//원작자
	private String dvd_description; 	//설명
	private String dvd_publisher;	    //제작사
	private String dvd_category; 		//분류
	private long   dvd_unitsInStock; 	//재고개수
	private String dvd_releaseDate;   	//제작일(월/년)
	private String dvd_condition; 		//신제품 or 구제품 or 리퍼브제품
	private String dvd_thumbnailUrl;	// 이미지
	

	public Dvd() {
		super();
}


	public String getDvd_id() {
		return dvd_id;
	}


	public void setDvd_id(String dvd_id) {
		this.dvd_id = dvd_id;
	}


	public String getDvd_name() {
		return dvd_name;
	}


	public void setDvd_name(String dvd_name) {
		this.dvd_name = dvd_name;
	}


	public int getDvd_unitPrice() {
		return dvd_unitPrice;
	}


	public void setDvd_unitPrice(int dvd_unitPrice) {
		this.dvd_unitPrice = dvd_unitPrice;
	}


	public String getDvd_author() {
		return dvd_author;
	}


	public void setDvd_author(String dvd_author) {
		this.dvd_author = dvd_author;
	}


	public String getDvd_description() {
		return dvd_description;
	}


	public void setDvd_description(String dvd_description) {
		this.dvd_description = dvd_description;
	}


	public String getDvd_publisher() {
		return dvd_publisher;
	}


	public void setDvd_publisher(String dvd_publisher) {
		this.dvd_publisher = dvd_publisher;
	}


	public String getDvd_category() {
		return dvd_category;
	}


	public void setDvd_category(String dvd_category) {
		this.dvd_category = dvd_category;
	}


	public long getDvd_unitsInStock() {
		return dvd_unitsInStock;
	}


	public void setDvd_unitsInStock(long dvd_unitsInStock) {
		this.dvd_unitsInStock = dvd_unitsInStock;
	}


	public String getDvd_releaseDate() {
		return dvd_releaseDate;
	}


	public void setDvd_releaseDate(String dvd_releaseDate) {
		this.dvd_releaseDate = dvd_releaseDate;
	}


	public String getDvd_condition() {
		return dvd_condition;
	}


	public void setDvd_condition(String dvd_condition) {
		this.dvd_condition = dvd_condition;
	}


	public String getDvd_thumbnailUrl() {
		return dvd_thumbnailUrl;
	}


	public void setDvd_thumbnailUrl(String dvd_thumbnailUrl) {
		this.dvd_thumbnailUrl = dvd_thumbnailUrl;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Dvd [dvd_id=" + dvd_id + ", dvd_name=" + dvd_name + ", dvd_unitPrice=" + dvd_unitPrice + ", dvd_author="
				+ dvd_author + ", dvd_description=" + dvd_description + ", dvd_publisher=" + dvd_publisher
				+ ", dvd_category=" + dvd_category + ", dvd_unitsInStock=" + dvd_unitsInStock + ", dvd_releaseDate="
				+ dvd_releaseDate + ", dvd_condition=" + dvd_condition + ", dvd_thumbnailUrl=" + dvd_thumbnailUrl + "]";
	}

	

	

}