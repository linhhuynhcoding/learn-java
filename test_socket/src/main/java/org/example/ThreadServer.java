import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @author Dang Nhan Cach
 * @version 1.0
 *
 */

public class ThreadServer extends Thread {
	
	Socket socket = null;

	public ThreadServer(Socket socket) {
		this.socket = socket;
	}

	public void run() {
	
		try {
			// Tao luon lam viec gui va nhan
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			
			String inLine;
			
			// In cac thong tin ket noi den server
			System.out.println("Client is connected:");
			System.out.println("     Client Name:"
					+ socket.getInetAddress().getHostName());
			System.out.println("     IP Address :"
					+ socket.getInetAddress().getHostAddress());
			System.out.println("     Client Port:" + socket.getPort());
		
			while (true) {
				// Nhan du lieu tu client gui len
				inLine = in.readLine();
				if (inLine.equalsIgnoreCase("quit"))
					break;
				else {
					// Xu ly thong tin tai dau
					out.println(doichuoi(inLine));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description doi chuoi bat ky thanh chuoi hoa
	 * @param st 
	 * @return String
	 * 
	 */
	public String doichuoi(String st) {
		// Doi thanh chuoi HOA
		st=st.toUpperCase();
		return st;
	}
}