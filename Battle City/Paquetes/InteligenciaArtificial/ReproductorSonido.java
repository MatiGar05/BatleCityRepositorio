package InteligenciaArtificial;

import java.applet.*;

public class ReproductorSonido extends Thread {
	
	AudioClip sonido;
	
	public ReproductorSonido(AudioClip s) {
		sonido = s;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(122000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sonido.play();
		}
	}
}
