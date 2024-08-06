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

import kr.or.ddit.service.ReservationServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReservationVO;


@WebServlet("/afterResRoom.do")
public class AfterResRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<ReservationVO> resVo = new ArrayList<ReservationVO>();
        
        MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
        String userId = memVo.getUser_id();
        //String userId = "a001";
        
        ReservationServiceImpl service= ReservationServiceImpl.getInstance();
        resVo = service.myResRoomAfter(userId);
        
        response.getWriter().write(new Gson().toJson(resVo));
	}



}
