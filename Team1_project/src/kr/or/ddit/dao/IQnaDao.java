package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.QnaVO;

public interface IQnaDao {
	
	public List<QnaVO> qnaList(QnaVO qnavo);
	
	public int qnaListCnt(QnaVO qnavo);
	
	public int myQnaInsert(QnaVO qnavo);
	
	public QnaVO qnaDetail(int qnaNo);
	
	//관리자용 문의사항 리스트
	public List<QnaVO> qnaList();

}
