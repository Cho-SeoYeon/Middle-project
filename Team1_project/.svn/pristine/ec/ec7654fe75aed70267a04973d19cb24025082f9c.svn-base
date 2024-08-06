package kr.or.ddit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.LodgingCouponVO;
import kr.or.ddit.vo.LodgingDetailVO;
import kr.or.ddit.vo.LodgingListVO;
import kr.or.ddit.vo.LodgingRoomReviewVO;
import kr.or.ddit.vo.ResLodVO;
import kr.or.ddit.vo.ResLodgingInfoVO;
import kr.or.ddit.vo.RoomsVO;

public class LodgingDaoImpl implements ILodgingDao {
	
	private static LodgingDaoImpl dao;
	
	private LodgingDaoImpl() {	}
	
	public static LodgingDaoImpl getInstance() {
		if (dao == null) dao = new LodgingDaoImpl();
		return dao;
	}
	

	@Override
	public List<LodgingListVO> getLodgingList() {
		SqlSession session = null;
		List<LodgingListVO> lodList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			lodList = session.selectList("lodging.searchLodging");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		
		return lodList;
	}

	@Override
	public List<LodgingListVO> searchLodgingWithCond(String lodgingName, int guestNum, String lodgingType,
			String startDate, String endDate) {
		
		try (SqlSession session = MybatisUtil.getSqlSession()) {
	           Map<String, Object> params = new HashMap<>();
	           params.put("lodgingName", lodgingName);
	           params.put("guestNum", guestNum);
	           params.put("lodgingType", lodgingType);
	           params.put("startDate", startDate);
	           params.put("endDate", endDate);

	           return session.selectList("lodging.searchLodgingWithCond", params);
	       } catch (Exception e) {
	           // 적절한 예외 처리
	           e.printStackTrace();
	           throw new RuntimeException("Car search failed", e);
	       }
	}

	@Override
	public List<LodgingDetailVO> lodgingDetail(String lodgingCode, String lodgingName, int guestNum, String lodgingType,
			String startDate, String endDate) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		List<LodgingDetailVO> detailList = null;
		
		try {
			
			Map<String, Object> params = new HashMap<>();
			params.put("lod_code", lodgingCode);
			params.put("lodgingName", lodgingName);
			params.put("guestNum", guestNum);
			params.put("lodgingType", lodgingType);
			params.put("startDate", startDate);
			params.put("endDate", endDate);
				
			detailList = session.selectList("lodging.lodgingDetail", params);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return detailList;
	}

	@Override
	public List<RoomsVO> roomsList(String lodgingCode, int guestNum, String startDate,
			String endDate) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		List<RoomsVO> roomsList = null;
		
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("lod_code", lodgingCode);
			params.put("guestNum", guestNum);
			params.put("startDate", startDate);
			params.put("endDate", endDate);
			
			roomsList = session.selectList("lodging.roomsList", params);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return roomsList;
	}

	@Override
	public List<LodgingRoomReviewVO> lodgingReview(String lodgingCode) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		List<LodgingRoomReviewVO> reviewList = null;
		
		try {
			reviewList = session.selectList("lodging.lodgingReview", lodgingCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return reviewList;
	}

	@Override
	public ResLodgingInfoVO resLodgingPageInfo(String lod_code, String room_type) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		ResLodgingInfoVO infoVo = null;
		
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("lod_code", lod_code);
			params.put("room_type", room_type);
			
			infoVo = session.selectOne("lodging.resLodgingPageInfo", params);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return infoVo;
	}

	@Override
	public LodgingCouponVO lodgingCnpCheck(String lod_code) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		LodgingCouponVO cnpVo = null;
		
		try {
			cnpVo = session.selectOne("lodging.lodgingCnpCheck", lod_code);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return cnpVo;
		
	}

	@Override
	public ResLodVO lodgingCnpUseCheck(String user_id, String cnp_code) {
		
		SqlSession session = MybatisUtil.getSqlSession();	
		ResLodVO resVo = null;
		
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("user_id", user_id);
			params.put("cnp_code", cnp_code);
			
			resVo = session.selectOne("lodging.lodgingCnpUseCheck", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return resVo;
	}

	@Override
	public int resLodInsert(ResLodVO resLodVo) {
		SqlSession session = MybatisUtil.getSqlSession();	
		int cnt = 0;
		
		try {
			cnt = session.insert("lodging.resLodInsert", resLodVo);
			if (cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return cnt;
	}

}
