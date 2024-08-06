package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mainSearch.do")
public class MainSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mainStrHddn = request.getParameter("mainStrHddn");
		String mainEndHddn = request.getParameter("mainEndHddn");
		String mainSearchHddn =  request.getParameter("mainSearchHddn");
		String mainSelectValue =  request.getParameter("mainSelectValue");
		
		System.out.println(mainStrHddn);
		System.out.println(mainEndHddn);
		System.out.println(mainSearchHddn);
		System.out.println(mainSelectValue);
		
		request.setAttribute("mainStrHddn", mainStrHddn);
		request.setAttribute("mainEndHddn", mainEndHddn);
		request.setAttribute("mainSearchHddn", mainSearchHddn);
		request.setAttribute("mainSelectValue", mainSelectValue);
		
		if("숙소".equals(mainSelectValue)) {
			request.getRequestDispatcher("lodging/resLodging.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Car/carList.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
