package uth.Multicast.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class client {
	int port = 3030;
	String group = "230.0.0.1";  // Địa chỉ multicast
	int ttl = 10;  // Thời gian sống (TTL) của gói multicast
	MulticastSocket socket;

	public client() throws IOException {
		socket = new MulticastSocket();
		socket.setTimeToLive(ttl);  // Thiết lập TTL cho socket multicast
	}

	public void sendMessage(String message) throws IOException {
		byte[] buf = message.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(group), port);

		// Gửi gói tin đến nhóm multicast
		socket.send(packet);
		System.out.println("Message sent: " + message);
	}

	public static void main(String[] args) throws IOException {
		String message = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		// Nhập và gửi tin nhắn cho đến khi người dùng nhập "quit"
		while (!message.equals("quit")) {
			System.out.print("Enter message to send: ");
			message = input.readLine();

			// Gửi tin nhắn tới nhóm multicast
			client client = new client();
			client.sendMessage(message);
		}
	}
}
