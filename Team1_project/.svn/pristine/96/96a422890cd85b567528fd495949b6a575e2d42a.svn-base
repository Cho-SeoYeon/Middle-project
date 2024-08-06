package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.CarDaoImpl;
import kr.or.ddit.dao.ICarDao;
import kr.or.ddit.vo.CarCouponVO;
import kr.or.ddit.vo.CarListVO;
import kr.or.ddit.vo.ResCarVO;
import kr.or.ddit.vo.ReviewVO;

public class CarServiceImpl implements ICarService{

	private static ICarDao carDao;
	private static CarServiceImpl carService;
	
	private CarServiceImpl() {
		carDao = CarDaoImpl.getInstance();
	}
	
	public static CarServiceImpl getInstance() {
		if(carService==null) {
			carService = new CarServiceImpl();
		}
		return carService;
	}
	
//	@Override
//	public List<CarListVO> carList() {
//		return carDao.carList();
//	}

	@Override
	public List<CarListVO> carSearchList(String carName, String inDate, String outDate, String carType) {
		
		return carDao.carSearchList(carName, inDate, outDate, carType);
	}

	@Override
	public List<ReviewVO> carReviewList(String car_no) {
		return carDao.carReviewList(car_no);
	}

	@Override
	public CarCouponVO carCouponUseCheck(String code, String userId) {
		return carDao.carCouponUseCheck(code, userId);
	}

	@Override
	public CarCouponVO carCouponCodeCheck(String code) {
		return carDao.carCouponCodeCheck(code);
	}

	@Override
	public int resCarPayment(ResCarVO resCarVo) {
		return carDao.resCarPayment(resCarVo);
	}



	
}
