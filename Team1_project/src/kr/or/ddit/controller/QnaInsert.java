package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IQnaService;
import kr.or.ddit.service.QnaServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.QnaVO;


@WebServlet("/qnaInsert.do")
public class QnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		QnaVO qnaVo = new QnaVO();
		IQnaService service = QnaServiceImpl.getInstance();
		if (session != null) {

			MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
			
			if (memVo != null) {
				System.out.println("ID세션이 존재 합니다~~~~~~~~~");
				qnaVo.setUser_id(memVo.getUser_id());
				
			}
		}
		
		
		
		
		
		
		qnaVo.setQna_title(request.getParameter("qna_title"));
		qnaVo.setQna_cont(request.getParameter("qna_cont"));
		qnaVo.setQna_pass(request.getParameter("qna_pass"));
		request.setAttribute("cnt", service.myQnaInsert(qnaVo));
		
		request.getRequestDispatcher("/qna/myqnaInsert.jsp").forward(request, response);
		
	}

}
