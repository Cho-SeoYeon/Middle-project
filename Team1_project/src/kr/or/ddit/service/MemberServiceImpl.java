package kr.or.ddit.service;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	
	//싱글톤
	private static MemberServiceImpl service;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}

	@Override
	public boolean insertMember(MemberVO memVo) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertMember(memVo) > 0;
	}

	@Override
	public int checkId(String userId) {
		// TODO Auto-generated method stub
		return dao.checkId(userId);
	}

	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.getLoginMember(memVo);
	}

	@Override
	public MemberVO getFindId(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.getFindId(memVo);
	}

	@Override
	public MemberVO getFindPass(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.getFindPass(memVo);
	}

	@Override
	public int memUpdate(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.memUpdate(memVo);
	}
	
	

}
