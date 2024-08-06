package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IManagementCarService;
import kr.or.ddit.service.ManagementCarServiceImpl;

@WebServlet("/carDelete.do")
public class CarDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//관리자가 클릭한 번호의 차량 
		String carNo = request.getParameter("carNo");
		
		IManagementCarService service = ManagementCarServiceImpl.getInstance();
		
		service.carDelete(carNo);
		
		request.getRequestDispatcher("/car/carList.jsp").forward(request, response);
		
		
	}

}

