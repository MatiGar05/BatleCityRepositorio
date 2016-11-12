package InteligenciaArtificial;

import Game.Juego;

public class InteligenciaEnemigo extends Thread 
{
	private Juego elJuego;
	private boolean interrumpido;
	private boolean condicion;

	public InteligenciaEnemigo(Juego j) {
		this.elJuego = j;
		interrumpido=false;
		condicion = true;
	}

	public void run() {
		while(condicion){
			try {
				if(!interrumpido)
					Thread.sleep(100);
				else{
					Thread.sleep(10000);
					interrumpido=false;
				} 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.mover();
			elJuego.disparoEnemigo();
		}
	}
	
	public void interrumpir(){
		interrumpido = true;
	}
	
	public void cambiarVariable()
	{
		condicion = false;
	}
}