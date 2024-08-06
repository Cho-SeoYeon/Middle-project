package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.ILodgingService;
import kr.or.ddit.service.LodgingServiceImpl;
import kr.or.ddit.vo.RoomsVO;


@WebServlet("/lodgingRoomsList.do")
public class LodgingRoomsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String lodCode = request.getParameter("lod_code");
		int guestNum = Integer.parseInt(request.getParameter("guestNum")==null?"2":request.getParameter("guestNum"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		ILodgingService service = LodgingServiceImpl.getInstance();
		List<RoomsVO> roomsList = null;
		
		roomsList = service.roomsList(lodCode, guestNum, startDate, endDate);
		
		String json = new Gson().toJson(roomsList);
		response.getWriter().write(json);
		
	}

}
