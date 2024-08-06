package kr.or.ddit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageView
 */
@WebServlet("/imageView.do")
@MultipartConfig
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 파라미터로 넘어온 파일 번호를 구한다.
		String saveName = request.getParameter("file");
		
		String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images"; 
//				"d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 새로 폴더를 만들어 준다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// File 객체 생성
		File imgFile = new File(f, saveName);
		
		System.out.println(imgFile);
		
		if(imgFile.exists()) { // 해당 파일이 있을 때..
			// 서버에 저장된 파일을 읽어서 클라이언트로 전송한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				// 출력용 스트림 객체 생성
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len= bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e);
			} finally {
				if(bin !=null) try {bin.close();} catch(IOException e) {}
				if(bout !=null) try {bout.close();} catch(IOException e) {}
			}
						
		}
	}
}
