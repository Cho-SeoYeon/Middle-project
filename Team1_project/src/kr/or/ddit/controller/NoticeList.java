package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		
		INoticeService service = NoticeServiceImpl.getInstance();

		List<NoticeVO> vo = service.noticeList();
		
		//결과값을 request객체에 저장
		request.setAttribute("noticeList", vo);
		
		//view페이지로 이동
		request.getRequestDispatcher("/notice/noticeList.jsp").forward(request, response);
		
		
	}


}
