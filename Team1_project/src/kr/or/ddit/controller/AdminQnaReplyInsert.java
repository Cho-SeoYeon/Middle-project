package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.ddit.service.IQnaReplyService;
import kr.or.ddit.service.QnaReplyServiceImpl;
import kr.or.ddit.vo.QnaReplyVO;

@WebServlet("/adminQnaReplyInsert.do")
public class AdminQnaReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String content = request.getParameter("content");
		System.out.println("content : " + content);
		QnaReplyVO vo = new QnaReplyVO();
		
		IQnaReplyService service = QnaReplyServiceImpl.getInstance();
		
		service.replyInsert(vo);
		
		JSONObject json = new JSONObject();

		response.getWriter().print(json.toJSONString());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


