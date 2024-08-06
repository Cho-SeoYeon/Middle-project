package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IManagementCarService;
import kr.or.ddit.service.ManagementCarServiceImpl;
import kr.or.ddit.vo.ManagementCarVO;

@WebServlet("/managementCarList.do")
public class ManagementCarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		
        
		IManagementCarService service = ManagementCarServiceImpl.getInstance();
		
		List<ManagementCarVO> vo = service.carList();
		
		request.setAttribute("carList", vo);
		
		request.getRequestDispatcher("/Car/adminCarList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
