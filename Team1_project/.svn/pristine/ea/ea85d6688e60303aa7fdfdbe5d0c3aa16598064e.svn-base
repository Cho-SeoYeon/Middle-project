package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/carReservaion.do")
public class CarReservaion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String rentNm = request.getParameter("rent_nm");
		String carName = request.getParameter("car_name");
		String imgPath = request.getParameter("img_path");
		String carNo = request.getParameter("car_no"); 
		String carCont = request.getParameter("car_cont"); 
		String rentAddr = request.getParameter("rent_addr"); 
		String inDate = request.getParameter("inDate"); 
		String outDate = request.getParameter("outDate"); 
		String car_year = request.getParameter("car_year"); 
		String car_price = request.getParameter("car_price"); 
		
		System.out.println(rentAddr + "####");
		System.out.println(rentNm + "####");
		System.out.println(carName + "####");
		System.out.println(imgPath + "####");
		System.out.println(carNo + "####");
		System.out.println(carCont + "####");
		System.out.println(inDate + "####");
		System.out.println(outDate + "####");
		System.out.println(car_year + "####");
		System.out.println(car_price + "####");
		
	    // 데이터를 JSP로 전달하기 위해 request 객체에 속성으로 설정
	    request.setAttribute("rentNm", rentNm);
	    request.setAttribute("carName", carName);
	    request.setAttribute("imgPath", imgPath);
	    request.setAttribute("carNo", carNo);
	    request.setAttribute("carCont", carCont);
	    request.setAttribute("rentAddr", rentAddr);
	    request.setAttribute("inDate", inDate);
	    request.setAttribute("outDate", outDate);
		request.setAttribute("car_year", car_year);
		request.setAttribute("car_price", car_price);

		HttpSession session = request.getSession(false);

		if (session != null) {

			MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
			
			if (memVo != null) {
				System.out.println("ID세션이 존재 합니다~~~~~~~~~");
				request.getRequestDispatcher("/Car/carReservation.jsp").forward(request, response);
			} else {
//				response.sendRedirect(request.getContextPath() + "/Member/login.jsp");
				request.getRequestDispatcher("/Member/login.jsp").forward(request, response);
				System.out.println("ID세션이 존재하지 않습니다~~~~~~~~~");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
