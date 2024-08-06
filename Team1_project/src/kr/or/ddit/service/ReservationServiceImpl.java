package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IReservationDao;
import kr.or.ddit.dao.ReservationDaoImpl;
import kr.or.ddit.vo.ReservationVO;
import kr.or.ddit.vo.ReviewVO;

public class ReservationServiceImpl implements IReservationService {
	private IReservationDao dao;
	
	private static ReservationServiceImpl service;
	
	private ReservationServiceImpl() {
		dao = ReservationDaoImpl.getInstance();
	}
	public static ReservationServiceImpl getInstance() {
		if(service == null) service = new ReservationServiceImpl();
		return service;
	}
	@Override
	public List<ReservationVO> myResRoomBefore(String userId) {
		
		return dao.myResRoomBefore(userId);
	}
	@Override
	public List<ReservationVO> myResRoomAfter(String userId) {
		
		return dao.myResRoomAfter(userId);
	}
	@Override
	public List<ReservationVO> myResCarBefore(String userId) {
		
		return dao.myResCarBefore(userId);
	}
	@Override
	public List<ReservationVO> myResCarAfter(String userId) {
		
		return dao.myResCarAfter(userId);
	}
	@Override
	public List<ReservationVO> afterRoomReview(int resNo) {
		
		return dao.afterRoomReview(resNo);
	}
	@Override
	public int delResBeforeRoom(ReservationVO resVo) {
		
		return dao.delResBeforeRoom(resVo);
	}
	@Override
	public int delResBeforeCar(ReservationVO resVo) {
		
		return dao.delResBeforeCar(resVo);
	}

	

}
