package InteligenciaArtificial;

import Game.*;

public class InteligenciaInvulnerable extends Thread {

	private Juego juego;
	private boolean condicion;
	
	public InteligenciaInvulnerable(Juego j) {
		juego = j;
		condicion = true;
	}
	
	public void run() {
		while(condicion){
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.setVulnerable();
			condicion = false;
		}
	}
	
	public void interrumpir()
	{
		condicion = false;
	}
}
