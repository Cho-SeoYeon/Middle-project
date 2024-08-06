package kr.or.ddit.service;

import kr.or.ddit.dao.QnaReplyDaoImpl;
import kr.or.ddit.vo.QnaReplyVO;

public class QnaReplyServiceImpl implements IQnaReplyService {

	private QnaReplyDaoImpl dao;
	
	private static QnaReplyServiceImpl service;
	
	private QnaReplyServiceImpl() {
		dao = QnaReplyDaoImpl.getInstance();
	}
	
	public static QnaReplyServiceImpl getInstance() {
		if(service == null) service = new QnaReplyServiceImpl();
		return service;
	}

	//답변 등록
	@Override
	public int replyInsert(QnaReplyVO vo) {
		return dao.replyInsert(vo);
	}

}
