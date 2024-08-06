package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IManagementLodgingService;
import kr.or.ddit.service.ManagementLodgingServiceImpl;

@WebServlet("/lodgingDelete.do")
public class LodgingDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String lodgingCode = request.getParameter("lodgingCode");
		
		IManagementLodgingService service =  ManagementLodgingServiceImpl.getInstance();
		
		service.lodgingDelete(lodgingCode);
		
		request.getRequestDispatcher("/lodging/lodgingList.jsp").forward(request, response);
		
	
	}

}
