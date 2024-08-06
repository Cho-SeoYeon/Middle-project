package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/memberFindPwd.do")
public class MemberFindPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        
        MemberVO memVo = new MemberVO();
        memVo.setUser_id(request.getParameter("userId")); 
        memVo.setUser_tel(request.getParameter("userTel"));
        
        PrintWriter out = response.getWriter();
        IMemberService service = MemberServiceImpl.getInstance();
        HttpSession session = request.getSession();
        
        MemberVO userPwd = service.getFindPass(memVo);

        
        try {
            if(userPwd != null) {
               session.setAttribute("user_pass", userPwd);
               out.print("비밀번호는" + userPwd.getUser_pass() + "입니다.");
            }else {
            	out.println("등록된 정보가 없습니다.");
            	out.close();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 오류 처리 페이지로 리다이렉트 또는 포워드
        } finally {
			out.close();
        }
	
	}

}
