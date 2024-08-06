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
import kr.or.ddit.vo.ResLodVO;


@WebServlet("/resLod.do")
public class ResLod extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ResLodVO reslodVo = new ResLodVO();
		
		HttpSession session = request.getSession(false);
		
		// 더 가져와야 할 것 : 결제수단, 숙소 이름, 객실 이름
		int roomNo = Integer.parseInt(request.getParameter("room_no"));
		String lodStart = request.getParameter("lod_start");
		String lodEnd = request.getParameter("lod_end");
		int lodPrice = Integer.parseInt(request.getParameter("lod_price"));
		String copCode = request.getParameter("cop_code");
		String lodCode = request.getParameter("lod_code");
		String lodName = request.getParameter("lod_name");
		String userName = request.getParameter("user_name");
		String userTel = request.getParameter("user_tel");
		MemberVO memVo = (MemberVO)	session.getAttribute("loginMember");
		String userId = null;
		String payMethod = request.getParameter("pay_method");
		try {
			userId = memVo.getUser_id();
		}catch(NullPointerException e) {
			
		}
		
		ILodgingService service = LodgingServiceImpl.getInstance();
		reslodVo.setUser_id(userId);
		reslodVo.setRoom_no(roomNo);
		reslodVo.setLod_start(lodStart);
		reslodVo.setLod_end(lodEnd);
		reslodVo.setLod_price(lodPrice);
		reslodVo.setCnp_code(copCode);
		reslodVo.setLod_code(lodCode);
		
		int cnt = service.resLodInsert(reslodVo);
		
		request.setAttribute("insertResLod", cnt);
		
		request.setAttribute("userId", userId);
		request.setAttribute("lodStart", lodStart);
		request.setAttribute("lodEnd", lodEnd);
		request.setAttribute("lodName", lodName);
		request.setAttribute("lodPrice", lodPrice);
		request.setAttribute("userName", userName);
		request.setAttribute("userTel", userTel);
		request.setAttribute("payMethod", payMethod);
		
		// 현재는 메인으로 보내지만 나중에 결제완료 창 띄울 때는 위의 정보를 꺼내서 사용하기
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}

}
