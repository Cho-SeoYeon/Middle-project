package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.CarListVO;

@WebServlet("/carDetail.do")
public class carDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String rentNm = request.getParameter("rent_nm");
		String carName = request.getParameter("car_name");
		String imgPath = request.getParameter("img_path");
		String[] imgPaths = imgPath.split("=");
		imgPath = imgPaths[imgPaths.length - 1];
		String carNo = request.getParameter("car_no"); 
		String carCont = request.getParameter("car_cont"); 
		String rentAddr = request.getParameter("rent_addr"); 
		String inDate = request.getParameter("inDate"); 
		String outDate = request.getParameter("outDate"); 
		String car_year = request.getParameter("car_year"); 
		String car_price = request.getParameter("car_price"); 
		String car_insuranceprice = request.getParameter("car_insuranceprice"); 
		
		
		
		
		System.out.println(rentAddr +"디테일에서 받았음");
		System.out.println(rentNm +"디테일에서 받았음");
		System.out.println(carName +"디테일에서 받았음");
		System.out.println(imgPath +"디테일에서 받았음");
		System.out.println(carNo +"디테일에서 받았음");
		System.out.println(carCont +"디테일에서 받았음");
		System.out.println(inDate +"디테일에서 받았음");
		System.out.println(outDate +"디테일에서 받았음");
		System.out.println(car_year +"디테일에서 받았음");
		System.out.println(car_price +"디테일에서 받았음");
		System.out.println(car_insuranceprice +"디테일에서 받았음");
		
		
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
	    request.setAttribute("car_insuranceprice", car_insuranceprice);

	    // RequestDispatcher를 사용하여 JSP 페이지로 forward  
	    request.getRequestDispatcher("Car/carDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
