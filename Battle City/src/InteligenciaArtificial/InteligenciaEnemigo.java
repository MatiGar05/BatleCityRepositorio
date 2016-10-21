package InteligenciaArtificial;

import Game.Juego;

public class InteligenciaEnemigo extends Thread 
{
	private Juego elJuego;

	public InteligenciaEnemigo(Juego j) {
		this.elJuego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.mover();
			elJuego.disparoEnemigo();
		}
	}
}