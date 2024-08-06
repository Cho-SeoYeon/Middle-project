package kr.or.ddit.service;

import kr.or.ddit.vo.QnaReplyVO;

public interface IQnaReplyService {

	//답변 등록
	public int replyInsert(QnaReplyVO vo);
	
}
