package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.ILodgingService;
import kr.or.ddit.service.LodgingServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ResLodgingInfoVO;


@WebServlet("/resLodgingInfoCheck.do")
public class ResLodgingInfoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String lodCode = request.getParameter("lod_code");
		String lodName = request.getParameter("lod_name");
		String roomType = request.getParameter("room_type");
		String lodStart = request.getParameter("lod_start");
		String lodEnd = request.getParameter("lod_end");
	
		ILodgingService service = LodgingServiceImpl.getInstance();
		ResLodgingInfoVO infoVo = null;
		
		infoVo = service.resLodgingPageInfo(lodCode, roomType);
		
		request.setAttribute("ResLodgingInfo", infoVo);
		request.setAttribute("lodName", lodName);
		request.setAttribute("lodStart", lodStart);
		request.setAttribute("lodEnd", lodEnd);

		// 세션 처리
		HttpSession session = request.getSession(false);


		if (session != null) {
			MemberVO memVo = (MemberVO) session.getAttribute("loginMember");

			// 세션에 로그인 정보가 존재하는지 체크
			if (memVo != null) {
				request.getRequestDispatcher("/lodging/lodgingView/lodgingReservation.jsp").forward(request, response);
			} else {
				// 세션에 로그인 정보가 존재하지 않는 경우
//				request.getRequestDispatcher("/Member/login.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/Member/login.jsp");
			}
	    }
//		request.getRequestDispatcher("/lodging/lodgingView/lodgingReservation.jsp").forward(request, response);
		
		
	}

}
