package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IReviewService;
import kr.or.ddit.service.ReviewServiceImpl;
import kr.or.ddit.vo.ReviewVO;


@WebServlet("/carReviewInsert.do")
public class CarReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int resNo = Integer.parseInt(request.getParameter("resNo"));
		int star = Integer.parseInt(request.getParameter("rvw_star"));
		String cont = request.getParameter("rvw_cont");
		ReviewVO reviewVo = new ReviewVO();
		
		reviewVo.setRes_c_no(resNo);
		reviewVo.setRvw_star(star);
		reviewVo.setRvw_cont(cont);
		
		IReviewService service = ReviewServiceImpl.getInstance();
		
		service.carReviewInsert(reviewVo);
		
		response.sendRedirect(request.getContextPath()+"/review/myReviewList.jsp");
	}

}
