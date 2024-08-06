package kr.or.ddit.vo;

public class ReservationVO {
		
	//RES_LOD
	private int res_r_no;
	private int room_no;
	private String lod_start;
	private String lod_end;
	private int lod_price;
	private String res_date;
	private String lod_code;
	
	//LODGING
	private String lod_type;
	private String lod_nm;
	private String lod_addr;
	private String l_img_path;
	
	//ROOMS
	private int room_price;
	private String room_type;
	
	//공통
	private String user_id;
	
	//RES_CAR
	private int res_c_no;
	

	private String rent_start;
	private String rent_end;
	//CAR
	private String car_type;
	private String car_year;
	private String car_name;
	//CAR_IMG
	private String c_img_path;
	//RENTCAR
	private String rent_nm;
	
	
	public int getRes_c_no() {
		return res_c_no;
	}
	public void setRes_c_no(int res_c_no) {
		this.res_c_no = res_c_no;
	}
	public String getRent_nm() {
		return rent_nm;
	}
	public void setRent_nm(String rent_nm) {
		this.rent_nm = rent_nm;
	}
	public String getRent_start() {
		return rent_start;
	}
	public void setRent_start(String rent_start) {
		this.rent_start = rent_start;
	}
	public String getRent_end() {
		return rent_end;
	}
	public void setRent_end(String rent_end) {
		this.rent_end = rent_end;
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
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getC_img_path() {
		return c_img_path;
	}
	public void setC_img_path(String c_img_path) {
		this.c_img_path = c_img_path;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getL_img_path() {
		return l_img_path;
	}
	public void setL_img_path(String l_img_path) {
		this.l_img_path = l_img_path;
	}
	public int getRes_r_no() {
		return res_r_no;
	}
	public void setRes_r_no(int res_r_no) {
		this.res_r_no = res_r_no;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getLod_start() {
		return lod_start;
	}
	public void setLod_start(String lod_start) {
		this.lod_start = lod_start;
	}
	public String getLod_end() {
		return lod_end;
	}
	public void setLod_end(String lod_end) {
		this.lod_end = lod_end;
	}
	public int getLod_price() {
		return lod_price;
	}
	public void setLod_price(int lod_price) {
		this.lod_price = lod_price;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getLod_code() {
		return lod_code;
	}
	public void setLod_code(String lod_code) {
		this.lod_code = lod_code;
	}
	public String getLod_type() {
		return lod_type;
	}
	public void setLod_type(String lod_type) {
		this.lod_type = lod_type;
	}
	public String getLod_nm() {
		return lod_nm;
	}
	public void setLod_nm(String lod_nm) {
		this.lod_nm = lod_nm;
	}
	public String getLod_addr() {
		return lod_addr;
	}
	public void setLod_addr(String lod_addr) {
		this.lod_addr = lod_addr;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	@Override
	public String toString() {
		return "ReservationVO [res_r_no=" + res_r_no + ", room_no=" + room_no + ", lod_start=" + lod_start
				+ ", lod_end=" + lod_end + ", lod_price=" + lod_price + ", res_date=" + res_date + ", lod_code="
				+ lod_code + ", lod_type=" + lod_type + ", lod_nm=" + lod_nm + ", lod_addr=" + lod_addr
				+ ", l_img_path=" + l_img_path + ", room_price=" + room_price + ", room_type=" + room_type
				+ ", user_id=" + user_id + ", res_c_no=" + res_c_no + ", rent_start=" + rent_start + ", rent_end="
				+ rent_end + ", car_type=" + car_type + ", car_year=" + car_year + ", car_name=" + car_name
				+ ", c_img_path=" + c_img_path + ", rent_nm=" + rent_nm + "]";
	}
	
	
	
	
	
}
