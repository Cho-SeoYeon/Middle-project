package kr.or.ddit.dao;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {
	
	// 회원가입
	public int insertMember(MemberVO memVo) throws Exception;
	
	// 아이디 중복 확인
	public int checkId(String userId);
	
	// 로그인
	public MemberVO getLoginMember(MemberVO memVo);
	
	// 아이디찾기
	public MemberVO getFindId(MemberVO memVo);
	
	// 비밀번호 찾기
	public MemberVO getFindPass(MemberVO memVo);
	
	//회원정보 수정
	public int memUpdate(MemberVO memVo);
}
