package kr.or.ddit.vo;

import kr.or.ddit.util.PagingVo;

public class QnaVO extends PagingVo{
	
	//QNA테이블 컬럼
	//private int rownum;
	private int qna_no;
	private String qna_title;
	private String qna_cont;
	private String qna_pass;
	private String qna_date;
	private String user_id;

	//QNAREPLY 테이블 컬럼
	private String rpy_cont;
	private String rpy_date;
	
	/*ㅡ,.ㅡ
	public int getRownum() {
		return rownum
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	*/
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_cont() {
		return qna_cont;
	}
	public void setQna_cont(String qna_cont) {
		this.qna_cont = qna_cont;
	}
	public String getQna_pass() {
		return qna_pass;
	}
	public void setQna_pass(String qna_pass) {
		this.qna_pass = qna_pass;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getRpy_cont() {
		return rpy_cont;
	}
	public void setRpy_cont(String rpy_cont) {
		this.rpy_cont = rpy_cont;
	}
	public String getRpy_date() {
		return rpy_date;
	}
	public void setRpy_date(String rpy_date) {
		this.rpy_date = rpy_date;
	}
	
	@Override
	public String toString() {
		return "QnaVO [qna_no=" + qna_no + ", qna_title=" + qna_title + ", qna_cont=" + qna_cont + ", qna_pass="
				+ qna_pass + ", qna_date=" + qna_date + ", user_id=" + user_id + ", rpy_cont=" + rpy_cont
				+ ", rpy_date=" + rpy_date + "]";
	}
	

	
	
	

	
	
}
