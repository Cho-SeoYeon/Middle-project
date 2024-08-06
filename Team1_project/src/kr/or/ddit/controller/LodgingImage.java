package kr.or.ddit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lodgingImage.do")
public class LodgingImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String imgName = request.getParameter("imgName");
				
		// 업로드 된 파일 저장할 폴더 설정
		String uploadPath = "D:/A_TeachingMaterial/03_HighJava/workspace/Team1_project/WebContent/images";
		
		// 저장될 폴더 없으면 새로 만들기
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
				
		File imgFile = new File(f, imgName);
		if (imgFile.exists()) {
			
			// 서버에 저장된 파일을 읽어서 클라이언트로 전송한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성 ==> Response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				// byte[]을 쓰는 게 빠르니까 ...
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp)) > 0 ) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e);
			} finally {
				if(bin != null) try { bin.close(); } catch(IOException e) { } 
				if(bout != null) try { bout.close(); } catch(IOException e) { } 
			}
		}
	}

}
