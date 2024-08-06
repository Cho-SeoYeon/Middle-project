package kr.or.ddit.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.ReservationVO;
import kr.or.ddit.vo.ReviewVO;

public class ReservationDaoImpl implements IReservationDao {

private static ReservationDaoImpl dao;
	
	private ReservationDaoImpl() {}
	
	public static ReservationDaoImpl getInstance() {
		if(dao == null) dao = new ReservationDaoImpl();
		return dao;
	}
	@Override
	public List<ReservationVO> myResRoomBefore(String userId) {
		SqlSession session = null;
		List<ReservationVO> resRoom = new ArrayList<ReservationVO>();
		try {
			session = MybatisUtil.getSqlSession();
			resRoom = session.selectList("reservation.myResRoomBefore",userId);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		
		return resRoom;
	}

	@Override
	public List<ReservationVO> myResRoomAfter(String userId) {
		SqlSession session = null;
		List<ReservationVO> resRoom = new ArrayList<ReservationVO>();
		try {
			session = MybatisUtil.getSqlSession();
			resRoom = session.selectList("reservation.myResRoomAfter",userId);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		
		return resRoom;
	}

	@Override
	public List<ReservationVO> myResCarBefore(String userId) {
		SqlSession session = null;
		List<ReservationVO> resCar = new ArrayList<ReservationVO>();
		try {
			session = MybatisUtil.getSqlSession();
			resCar = session.selectList("reservation.myResCarBefore",userId);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		
		return resCar;
	}

	@Override
	public List<ReservationVO> myResCarAfter(String userId) {
		SqlSession session = null;
		List<ReservationVO> resCar = new ArrayList<ReservationVO>();
		try {
			session = MybatisUtil.getSqlSession();
			resCar = session.selectList("reservation.myResCarAfter",userId);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		
		return resCar;
	}

	@Override
	public List<ReservationVO> afterRoomReview(int resNo) {
		SqlSession session = null;
		List<ReservationVO> resRoom = new ArrayList<ReservationVO>();
		try {
			session = MybatisUtil.getSqlSession();
			resRoom = session.selectList("reservation.afterRoomReview",resNo);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		
		return resRoom;
	}

	@Override
	public int delResBeforeRoom(ReservationVO resVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("reservation.delResBeforeRoom",resVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}

	@Override
	public int delResBeforeCar(ReservationVO resVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("reservation.delResBeforeCar",resVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}

	

}
