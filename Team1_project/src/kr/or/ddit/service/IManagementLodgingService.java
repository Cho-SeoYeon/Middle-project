package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.ManagementLodgingVO;

public interface IManagementLodgingService {

		//숙소 리스트 출력
		public List<ManagementLodgingVO> lodgingList();
		
		//숙소 코드로 검색
		public ManagementLodgingVO searchByLodName(String lodgingName);
		
		//숙소 상세정보 조회
		public List<ManagementLodgingVO> lodgingDetail(String lodgingCode);
		
		//숙소 등록
		public int lodgingInsert(ManagementLodgingVO vo);
		
		//객실 등록
		public int roomInsert(ManagementLodgingVO vo);
		
		//숙소 삭제
		public int lodgingDelete(String lodgingCode);
		

}
