package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IQnaService;
import kr.or.ddit.service.QnaServiceImpl;
import kr.or.ddit.vo.QnaVO;


@WebServlet("/qnaDetail.do")
public class QnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		IQnaService service = QnaServiceImpl.getInstance();
		QnaVO qnaVo = service.qnaDetail(qnaNo);
		
		request.setAttribute("qnavo", qnaVo);
	
		
		request.getRequestDispatcher("/qna/detailQna.jsp").forward(request, response);
		
		
		 
	}

}
