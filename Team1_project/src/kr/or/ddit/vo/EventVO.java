package kr.or.ddit.vo;

import kr.or.ddit.util.PagingVo;

public class EventVO extends PagingVo {
	private int evnt_no;
	private String cnp_code;
	private String evnt_title;
	private String evnt_img_path;
	
	public int getEvnt_no() {
		return evnt_no;
	}
	public void setEvnt_no(int evnt_no) {
		this.evnt_no = evnt_no;
	}
	public String getCnp_code() {
		return cnp_code;
	}
	public void setCnp_code(String cnp_code) {
		this.cnp_code = cnp_code;
	}
	public String getEvnt_title() {
		return evnt_title;
	}
	public void setEvnt_title(String evnt_title) {
		this.evnt_title = evnt_title;
	}
	public String getEvnt_img_path() {
		return evnt_img_path;
	}
	public void setEvnt_img_path(String evnt_img_path) {
		this.evnt_img_path = evnt_img_path;
	}
	
	
}
