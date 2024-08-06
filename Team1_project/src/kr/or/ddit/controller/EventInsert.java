package kr.or.ddit.controller;

import java.io.IOException;
import java.util.UUID;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import kr.or.ddit.service.EventServiceImpl;
import kr.or.ddit.service.IEventService;
import kr.or.ddit.vo.EventVO;

@WebServlet("/eventInsert.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10,
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class EventInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        String title = request.getParameter("title");
        String cnpcode = request.getParameter("cnpcode");
        
        Part part = request.getPart("fimg");
        System.out.println("part : " + part);
        
        String fileName = extractFileName(part);
      // String saveFileName = UUID.randomUUID().toString() + "_" + fileName;
        System.out.println("fileName  === " + fileName);
        
        EventVO vo = new EventVO();

        vo.setEvnt_title(title);
        vo.setCnp_code(cnpcode);

        IEventService service = EventServiceImpl.getInstance();

        // 업로드된 파일들이 저장될 폴더 설정 (웹 애플리케이션 내부 경로 사용)
        String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
        
        System.out.println("uploadPath" + uploadPath);
        // 저장될 폴더가 없으면 새로운 폴더 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        
        String filePath = uploadPath + File.separator + fileName;
        System.out.println("filePath : " + filePath);
        part.write(filePath); // 파일을 경로에 저장

        vo.setEvnt_img_path(fileName);
        
        //	서비스 실행
        int cnt = service.eventInsert(vo);
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
