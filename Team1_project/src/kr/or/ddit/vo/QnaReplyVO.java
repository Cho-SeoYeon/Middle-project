package kr.or.ddit.vo;

public class QnaReplyVO {
	
	private int qna_no;
	private String rpy_cont;
	private String rpy_date;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
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
		return "QnaReplyVO [qna_no=" + qna_no + ", rpy_cont=" + rpy_cont + ", rpy_date=" + rpy_date + "]";
	}
	
	

}
