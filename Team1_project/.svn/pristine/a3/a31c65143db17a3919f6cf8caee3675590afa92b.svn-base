package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IManagementLodgingService;
import kr.or.ddit.service.ManagementLodgingServiceImpl;
import kr.or.ddit.vo.ManagementLodgingVO;
@WebServlet("/lodgingSearch.do")
public class LodgingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");		
		
		IManagementLodgingService service = ManagementLodgingServiceImpl.getInstance();
		
		String lodgingName = request.getParameter("lodgingName");
		
		ManagementLodgingVO vo = service.searchByLodName(lodgingName);
		
		request.setAttribute("lodging", vo);
		
		request.getRequestDispatcher("/lodging/lodgingList.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
