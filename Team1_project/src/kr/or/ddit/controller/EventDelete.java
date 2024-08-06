package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.EventServiceImpl;
import kr.or.ddit.service.IEventService;

@WebServlet("/eventDelete.do")
public class EventDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
	
		//클라이언트가 보낸(클릭한 번호의 게시글)
		int eventNum = Integer.parseInt(request.getParameter("eventNum"));
		
		IEventService service = EventServiceImpl.getInstance();
		
		int cnt = service.eventDelete(eventNum);
		
		request.setAttribute("noticeList", cnt);
	
		request.getRequestDispatcher("/event/eventList.jsp").forward(request, response);
	
	
	
	
	
	
	}

}
