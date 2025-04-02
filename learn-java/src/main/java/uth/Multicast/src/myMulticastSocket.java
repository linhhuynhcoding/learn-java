package uth.Multicast.src;

import java.net.*;
import java.io.*;
public class myMulticastSocket 
{
	int port=3030;
	String group="230.0.0.1";
	MulticastSocket s;
	public myMulticastSocket() throws IOException
	{
		s = new MulticastSocket(port);
//		System.out.println(s.get);
		// Xác định địa chỉ nhóm và giao diện mạng (WiFi/Ethernet)
		InetAddress _group = InetAddress.getByName(group);
		NetworkInterface networkInterface = NetworkInterface.getByName("wlan0"); // "eth0" nếu dùng dây

		// Tham gia nhóm Multicast (Cách mới)
//		s.joinGroup(new InetSocketAddress(_group, port));

//		s.joinGroup(InetAddress.getByName(group));
	}
	public Boolean receive() throws UnknownHostException, IOException
	{		
		//System.out.println("Dang cho nhan!!!");
		byte buf[] = new byte[1024];
		DatagramPacket pack = new DatagramPacket(buf, buf.length);
		s.receive(pack);
		System.out.println("Da nhan du lieu tu: " + pack.getAddress().toString() +
			    ":" + pack.getPort() + " with length: " +
			    pack.getLength());
		System.out.write(pack.getData(),0,pack.getLength());
		System.out.println();

		s.leaveGroup(InetAddress.getByName(group));
		s.close();
		String tiep=  new String(pack.getData(),0,pack.getLength());		
		if (tiep.equalsIgnoreCase("quit"))
			return false;
		return true;
	}
	public static void main(String[] args) throws IOException 
	{
		Boolean tiep=true;
		while (tiep)
		{
			myMulticastSocket a=new myMulticastSocket();
			tiep=a.receive();
		}
	}

}
