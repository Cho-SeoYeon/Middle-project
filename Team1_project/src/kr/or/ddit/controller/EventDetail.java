package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.EventServiceImpl;
import kr.or.ddit.service.IEventService;
import kr.or.ddit.vo.EventVO;

@WebServlet("/eventDetail.do")
public class EventDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int eventNo = Integer.parseInt(request.getParameter("evntNo"));
		
		IEventService service = EventServiceImpl.getInstance();
		
		EventVO eventVo = service.eventDetail(eventNo);
		
		request.setAttribute("eventDetail", eventVo);
		
		request.getRequestDispatcher("/event/eventDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
