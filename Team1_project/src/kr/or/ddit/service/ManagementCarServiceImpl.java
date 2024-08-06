package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.ManagementCarDaoImpl;
import kr.or.ddit.vo.ManagementCarVO;

public class ManagementCarServiceImpl implements IManagementCarService {
			
	private ManagementCarDaoImpl dao;
	
	private static ManagementCarServiceImpl service;
	
	private ManagementCarServiceImpl() {
		dao = ManagementCarDaoImpl.getInstance();
	}
	
	public static ManagementCarServiceImpl getInstance() {
		if(service ==null) service = new ManagementCarServiceImpl();
		return service;
	}
	
	@Override
	public List<ManagementCarVO> carList() {
		return dao.carList();
	}

	@Override
	public int carInsert(ManagementCarVO vo) {
		return dao.carInsert(vo);
	}

	@Override
	public int carDelete(String rentCode) {
		return dao.carDelete(rentCode);
	}

	@Override
	public List<ManagementCarVO> carDetail(String rentCode) {
		return dao.carDetail(rentCode);
	}

	@Override
	public int carCompanyInsert(ManagementCarVO vo) {
		return dao.carCompanyInsert(vo);
	}

}
