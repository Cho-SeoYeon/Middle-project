package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	
	public MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) throws Exception {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("member.insertMember", memVo);
			if(cnt>0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
			
		}
		
		return cnt;
	}

	@Override
	public int checkId(String userId) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.selectOne("member.checkId", userId);
			System.out.println(cnt + "ASDASDASD");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		MemberVO loginMemberVo = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			loginMemberVo = session.selectOne("member.getLoginMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		
		}
		return loginMemberVo;
	}

	@Override
	public MemberVO getFindId(MemberVO memVo) {
		MemberVO findIdVo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			findIdVo = session.selectOne("member.getFindId", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return findIdVo;
	}

	@Override
	public MemberVO getFindPass(MemberVO memVo) {
		MemberVO findPwdVo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			findPwdVo = session.selectOne("member.getFindPass", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return findPwdVo;
	}

	@Override
	public int memUpdate(MemberVO memVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("member.memUpdate",memVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

}
