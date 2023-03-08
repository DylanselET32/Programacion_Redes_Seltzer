package repasoPOO;

public class Pistola extends Arma{

	private int balas;

	public Pistola(int nSerie,int balas) {
		super(nSerie);
		this.balas = balas;
		// TODO Auto-generated constructor stub
	}
	
	public void disparar() {
		System.out.println("BUMM (disparo)");
	}
	
	
	
}
