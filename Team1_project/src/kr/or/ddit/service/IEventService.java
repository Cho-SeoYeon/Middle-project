package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.EventVO;

public interface IEventService {

	//이벤트 전체 리스트 출력
		public List<EventVO> eventList();
		
		//이벤트 상세 내역 출력
		public EventVO eventDetail(int evntNo);
		
		//이벤트 등록
		public int eventInsert(EventVO vo);
		
		//이벤트 삭제
		public int eventDelete(int evntNo);
		
		
}
