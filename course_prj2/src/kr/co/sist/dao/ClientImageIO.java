package kr.co.sist.dao;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//사용 편의성을 위해서 메서드를 static으로 함
public class ClientImageIO {
	
	
	public ClientImageIO() throws IOException {
	}
	
	public static void writeImage(String path, String fileType, String id) throws IOException {
		//소켓 연결
		Socket socket = new Socket("192.168.10.143", 99000);
		OutputStream os = socket.getOutputStream();
		DataOutputStream dosWriteStream = new DataOutputStream(os);
		
		//컴퓨터에 있는 이미지 파일을 읽기 위한 연결
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		
		try {
			//학번, 사번 전달
			dosWriteStream.writeUTF(id);
			dosWriteStream.flush();
			
			//파일명 전달
			dosWriteStream.writeUTF(fileType);
			dosWriteStream.flush();
			
			//소켓으로 보내기 위해서 하는 작업
			byte[] data  = new byte[2048];
			int len = 0;
			while((len = fis.read(data)) != -1) {
				os.write(data, 0, len);
			}
			os.flush();
			
			System.out.println("이미지 전송 완료");
			
			
		} finally {
			if(os != null) { os.close(); }
			if(socket != null) { socket.close(); }
			if(fis != null) { fis.close(); }
		}
	}
	
	public static ImageIcon readImage(String id) throws IOException {
		//소켓 연결
		Socket socket = new Socket("192.168.10.143", 99001);
		InputStream is = socket.getInputStream();
		
		try {
			//입력을 받기 위한 연결 작업
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			//사용자 사진을 구분하기 위해서 사번 또는 학번을 보낸다
			dos.writeUTF(id);
			dos.flush();
			
			//바이트로 되어있는 이미지 파일을 읽어온다.
			byte[] data = is.readAllBytes();

			System.out.println("사진 불러오기 성공");
			
//			JFrame jf = new JFrame();
			ImageIcon icon = new ImageIcon(data);
			return icon;
//			JLabel jl = new JLabel(icon);
			
//			jf.add(jl);
//			jf.setBounds(100, 150, 400, 600);
//			jf.setVisible(true);
//			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
		} finally {
			if(is != null) { is.close(); }
			if(socket != null) { socket.close(); }
		}
	}
	
//	public static void main(String[] args) {
//		Frame f = new Frame();
//		
//		try {
//			ClientImageIO client = new ClientImageIO();
////			
////			FileDialog fd = new FileDialog(f, "사진 찾기", FileDialog.LOAD);
////			fd.setVisible(true);
////			
////			String fileType = fd.getFile().substring(fd.getFile().lastIndexOf("."));
////			
////			client.writeImage(fd.getDirectory()+fd.getFile(), fileType, "20230004");
//			System.out.println("------------------------------------------------------------------------");
//			client.readImage("20230004");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
