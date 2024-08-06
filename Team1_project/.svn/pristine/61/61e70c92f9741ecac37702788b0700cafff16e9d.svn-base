package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/memberServlet.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
		
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 객체 생성
		MemberVO memVo = new MemberVO();
		memVo.setUser_id(request.getParameter("id"));
		memVo.setUser_pass(request.getParameter("pass"));
		memVo.setUser_name(request.getParameter("name")); 
		memVo.setUser_tel(request.getParameter("tel"));
		memVo.setUser_mail(request.getParameter("email"));
		memVo.setUser_bir(request.getParameter("birth"));
		
		
		// 멤버 삽입을 위한 서비스 호출
		IMemberService service = MemberServiceImpl.getInstance();
		
		try {
			boolean result = service.insertMember(memVo);
			if(result) {
				response.sendRedirect("Member/registSuccess.jsp");
				
			} else {
				response.sendRedirect("Member/register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
