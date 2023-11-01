package principal;

import java.io.PrintStream;

public class main {
	static PrintStream ps;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cicloVida hilo = new cicloVida();
		ps = new PrintStream(System.out);
		//hilo.run(); //llama al metodo, no al hilo 
		hilo.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(hilo.getState() != Thread.State.TERMINATED) {
			ps.println(hilo.getState());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
