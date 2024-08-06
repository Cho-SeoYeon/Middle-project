package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.EventVO;

public class EventDaoImpl implements IEventDao {

	private static EventDaoImpl dao;
	
	private EventDaoImpl() {}
	
	public static EventDaoImpl getInstance() {
		if(dao == null) {
			dao = new EventDaoImpl();
		}
		return dao;
		
	}
	
	//전체 이벤트
	@Override
	public List<EventVO> eventList() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<EventVO> vo = null;
		
		try {
			vo = session.selectList("event.eventList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}

	//이벤트 상세내용
	@Override
	public EventVO eventDetail(int evntNo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		EventVO vo = null;
		
		try {
			vo = session.selectOne("event.eventDetail", evntNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}

	//이벤트 등록
	@Override
	public int eventInsert(EventVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("event.eventInsert", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		return cnt;
	}

	//이벤트 삭제
	@Override
	public int eventDelete(int evntNo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.delete("event.eventDelete", evntNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		return cnt;
	}

}
