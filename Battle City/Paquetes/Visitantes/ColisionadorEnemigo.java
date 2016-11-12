package Visitantes;

import Obstaculos.*;
import PowerUps.*;
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
	
	public boolean ColisionarEstrella(Estrella e){
		return false;
	}
	
	public boolean ColisionarCasco(Casco c)
	{
		return false;
	}
	
	public boolean ColisionarGranada(Granada g)
	{
		return false;
	}
	
	public boolean ColisionarPala(Pala p)
	{
		return false;
	}
	
	public boolean ColisionarTanqueP(TanqueP t)
	{
		return false;
	}
	
	public boolean ColisionarTimerP(TimerP t)
	{
		return false;
	}
	
	public boolean ColisionarTanqueEnemigo(Enemigo t){
		return true;
	}
	
	public boolean ColisionarTanqueJugador(Jugador j){
		return true;
	}
	
	public boolean ColisionarJugadorInvulnerable(JugadorInvulnerable j){
		return true;
	}
	
	public boolean ColisionarBalaJugador(BalaJugador t){
		return true;
	}
	
	public boolean ColisionarBalaEnemigo(BalaEnemigo t){
		return false;
	}
}