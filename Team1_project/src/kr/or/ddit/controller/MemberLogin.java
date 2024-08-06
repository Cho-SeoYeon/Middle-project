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

@WebServlet("/memberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		MemberVO paramMemberVo = new MemberVO();
		paramMemberVo.setUser_id(userId);
		paramMemberVo.setUser_pass(userPass);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO memVo = service.getLoginMember(paramMemberVo);
		
		HttpSession session = request.getSession();
		
		if(memVo != null) {
			session.setAttribute("loginMember", memVo);
			if ("admin".equals(userId) && "7777".equals(userPass)) {
				// 관리자 정보가 일치하면 관리자 페이지로 이동
				request.getRequestDispatcher("/Car/car.jsp").forward(request, response);
			} else {
				// 일반 사용자 페이지로 이동
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
			
		} else {
			// 로그인 실패 시 로그인 페이지로 리디렉션
			request.setAttribute("loginCheck", "fail");
			request.getRequestDispatcher("/Member/login.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/Member/login.jsp");
		}
//			request.getRequestDispatcher("main.jsp").forward(request, response);
//		}
//		response.sendRedirect(request.getContextPath() + "/Member/login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
 