package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.QnaVO;

public interface IQnaService {
	
	public List<QnaVO> qnaList(QnaVO qnavo);
	
	int qnaListCnt(QnaVO qnavo);
	
	public int myQnaInsert(QnaVO qnavo);
	
	public QnaVO qnaDetail(int qnaNo);
	
	//관리자용 문의사항 리스트
	public List<QnaVO> qnaList();

}
