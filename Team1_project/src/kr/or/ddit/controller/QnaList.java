package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.QnaServiceImpl;
import kr.or.ddit.vo.QnaVO;

//전체 고객문의 리스트
@WebServlet("/qnaList.do")
public class QnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        QnaVO qnavo = new QnaVO();
        Map<String, Object> res = new HashMap<>();
        //String pass=request.getParameter("pass");
        //qnavo.setQna_pass(pass);
        qnavo.setSearchTxt(request.getParameter("searchTxt"));
        qnavo.setPaging(Integer.parseInt(request.getParameter("pageNo")), Integer.parseInt(request.getParameter("recordCountPerPage")));
        
        QnaServiceImpl service = QnaServiceImpl.getInstance();
        res.put("qnaList", service.qnaList(qnavo));
        res.put("totCnt", service.qnaListCnt(qnavo));

        
        response.getWriter().write(new Gson().toJson(res));
	}

}
