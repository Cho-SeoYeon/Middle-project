package kr.or.ddit.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.QnaVO;
import kr.or.ddit.vo.ReviewVO;

public class ReviewDaoImpl implements IReviewDao {
	
	private static ReviewDaoImpl dao;
	
	private ReviewDaoImpl() {}
	
	public static ReviewDaoImpl getInstance() {
		if(dao == null) dao = new ReviewDaoImpl();
		return dao;
	}
	
	//나의리뷰보기(차량)
	public List<ReviewVO> myCarReview(String userId) {
		SqlSession session = null;
		List<ReviewVO> rvwList = new ArrayList<ReviewVO>();
		
		try {
			session = MybatisUtil.getSqlSession();
			rvwList = session.selectList("review.myCarReview",userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return rvwList;
	}
	
	//나의리뷰보기(숙소)
	@Override
	public List<ReviewVO> myRoomReview(String userId) {
		SqlSession session = null;
		List<ReviewVO> rvwList = new ArrayList<ReviewVO>();
		
		try {
			session = MybatisUtil.getSqlSession();
			rvwList = session.selectList("review.myRoomReview",userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return rvwList;
	}
	
	//리뷰등록(숙소)
	@Override
	public int roomReviewInsert(ReviewVO reviewVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("review.roomReviewInsert", reviewVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}
	
	//리뷰등록(차량)
	@Override
	public int carReviewInsert(ReviewVO reviewVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("review.carReviewInsert", reviewVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	
	}
	
	//리뷰삭제(숙소)
	@Override
	public int deleteRoomReview(ReviewVO reviewVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("review.deleteRoomReview", reviewVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}
	//리뷰삭제(차량)
	@Override
	public int deleteCarReview(ReviewVO reviewVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("review.deleteCarReview", reviewVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) try { session.close();}catch(Exception e) {}
		}
		return cnt;
	}


}
