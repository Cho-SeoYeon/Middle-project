package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IManagementLodgingService;
import kr.or.ddit.service.ManagementLodgingServiceImpl;
import kr.or.ddit.vo.ManagementLodgingVO;

@WebServlet("/adminLodgingDetail.do")
public class AdminLodgingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String lodgingCode = request.getParameter("lodgingCode");
		/*
		System.out.println("lodgingCode > " + lodgingCode);
		System.out.println("lodgingName > " + lodgingName);
		System.out.println("guestStr > " + guestStr);
		*/
		
		IManagementLodgingService service = ManagementLodgingServiceImpl.getInstance();
		
		List<ManagementLodgingVO> lodgingList = service.lodgingDetail(lodgingCode);
		
		request.setAttribute("lodgingDetail", lodgingList);
		
		request.getRequestDispatcher("/lodging/adminLodgingDetail.jsp").forward(request, response);
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
