package kr.or.ddit.vo;

import kr.or.ddit.util.PagingVo;

public class ReviewVO extends PagingVo{
	
	//ROOMREVIEW
	private int rvw_no;
	private int res_r_no;
	private int res_c_no;
	private String rvw_cont;
	private int rvw_star;
	private String rvw_date;
	
	//RES_
	private String user_id;
	private String lod_start;
	private String lod_end;
	private String rent_end;
	private String rent_start;
	private String rent_nm;
	private String car_name;
	private String lod_nm;
	private String room_type;
	
	public int getRvw_no() {
		return rvw_no;
	}
	public void setRvw_no(int rvw_no) {
		this.rvw_no = rvw_no;
	}
	public int getRes_r_no() {
		return res_r_no;
	}
	public void setRes_r_no(int res_r_no) {
		this.res_r_no = res_r_no;
	}
	public int getRes_c_no() {
		return res_c_no;
	}
	public void setRes_c_no(int res_c_no) {
		this.res_c_no = res_c_no;
	}
	public String getRvw_cont() {
		return rvw_cont;
	}
	public void setRvw_cont(String rvw_cont) {
		this.rvw_cont = rvw_cont;
	}
	public int getRvw_star() {
		return rvw_star;
	}
	public void setRvw_star(int rvw_star) {
		this.rvw_star = rvw_star;
	}
	public String getRvw_date() {
		return rvw_date;
	}
	public void setRvw_date(String rvw_date) {
		this.rvw_date = rvw_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLod_end() {
		return lod_end;
	}
	public void setLod_end(String lod_end) {
		this.lod_end = lod_end;
	}
	public String getRent_end() {
		return rent_end;
	}
	public void setRent_end(String rent_end) {
		this.rent_end = rent_end;
	}
	public String getRent_start() {
		return rent_start;
	}
	public void setRent_start(String rent_start) {
		this.rent_start = rent_start;
	}
	public String getRent_nm() {
		return rent_nm;
	}
	public void setRent_nm(String rent_nm) {
		this.rent_nm = rent_nm;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getLod_start() {
		return lod_start;
	}
	public void setLod_start(String lod_start) {
		this.lod_start = lod_start;
	}
	public String getLod_nm() {
		return lod_nm;
	}
	public void setLod_nm(String lod_nm) {
		this.lod_nm = lod_nm;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	@Override
	public String toString() {
		return "ReviewVO [rvw_no=" + rvw_no + ", res_r_no=" + res_r_no + ", res_c_no=" + res_c_no + ", rvw_cont="
				+ rvw_cont + ", rvw_star=" + rvw_star + ", rvw_date=" + rvw_date + ", user_id=" + user_id + ", lod_end="
				+ lod_end + ", rent_end=" + rent_end + "]";
	}
	
	
	
	
	
	
	
	
}
