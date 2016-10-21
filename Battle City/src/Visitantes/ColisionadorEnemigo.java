package Visitantes;

import Obstaculos.*;
import Unidades.*;
import Municion.*;

public class ColisionadorEnemigo extends Visitor {
	
	public boolean ColisionarParedLadrillo(ParedLadrillo p){		
		return true;
	}
	
	public boolean ColisionarParedAcero(ParedAcero pa){
		return true;
	}
	
	public boolean ColisionarArbol(Arbol a){
		return false;
	}
	
	public boolean ColisionarAgua(Agua a){
		return true;
	}
	
	public boolean ColisionarAguila(Aguila a){
		return true;
	}
	
	public boolean ColisionarBloqueo(Bloqueo b){
		return true;
	}
	
	public boolean ColisionarTanqueEnemigo(Enemigo t){
		return true;
	}
	
	public boolean ColisionarTanqueJugador(Jugador j){
		return true;
	}
	
	public boolean ColisionarBalaJugador(BalaJugador t){
		return true;
	}
	
	public boolean ColisionarBalaEnemigo(BalaEnemigo t){
		return false;
	}
}