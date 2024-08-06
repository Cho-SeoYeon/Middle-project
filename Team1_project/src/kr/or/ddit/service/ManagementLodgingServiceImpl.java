package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.ManagementLodgingDaoImpl;
import kr.or.ddit.vo.ManagementLodgingVO;

public class ManagementLodgingServiceImpl implements IManagementLodgingService {

	private ManagementLodgingDaoImpl dao;
	
	private static ManagementLodgingServiceImpl service;
	
	private ManagementLodgingServiceImpl() {
		dao = ManagementLodgingDaoImpl.getInstance();
	}
	
	public static ManagementLodgingServiceImpl getInstance() {
		if(service == null) service = new ManagementLodgingServiceImpl();
		return service;
	}
	
	
	@Override
	public List<ManagementLodgingVO> lodgingList() {
		return dao.lodgingList();
	}

	@Override
	public List<ManagementLodgingVO> lodgingDetail(String lodgingCode) {
		return dao.lodgingDetail(lodgingCode);
	}

	//숙소 등록
	@Override
	public int lodgingInsert(ManagementLodgingVO vo) {
		return dao.lodgingInsert(vo);
	}
	
	//객실 등록
	@Override
	public int roomInsert(ManagementLodgingVO vo) {
		return dao.roomInsert(vo);
	}

	@Override
	public int lodgingDelete(String lodgingCode) {
		return dao.lodgingDelete(lodgingCode);
	}
	
	//숙소 코드로 검색
	@Override
	public ManagementLodgingVO searchByLodName(String lodgingName) {
		return dao.searchByLodName(lodgingName);
	}

	

}
