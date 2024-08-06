package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/memberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
	    String userId = memVo.getUser_id();
		String userPass = request.getParameter("pass");
		
		String userTel = request.getParameter("tel");
		String userMail = request.getParameter("email");
		
		
		
		memVo.setUser_id(userId);
		memVo.setUser_pass(userPass);
		
		memVo.setUser_tel(userTel);
		memVo.setUser_mail(userMail);
		
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		service.memUpdate(memVo);
		
		
		response.sendRedirect(request.getContextPath()+"/Member/memUpdate.jsp");
		
		
		
	}

}
