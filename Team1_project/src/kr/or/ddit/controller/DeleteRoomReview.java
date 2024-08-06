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


@WebServlet("/deleteRoomReview.do")
public class DeleteRoomReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int rvwNo = Integer.parseInt(request.getParameter("rvwNo"));
		ReviewVO reviewVo = new ReviewVO();
		reviewVo.setRvw_no(rvwNo);
		
		IReviewService service = ReviewServiceImpl.getInstance();
		
		service.deleteRoomReview(reviewVo);
		
		response.sendRedirect(request.getContextPath()+"/review/myReviewList.jsp");
		
		
	}

}
