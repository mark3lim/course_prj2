package kr.co.sist.dao;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOutput {
	
	private ServerSocket server;
	private Socket socket;
	private DataInputStream disReadStream;
	private OutputStream os;
	
	public ServerOutput() throws IOException {
		server = new ServerSocket(99001);
		System.out.println("서버 작동 중");
		
		while (true) {
			socket = server.accept();
			System.out.println("accept");
			disReadStream = new DataInputStream(socket.getInputStream());
			os = socket.getOutputStream();
			String id = disReadStream.readUTF();
			writeImage(id);
		}
		
	}
	
	public void writeImage(String id) throws IOException {
		StringBuilder path = new StringBuilder();
		path.append("e:/tempImage/").append(id).append("/");
		
		File file = new File(path.toString());
		FileInputStream fis = null;
		
		
		try {
			//이미지 파일명을 갖고 오기 위해서 사용
			String[] strFileList = file.list();
			
			//실행 시 오류가 나면 strFileList[0]를 strFileList[1]로 변경하여 시도. 0번 인덱스에 정크 파일이 있어서 발생하는 문제로 주로 맥에서 일어난다.
			path.append("/").append(strFileList[0]);
			file = new File(path.toString());
			
			//이미지 파일을 읽기 위한 스트림
			fis = new FileInputStream(file);
			
			//이미지 파일을 읽어 들이고 소켓으로 보내는 작업
			byte[] data  = new byte[2048];
			int len = 0;
			while((len = fis.read(data)) != -1) {
				os.write(data, 0, len);
			}
			os.flush();
			
			System.out.println("이미지 전송 완료");
			
			
		} finally {
			if(os != null) { os.close(); }
			if(fis != null) { fis.close(); }
			if(socket != null) { socket.close(); }
			if(server != null) { server.close(); }
		}
	}
	
	public static void main(String[] args) {
		try {
			new ServerOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
