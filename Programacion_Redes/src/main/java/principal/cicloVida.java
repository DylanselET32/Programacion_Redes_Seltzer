package principal;

import java.io.PrintStream;

public class cicloVida extends Thread{
	PrintStream ps;
	public cicloVida() {
		ps = new PrintStream(System.out);
	}
	
	@Override
	public void run() {
		//acciones del hilo 
		Thread.currentThread().setName("cicloVida");
		ps.println("HILO: "+this.getName());
		ps.println("Estado: "+this.getState());
		//this.stop();
		
		try {
			this.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.stop();
	}
}
