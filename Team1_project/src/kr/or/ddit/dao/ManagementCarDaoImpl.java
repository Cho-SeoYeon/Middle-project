package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.ManagementCarVO;

public class ManagementCarDaoImpl implements IManagementCarDao {

	private static ManagementCarDaoImpl dao;
	
	private ManagementCarDaoImpl() {}
	
	public static ManagementCarDaoImpl getInstance() {
		if(dao ==null) {
			dao = new ManagementCarDaoImpl();
		}
		
		return dao;
	}
	
	// 차량 전체 리스트
	@Override
	public List<ManagementCarVO> carList() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<ManagementCarVO> vo = null;
		try {
			vo = session.selectList("managementCar.carList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}

	// 차량 상세 정보
	@Override
	public List<ManagementCarVO> carDetail(String rentCode) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<ManagementCarVO> vo = null;
		
		try {
			vo = session.selectList("managementCar.carDetail", rentCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) 
				session.close();
		}
		
		return vo;
	}

	
	//렌터카 업체 등록
	@Override
	public int carCompanyInsert(ManagementCarVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		
		try {
			count = session.insert("managementCar.carCompanyInsert", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		return count;
	}

	// 차량 등록
	@Override
	public int carInsert(ManagementCarVO vo) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int count = 0;
	    
	    try {
	        // 차량 정보 등록
	        int carInfoCount = session.insert("managementCar.carInfoInsert", vo);
	        if(carInfoCount > 0) {
	            count += carInfoCount;

	            // 차량 이미지 정보 등록 (차량 이미지 정보가 있는 경우에만 등록)
	            if(vo.getC_img_path() != null && !vo.getC_img_path().isEmpty()) {
	                int carImgCount = session.insert("managementCar.carImgInsert", vo);
	                if(carImgCount > 0) {
	                    count += carImgCount;
	                } else {
	                    // 이미지 등록 실패 시 롤백
	                    session.rollback();
	                    return 0; // 이미지 등록에 실패하면 작업 중지
	                }
	            }

	            // 모든 등록 작업 성공
	            session.commit();
	        } else {
	            // 차량 정보 등록 실패 시 롤백
	            session.rollback();
	        }
	    } catch (Exception e) {
	        // 예외 발생 시 롤백
	        session.rollback();
	        e.printStackTrace();
	    } finally {
	        if(session != null) session.close();
	    }
	    
	    return count;
	}

	// 차량 삭제
	@Override
	public int carDelete(String rentCode) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		
		try {
			// 이미지를 먼저 삭제
			int countImg = session.delete("managementCar.carImgDelete", rentCode);
			count += countImg;
			
			// 차량 정보를 삭제
			int countCar = session.delete("managementCar.carInfoDelete", rentCode);
			if(countCar > 0) {
				count += countCar;
				session.commit();
			}else {
				session.rollback();
			}
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		return count;
	}



}
