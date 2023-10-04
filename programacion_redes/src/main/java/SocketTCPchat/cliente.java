package SocketTCPchat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente extends conexion {

	InputStreamReader isrCli = null;
	DataInputStream disCli = null;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);

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
			
			
			boolean bucle = true;
			while (bucle) {
				ps.println("Escriba un mensaje a enviar: ");
				while((msg = br.readLine()) != null && msg != "") {
					if(msg == "/exit") {
						bucle = false;
					}
					dosCli.writeUTF(msg);
					dosCli.flush();
				}
				msg = null;
				if(bucle) {
					while ((msg = disCli.readUTF()) != null) {
					ps.println("--"+msg);
					}
				}
				
				
				
			}
			
			Thread.sleep(200);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();

				br.close();
				isr.close();
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