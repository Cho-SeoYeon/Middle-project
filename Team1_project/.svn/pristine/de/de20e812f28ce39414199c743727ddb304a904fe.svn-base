package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.EventDaoImpl;
import kr.or.ddit.dao.IEventDao;
import kr.or.ddit.vo.EventVO;

public class EventServiceImpl implements IEventService, IEventDao {
	
	private EventDaoImpl dao;
	
	private static EventServiceImpl service;
	
	private EventServiceImpl() {
		dao = EventDaoImpl.getInstance();
	}
	
	public static EventServiceImpl getInstance() {
		if(service ==null) service = new EventServiceImpl();
		return service;
	}
	
	
	@Override
	public List<EventVO> eventList() {
		return dao.eventList();
	}

	@Override
	public EventVO eventDetail(int evntNo) {
		return dao.eventDetail(evntNo);
	}

	@Override
	public int eventInsert(EventVO vo) {
		return dao.eventInsert(vo);
	}

	@Override
	public int eventDelete(int evntNo) {
		return dao.eventDelete(evntNo);
	}

}
