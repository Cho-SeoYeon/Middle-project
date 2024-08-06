package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/noticeInsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeVO vo = new NoticeVO();

		vo.setNotice_title(title);
		vo.setNotice_cont(content);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		service.noticeInsert(vo);
		
		JSONObject json = new JSONObject();

		response.getWriter().print(json.toJSONString());
		
	
	}
	

}
