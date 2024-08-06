package kr.or.ddit.vo;

public class CarVO {
	private String car_no;
	private String rent_code;
	private int car_price;
	private String car_type;
	private String car_year;
	private String car_cont;
	private String car_name;
	
	
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getRent_code() {
		return rent_code;
	}
	public void setRent_code(String rent_code) {
		this.rent_code = rent_code;
	}
	public int getCar_price() {
		return car_price;
	}
	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_year() {
		return car_year;
	}
	public void setCar_year(String car_year) {
		this.car_year = car_year;
	}
	public String getCar_cont() {
		return car_cont;
	}
	public void setCar_cont(String car_cont) {
		this.car_cont = car_cont;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	@Override
	public String toString() {
		return "CarVO [car_no=" + car_no + ", rent_code=" + rent_code + ", car_price=" + car_price + ", car_type="
				+ car_type + ", car_year=" + car_year + ", car_cont=" + car_cont + ", car_name=" + car_name + "]";
	}
	
	
}
