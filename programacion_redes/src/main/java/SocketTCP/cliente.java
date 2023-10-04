package SocketTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente extends conexion {

	InputStreamReader isrCli = null;
	DataInputStream disCli = null;

	public cliente() {
		super("cliente");
	}

	public void clienteOn() {
		try {

			ps.println("IP: " + sock.getInetAddress().getHostAddress() + 
					"\nNombre: " + sock.getInetAddress().getHostName() + 
					"\nPort: " + sock.getPort()  + 
					"\nPort Local: " + sock.getLocalPort() +
					"\n"
					);

			dosCli = new DataOutputStream(sock.getOutputStream());
			disCli = new DataInputStream(sock.getInputStream());
		
			ps.println("enviando mensaje");
			dosCli.writeUTF("Hola Todo Bien?");
			dosCli.writeUTF("Buen dia");
			dosCli.flush();

			while (true) {
				msg = disCli.readUTF();
				ps.println("--"+msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();


				if (isrCli != null)
					isrCli.close();
				
				if (dosCli != null)
					dosCli.close();
				
				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}