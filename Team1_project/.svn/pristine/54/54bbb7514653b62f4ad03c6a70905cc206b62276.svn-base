package kr.or.ddit.service;


import java.util.List;

import kr.or.ddit.dao.IQnaDao;
import kr.or.ddit.dao.QnaDaoImpl;
import kr.or.ddit.vo.QnaVO;


public class QnaServiceImpl implements IQnaService {
	private IQnaDao dao;
	
	private static QnaServiceImpl service;
	private QnaServiceImpl() {
		dao = QnaDaoImpl.getInstance();
	}
	public static QnaServiceImpl getInstance() {
		if(service == null) service = new QnaServiceImpl();
		return service;
	}

	@Override
	public List<QnaVO> qnaList(QnaVO qnavo) {
		
		return dao.qnaList(qnavo);
	}
	@Override
	public int qnaListCnt(QnaVO qnavo) {
		return dao.qnaListCnt(qnavo);
	}
	
	@Override
	public int myQnaInsert(QnaVO qnavo) {
		
		return dao.myQnaInsert(qnavo);
	}
	@Override
	public QnaVO qnaDetail(int qnaNo) {
		
		return dao.qnaDetail(qnaNo);
	}
	
	//관리자용
	@Override
	public List<QnaVO> qnaList() {
		return dao.qnaList();
	}

}
