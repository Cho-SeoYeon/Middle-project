package kr.or.ddit.vo;

import kr.or.ddit.util.PagingVo;

public class ManagementCarVO extends PagingVo {
	private String car_no;
	private String rent_code;
	private int car_price;
	private String car_type;
	private String car_year;
	private String car_cont;
	private String car_name;
	private String rent_nm;
	private String rent_addr;
	private String rent_tel;
	private String rent_mail;
	private int c_img_no;
	private String c_img_path;
	
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
	public String getRent_nm() {
		return rent_nm;
	}
	public void setRent_nm(String rent_nm) {
		this.rent_nm = rent_nm;
	}
	public String getRent_addr() {
		return rent_addr;
	}
	public void setRent_addr(String rent_addr) {
		this.rent_addr = rent_addr;
	}
	public String getRent_tel() {
		return rent_tel;
	}
	public void setRent_tel(String rent_tel) {
		this.rent_tel = rent_tel;
	}
	public String getRent_mail() {
		return rent_mail;
	}
	public void setRent_mail(String rent_mail) {
		this.rent_mail = rent_mail;
	}
	public int getC_img_no() {
		return c_img_no;
	}
	public void setC_img_no(int c_img_no) {
		this.c_img_no = c_img_no;
	}
	public String getC_img_path() {
		return c_img_path;
	}
	public void setC_img_path(String c_img_path) {
		this.c_img_path = c_img_path;
	}
	@Override
	public String toString() {
		return "ManagementCarVO [car_no=" + car_no + ", rent_code=" + rent_code + ", car_price=" + car_price
				+ ", car_type=" + car_type + ", car_year=" + car_year + ", car_cont=" + car_cont + ", car_name="
				+ car_name + ", rent_nm=" + rent_nm + ", rent_addr=" + rent_addr + ", rent_tel=" + rent_tel
				+ ", rent_mail=" + rent_mail + ", c_img_no=" + c_img_no + ", c_img_path=" + c_img_path + "]";
	}
	
}
