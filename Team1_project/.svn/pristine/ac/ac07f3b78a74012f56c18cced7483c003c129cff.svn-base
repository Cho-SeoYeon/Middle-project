package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.CarCouponVO;
import kr.or.ddit.vo.CarListVO;
import kr.or.ddit.vo.ResCarVO;
import kr.or.ddit.vo.ReviewVO;

public interface ICarService {
//	public List<CarListVO> carList();
	public List<CarListVO> carSearchList(String carName, String inDate, String outDate, String carType);
	public List<ReviewVO> carReviewList(String car_no);
	public CarCouponVO carCouponUseCheck(String code, String userId);
	public CarCouponVO carCouponCodeCheck(String code);
	public int resCarPayment(ResCarVO resCarVo);
}
