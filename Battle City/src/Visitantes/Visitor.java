package Visitantes;

import Obstaculos.*;
import Municion.*;
import Unidades.*;

public abstract class Visitor { 
	
	public abstract boolean ColisionarParedLadrillo(ParedLadrillo p);
	
	public abstract boolean ColisionarParedAcero(ParedAcero pa );
	
	public abstract boolean ColisionarArbol(Arbol a);
	
	public abstract boolean ColisionarAgua(Agua a);
	
	public abstract boolean ColisionarAguila(Aguila a);
	
	public abstract boolean ColisionarBloqueo(Bloqueo b);
	
	public abstract boolean ColisionarTanqueEnemigo(Enemigo t);
	
	public abstract boolean ColisionarTanqueJugador(Jugador j);
	
	public abstract boolean ColisionarBalaJugador(BalaJugador t);
	
	public abstract boolean ColisionarBalaEnemigo(BalaEnemigo t);
}
