package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.service.NoticeServiceImpl;

@WebServlet("/noticeDelete.do")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    
	    int noticeNum = Integer.parseInt(request.getParameter("noticeNum")); // 클라이언트에서 보낸 noticeNum 파라미터를 가져옴
	    
	    
	    INoticeService service = NoticeServiceImpl.getInstance();
	    
	    int cnt = service.noticeDelete(noticeNum); // 공지사항 번호로 삭제 작업을 수행
	    
	    
	    request.setAttribute("list", cnt);
	    
	    
	    request.getRequestDispatcher("/notice/noticeList.jsp").forward(request, response);
	    
	    
	}

}
