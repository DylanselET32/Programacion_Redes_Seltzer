package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import utils.conexion;

public class servidor extends conexion {

	DataInputStream disSer = null;

	public servidor() {
		super("servidor");
	}

	@SuppressWarnings("deprecation")
	public void serverOn() {
		try {
			ps.println("Esperando a un cliente ...");

			// congela programa (thread)
			sock = servSock.accept();
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosSer = new DataOutputStream(sock.getOutputStream());
			disSer = new DataInputStream( sock.getInputStream());

			ps.println("Cliente conectado con exito Ya podes hablar!!");
			
			
			// thread que escucha todo el tiempo los mensajes que lleguen
			Thread recibeSocket = new Thread(
					new Runnable() {
						public void run() {
							try {
									while (msgToSend != "/exit" || msg != "/exit") {
										msg = disSer.readUTF();
										if(msg.equals("/exit"))
										{
											ps.println(ANSI_RED + "-------- Cliente desconectado --------" + ANSI_RESET);
											break;
										}
										ps.println(ANSI_PURPLE + ">" + msg + ANSI_RESET);
						
										
									
									}
									
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}finally {
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
					},"EscuchaSocket"
			);
			
			recibeSocket.start();
					
			
			// thread que escucha todo el tiempo la consola y envia los mensajes al cliente
						Thread envioMsgSocket = new Thread(
								new Runnable() {
									public void run() {
										try {
											
												while (msgToSend != "/exit" || msg != "/exit") {
													ps.print(ANSI_GREEN + "> ");
													msgToSend = br.readLine();
													ps.println(ANSI_RESET);
													if(msgToSend.equals("/exit") || msg.equals("/exit"))
													{
														ps.println(ANSI_RED + "-------- Chat Cerrado --------" + ANSI_RESET);
														break;
													}
													if(msgToSend != null  && msgToSend != "") {
														dosSer.writeUTF(msgToSend);
														dosSer.flush();
													}
													
												}
												
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}finally {
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
								},"EnvioMsgSocket"
						);
						
						envioMsgSocket.start();
						
			

		} catch (IOException e) {
			ps.println(ANSI_RESET);
			e.printStackTrace();
		} 

	}

}
