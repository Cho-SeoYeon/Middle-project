package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IQnaService;
import kr.or.ddit.service.QnaServiceImpl;
import kr.or.ddit.vo.QnaVO;

@WebServlet("/adminQnaList.do")
public class AdminQnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        IQnaService service = QnaServiceImpl.getInstance();
        
        
        List<QnaVO> qnaList = service.qnaList();
        
        request.setAttribute("qnaList", qnaList);
        request.getRequestDispatcher("/qnaReply/adminQnaList.jsp").forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
