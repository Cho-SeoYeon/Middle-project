package kr.or.ddit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.service.ReviewServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReviewVO;

//숙소리뷰리스트
@WebServlet("/reviewMyRoom.do")
public class ReviewMyRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<ReviewVO> rvwvo = new ArrayList<ReviewVO>();
       
        MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
        String userId = memVo.getUser_id();
       
        
        ReviewServiceImpl service = ReviewServiceImpl.getInstance();
        rvwvo = service.myRoomReview(userId);
       
        response.getWriter().write(new Gson().toJson(rvwvo));
	}

}
