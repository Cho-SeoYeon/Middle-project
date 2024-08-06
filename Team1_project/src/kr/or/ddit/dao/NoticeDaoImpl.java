package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

	private static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {}
	
	public static NoticeDaoImpl getInstance() {
		if(dao == null) {
			dao = new NoticeDaoImpl();
		}
		
		return dao;
	}
	
	// 공지사항 전체 리스트 조회
	@Override
	public List<NoticeVO> noticeList() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<NoticeVO> vo = null;
		
		try {
			
			vo = session.selectList("notice.noticeList");
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	//공지사항 상세내용 조회
	@Override
	public NoticeVO noticeDetail(int noticeNo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		NoticeVO vo = null;
		
		try {
			vo = session.selectOne("notice.noticeDetail", noticeNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}

	
	// 공지사항 등록
	@Override
	public int noticeInsert(NoticeVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int num = 0;
		
		try {
			num = session.insert("notice.noticeInsert", vo);
			if(num >0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}

	
	// 공지사항 삭제
	@Override
	public int noticeDelete(int noticeNo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int num = 0;
		
		try {
			num = session.delete("notice.noticeDelete", noticeNo);
			if(num >0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}


}
