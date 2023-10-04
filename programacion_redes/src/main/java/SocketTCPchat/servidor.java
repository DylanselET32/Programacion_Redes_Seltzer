package SocketTCPchat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class servidor extends conexion {

	DataInputStream disSer = null;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	public servidor() {
		super("servidor");
	}

	@SuppressWarnings("deprecation")
	public void serverOn() {
		try {
			ps.println("Esperando a un cliente ...");

			// congela programa
			sock = servSock.accept();
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosSer = new DataOutputStream(sock.getOutputStream());
			disSer = new DataInputStream(sock.getInputStream());

			ps.println("Cliente conectado con exito :) !!!");

			ps.println("Esperando mensaje del cliente ...");

			//while (true) {
			//	ps.println("--" + disSer.readUTF());
			//	dosSer.writeUTF("Ya me llego tu mensaje, graciass!"); //envia el mensaje
			//	dosSer.flush(); //limpia el canal
			//}
			
			msg = disSer.readUTF();
			ps.println("--"+msg);
			msg = null;
			
			
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
					while ((msg = disSer.readUTF()) != null) {
					ps.println("--"+msg);
					}
				}
				
			}
			
			
			/*
			 * while( (msg = read.readLine()) != null ) { //aca recibi un mensaje seguro
			 * ps.println( "mensaje recibido: " + msg );
			 * 
			 * dosSer.writeUTF("quiero !"); dosSer.flush(); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();

				

				if (disSer != null)
					disSer.close();

				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}