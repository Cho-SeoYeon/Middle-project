package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.ManagementCarVO;
import kr.or.ddit.vo.ManagementLodgingVO;

public interface IManagementCarDao {

	    //차량 리스트 출력
		public List<ManagementCarVO> carList();
		
		//차량 상세정보 조회
		public List<ManagementCarVO> carDetail(String rentCode);
		
		//렌터카 업체 등록
		public int carCompanyInsert(ManagementCarVO vo);
		
		//차량 등록
		public int carInsert(ManagementCarVO vo);
		
		//차량 삭제
		public int carDelete(String rentCode);
		
		
		
		
}
