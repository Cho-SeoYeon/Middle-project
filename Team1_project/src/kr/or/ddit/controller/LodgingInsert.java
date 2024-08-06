package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import kr.or.ddit.service.IManagementLodgingService;
import kr.or.ddit.service.ManagementLodgingServiceImpl;
import kr.or.ddit.vo.ManagementLodgingVO;

@WebServlet("/lodgingInsert.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10,
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class LodgingInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("application/json; charset=utf-8");
	     
	     int roomNo = Integer.parseInt(request.getParameter("roomNo"));
	     String roomType = request.getParameter("roomType");
	     int price =Integer.parseInt(request.getParameter("price"));
	     int prs =Integer.parseInt(request.getParameter("prs"));
	     String lodgingCode = request.getParameter("lodgingCode");
	     
	     Part roomImgPart = request.getPart("roomImg"); // 숙소 이미지
	     String fileName = extractFileName(roomImgPart);
	     
	     ManagementLodgingVO vo = new ManagementLodgingVO();

	     vo.setRoom_no(roomNo);
	     vo.setRoom_type(roomType);
	     vo.setRoom_price(price);
	     vo.setRoom_prs(prs);
	     vo.setLod_code(lodgingCode);
	     
	     
	     IManagementLodgingService service = ManagementLodgingServiceImpl.getInstance();
	     
	     String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
	     System.out.println("uploadPath" + uploadPath);
	        // 저장될 폴더가 없으면 새로운 폴더 생성
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        
	        
	        String roomImgFilePath = uploadPath + File.separator + fileName;
	        System.out.println("==========================================");
	        System.out.println("uploadPath =>>>" + uploadPath);
	        System.out.println("File.separator =>>>" + File.separator);
	        System.out.println("==========================================");
	        System.out.println("filePath : " + roomImgFilePath);

	        roomImgPart.write(roomImgFilePath);
	        
	        vo.setR_img_path(fileName);
	        
	        //	서비스 실행
	        int cnt = service.roomInsert(vo);
	        System.out.println("cnt ===" + cnt);

	        JSONObject json = new JSONObject();
	        response.getWriter().print(json.toJSONString());
	     
	}

	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length()-1);
            }
        }
        return "";
    }

	

}
