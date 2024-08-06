package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.ManagementLodgingVO;

public class ManagementLodgingDaoImpl implements IManagementLodgingDao {

	private static ManagementLodgingDaoImpl dao;
	
	private ManagementLodgingDaoImpl() {}
	
	public static ManagementLodgingDaoImpl getInstance() {
		if(dao ==null) {
			dao = new ManagementLodgingDaoImpl();
		}
		
		return dao;
	}
	
	
	// 숙소 전체 리스트
	@Override
	public List<ManagementLodgingVO> lodgingList() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<ManagementLodgingVO> vo = null;
		try {
			vo = session.selectList("managementLodging.lodgingList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}

	// 숙소 상세 정보
	@Override
	public List<ManagementLodgingVO> lodgingDetail(String lodgingCode) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<ManagementLodgingVO> list = null;
		try {
			list = session.selectList("managementLodging.lodgingDetail", lodgingCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}

	
	//숙소 등록
	@Override
	public int lodgingInsert(ManagementLodgingVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		
		try {

			count = session.insert("managementLodging.lodgingInsert", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.commit();
				session.close();
		}
		return count;
	}
	
	//객실 등록
	@Override
	public int roomInsert(ManagementLodgingVO vo) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int count = 0;

	    try {
	        // 객실 정보 등록
	        int roomInfoCount = session.insert("managementLodging.roomInsert", vo);
	        if(roomInfoCount > 0) {
	            count += roomInfoCount;

	            // 객실 이미지 정보 등록 (객실 이미지 정보가 있는 경우에만 등록)
	            if(vo.getR_img_path() != null && !vo.getR_img_path().isEmpty()) {
	                int roomImgCount = session.insert("managementLodging.roomImgInsert", vo);
	                if(roomImgCount > 0) {
	                    count += roomImgCount;
	                } else {
	                    // 이미지 등록 실패 시 롤백
	                    session.rollback();
	                    return 0; // 이미지 등록에 실패하면 작업 중지
	                }
	            }

	            // 모든 등록 작업 성공
	            session.commit();
	        } else {
	            // 객실 정보 등록 실패 시 롤백
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


	//숙소 삭제
	@Override
	public int lodgingDelete(String lodgingCode) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		try {
			// 이미지 먼저 삭제
			int countImg = session.delete("managementLodging.roomImgDelete", lodgingCode);
			count += countImg;
			
			//숙소 정보 삭제
			int countRoom = session.delete("managementLodging.roomInfoDelete", lodgingCode);
			if(countRoom > 0) {
				count += countRoom;
				session.commit();
			} else {
				session.rollback();
			}
			
			int countLodging = session.delete("managementLodging.lodgingDelete", lodgingCode);
			if(countLodging > 0) {
				count += countLodging;
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

	@Override
	public ManagementLodgingVO searchByLodName(String lodgingName) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		ManagementLodgingVO vo = null;
		try {
			vo = session.selectOne("managementLodging.searchByLodCode", lodgingName);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}



}



