package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/noticeDetail.do")
public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNo"));
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		NoticeVO detailvo = service.noticeDetail(noticeNum);
		//System.out.println(detailvo);
	
		request.setAttribute("notice", detailvo);
		
		request.getRequestDispatcher("/notice/noticeDetail.jsp").forward(request, response);
	
	}


}
