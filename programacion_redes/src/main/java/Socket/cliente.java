package Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class cliente {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String IP = "230.1.1.1";
		int port = 5050;
		MulticastSocket socket = null;
		PrintStream ps = new PrintStream(System.out);
		InetAddress IPaddress = null;
		try {
			socket = new MulticastSocket(port);
			IPaddress = InetAddress.getByName(IP);
			socket.joinGroup(IPaddress);
			ps.println("Esperando conexion multicast...");
			ps.println(socket.getLocalSocketAddress());

			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			ps.println("Esperando mensaje...");
			socket.receive(packet);
			
			ps.println("LLEGO EL MENSAJE...");
			
			String msg = new String(packet.getData(),packet.getOffset(),packet.getLength());
			ps.println(msg);
			socket.leaveGroup(IPaddress);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
