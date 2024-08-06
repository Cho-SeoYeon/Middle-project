package kr.or.ddit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.CarCouponVO;
import kr.or.ddit.vo.CarListVO;
import kr.or.ddit.vo.ResCarVO;
import kr.or.ddit.vo.ReviewVO;

public class CarDaoImpl implements ICarDao{
	
	private static CarDaoImpl carDao;
	
	private CarDaoImpl() {
		
	}
	
	public static CarDaoImpl getInstance() {
		if(carDao==null) {
			carDao = new CarDaoImpl();
		}
		return carDao;
	}
	
//	@Override
//	public List<CarListVO> carList() {
//		SqlSession session = null;
//        List<CarListVO> vo = new ArrayList<CarListVO>();
//        try {
//            session = MybatisUtil.getSqlSession();
//            vo = session.selectList("car.carList");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(session != null) { 
//                session.close();
//            }
//        }
//        return vo;
//	}

	@Override
	public List<CarListVO> carSearchList(String carName, String inDate, String outDate,  String carType) {
	    try (SqlSession session = MybatisUtil.getSqlSession()) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("carName", carName);
	        params.put("inDate", inDate);
	        params.put("outDate", outDate);
	        params.put("carType", carType);

	        return session.selectList("car.carSearchList", params);
	    } catch (Exception e) {
	        // 적절한 예외 처리
	        e.printStackTrace();
	        throw new RuntimeException("Car search failed", e);
	    }
	}

	@Override
	public List<ReviewVO> carReviewList(String car_no) {
		SqlSession session = null;
		List<ReviewVO> vo = new ArrayList<ReviewVO>();
		System.out.println("차량번호 : "+car_no);
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectList("car.carReviewList", car_no.trim());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.commit();
				session.close();
			}
		}
		return vo;
	}

	@Override
	public CarCouponVO carCouponUseCheck(String code, String userId) {
		SqlSession session = null;
		CarCouponVO vo = new CarCouponVO();
		Map<String, String> param = new HashMap<>();
		param.put("code", code);
		param.put("userId", userId);
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("car.carCouponUseCheck", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.commit();
				session.close();
			}
		}
		return vo;
	}

	@Override
	public CarCouponVO carCouponCodeCheck(String code) {
		SqlSession session = null;
		CarCouponVO vo = new CarCouponVO();
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("car.carCouponCodeCheck", code);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.commit();
				session.close();
			}
		}
		return vo;
	}

	@Override
	public int resCarPayment(ResCarVO resCarVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("car.resCarPayment", resCarVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.commit();
				session.close();
			}
		}
		return cnt;
	}


	
}
