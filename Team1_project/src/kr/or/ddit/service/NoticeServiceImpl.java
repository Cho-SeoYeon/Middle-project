package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.NoticeDaoImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService {

	private NoticeDaoImpl dao;
	
	private static NoticeServiceImpl service;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service ==null) service = new NoticeServiceImpl();
		return service;
	}
	
	
	@Override
	public List<NoticeVO> noticeList() {
		return dao.noticeList();
	}

	@Override
	public NoticeVO noticeDetail(int noticeNo) {
		return dao.noticeDetail(noticeNo);
	}

	
	@Override
	public int noticeInsert(NoticeVO vo) {
		return dao.noticeInsert(vo);
	}

	@Override
	public int noticeDelete(int noticeNo) {
		return dao.noticeDelete(noticeNo);
	}


}
