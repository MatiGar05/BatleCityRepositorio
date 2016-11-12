package InteligenciaArtificial;

import Game.Juego;
import PowerUps.*;

public class InteligenciaPowerUp extends Thread 
{
	private Juego elJuego;
	private boolean condicion;
	private PowerUp miP;
	
	public InteligenciaPowerUp(Juego j, PowerUp p) 
	{
		this.elJuego = j;
		condicion = true;
		miP = p;
	}

	public void run() {
		while(condicion)
		{
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.eliminarPowerUp(miP);
		}
	}
	
	public void cambiarVariable()
	{
		condicion = false;		
	}
}