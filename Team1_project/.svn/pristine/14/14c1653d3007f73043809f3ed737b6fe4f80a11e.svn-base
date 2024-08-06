package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.ILodgingDao;
import kr.or.ddit.dao.LodgingDaoImpl;
import kr.or.ddit.vo.LodgingCouponVO;
import kr.or.ddit.vo.LodgingDetailVO;
import kr.or.ddit.vo.LodgingListVO;
import kr.or.ddit.vo.LodgingRoomReviewVO;
import kr.or.ddit.vo.ResLodVO;
import kr.or.ddit.vo.ResLodgingInfoVO;
import kr.or.ddit.vo.RoomsVO;

public class LodgingServiceImpl implements ILodgingService {
	
	private ILodgingDao dao;
	
	private static ILodgingService service;
	
	private LodgingServiceImpl() { 
		dao = LodgingDaoImpl.getInstance();
	}
	
	public static ILodgingService getInstance() {
		if (service == null) service = new LodgingServiceImpl();
		return service;
	}
	

	@Override
	public List<LodgingListVO> getLodgingList() {

		return dao.getLodgingList();
	}

	@Override
	public List<LodgingListVO> searchLodgingWithCond(String lodgingName, int guestNum, String lodgingType,
			String startDate, String endDate) {
		return dao.searchLodgingWithCond(lodgingName, guestNum, lodgingType, startDate, endDate);
	}

	@Override
	public List<LodgingDetailVO> lodgingDetail(String lodgingCode, String lodgingName, int guestNum, String lodgingType,
			String startDate, String endDate) {
		
		return dao.lodgingDetail(lodgingCode, lodgingName, guestNum, lodgingType, startDate, endDate);
	}

	@Override
	public List<RoomsVO> roomsList(String lodgingCode, int guestNum, String startDate, String endDate) {
		return dao.roomsList(lodgingCode, guestNum, startDate, endDate);
	}

	@Override
	public List<LodgingRoomReviewVO> lodgingReview(String lodgingCode) {
		return dao.lodgingReview(lodgingCode);
	}

	@Override
	public ResLodgingInfoVO resLodgingPageInfo(String lod_code, String room_type) {
		return dao.resLodgingPageInfo(lod_code, room_type);
	}

	@Override
	public LodgingCouponVO lodgingCnpCheck(String lod_code) {
		return dao.lodgingCnpCheck(lod_code);
	}

	@Override
	public ResLodVO lodgingCnpUseCheck(String user_id, String cnp_code) {
		return dao.lodgingCnpUseCheck(user_id, cnp_code);
	}

	@Override
	public int resLodInsert(ResLodVO resLodVo) {
		return dao.resLodInsert(resLodVo);
	}



}
