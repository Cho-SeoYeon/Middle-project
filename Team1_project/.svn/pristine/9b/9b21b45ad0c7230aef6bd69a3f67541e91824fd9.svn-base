package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IReviewDao;
import kr.or.ddit.dao.ReviewDaoImpl;
import kr.or.ddit.vo.ReviewVO;

public class ReviewServiceImpl implements IReviewService {
	private IReviewDao dao;
	
	private static ReviewServiceImpl service;
	
	private ReviewServiceImpl() {
		dao = ReviewDaoImpl.getInstance();
	}
	
	public static ReviewServiceImpl getInstance() {
		if(service == null) service = new ReviewServiceImpl();
		return service;
	}

	public List<ReviewVO> myCarReview(String userId) {
		
		return dao.myCarReview(userId);
	}

	@Override
	public List<ReviewVO> myRoomReview(String userId) {
		
		return dao.myRoomReview(userId);
	}


	@Override
	public int roomReviewInsert(ReviewVO reviewVo) {
		
		return dao.roomReviewInsert(reviewVo);
	}

	@Override
	public int carReviewInsert(ReviewVO reviewVo) {
		
		return dao.carReviewInsert(reviewVo);
	}

	@Override
	public int deleteRoomReview(ReviewVO reviewVo) {
		
		return dao.deleteRoomReview(reviewVo);
	}

	@Override
	public int deleteCarReview(ReviewVO reviewVo) {
		
		return dao.deleteCarReview(reviewVo);
	}

}
