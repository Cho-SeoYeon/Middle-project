package kr.or.ddit.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.ILodgingService;
import kr.or.ddit.service.LodgingServiceImpl;
import kr.or.ddit.vo.LodgingListVO;


@WebServlet("/lodgingList.do")
public class LodgingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		/*
		Enumeration en = request.getParameterNames();
		
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			System.out.println(name + " : " + request.getParameter(name));
		}
		*/
		
		String lodgingName = request.getParameter("lodgingName");
		int guestNum = Integer.parseInt(request.getParameter("guestNum")==null?"2":request.getParameter("guestNum"));
		String lodgingType = request.getParameter("lodgingType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		ILodgingService service = LodgingServiceImpl.getInstance();
		List<LodgingListVO> lodgingList = null;

		lodgingList = service.searchLodgingWithCond(lodgingName, guestNum, lodgingType, startDate, endDate);
		
		/*
		}else {
			lodgingList = service.getLodgingList();
		}
		*/
        String json = new Gson().toJson(lodgingList);
        response.getWriter().write(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
