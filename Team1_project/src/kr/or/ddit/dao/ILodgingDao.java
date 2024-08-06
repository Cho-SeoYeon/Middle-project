package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.LodgingCouponVO;
import kr.or.ddit.vo.LodgingDetailVO;
import kr.or.ddit.vo.LodgingListVO;
import kr.or.ddit.vo.LodgingRoomReviewVO;
import kr.or.ddit.vo.ResLodVO;
import kr.or.ddit.vo.ResLodgingInfoVO;
import kr.or.ddit.vo.RoomsVO;

public interface ILodgingDao {
	
	// 전체 리스트 불러오기
	public List<LodgingListVO> getLodgingList();
	
	// 검색조건으로 숙박업소 리스트 가져오기
	public List<LodgingListVO> 
	    searchLodgingWithCond(String lodgingName, int guestNum, String lodgingType, String startDate, String endDate);
	
	// 검색조건으로 띄운 리스트에서 하나의 숙박업소 선택하여 상세페이지 출력
	public List<LodgingDetailVO> lodgingDetail(String lodgingCode, String lodgingName, int guestNum, String lodgingType, String startDate, String endDate); 

	// 숙박업소 상세페이지의 객실 리스트
	public List<RoomsVO> roomsList(String lodgingCode, int guestNum, String startDate, String endDate);

	// 숙박업소 리뷰 리스트
	public List<LodgingRoomReviewVO> lodgingReview(String lodgingCode);
	
	// 예약하기 버튼 후 예약하려는 호텔/객실 정보출력
	public ResLodgingInfoVO resLodgingPageInfo(String lod_code, String room_type);
	
	// 입력받은 쿠폰코드 존재 여부 확인
	public LodgingCouponVO lodgingCnpCheck(String lod_code);
	
	// 입력받은 쿠폰의 사용여부 확인
	public ResLodVO lodgingCnpUseCheck(String user_id, String cnp_code);
	
	// 숙소 예약 등록
	public int resLodInsert(ResLodVO resLodVo);
	
}
