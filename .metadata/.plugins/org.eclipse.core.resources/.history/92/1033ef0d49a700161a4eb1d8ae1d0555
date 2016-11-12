package InteligenciaArtificial;

import Game.*;

public class InteligenciaPala extends Thread {

	private Juego juego;
	private boolean condicion;
	
	public InteligenciaPala(Juego j) {
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
			juego.baseNormal();
			condicion = false;
		}
	}
	
	public void interrumpir()
	{
		condicion = false;
	}
}
