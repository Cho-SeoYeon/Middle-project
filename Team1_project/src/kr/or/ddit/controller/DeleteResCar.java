package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IReservationService;
import kr.or.ddit.service.ReservationServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReservationVO;


@WebServlet("/deleteResCar.do")
public class DeleteResCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		int resNo = Integer.parseInt(request.getParameter("resNo"));
		ReservationVO resVo = new ReservationVO();
		resVo.setRes_c_no(resNo);
		if (session != null) {

			MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
			
			if (memVo != null) {
				System.out.println("ID세션이 존재 합니다~~~~~~~~~");
				resVo.setUser_id(memVo.getUser_id());
			}
		}
		
		IReservationService service = ReservationServiceImpl.getInstance();
		service.delResBeforeCar(resVo);
		response.sendRedirect(request.getContextPath()+"/reservation/reservation.jsp");
	}

}
