package InteligenciaArtificial;

import java.util.Iterator;

import Game.Juego;
import General.*;
import Municion.*;
import TDALista.*;

public class InteligenciaBalaJugador extends Thread 
{

	private Juego j;
	private BalaJugador b;
	private boolean condicion;
	
	public InteligenciaBalaJugador(Juego jueg, BalaJugador b)
	{
		j=jueg;
		this.b=b;
		condicion = true;
	}
	
	public void run()
	{
		while(condicion)
		{
			try 
			{
				Thread.sleep(50);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			b.mover();			
			controlarColi();
			
		}
	}
	
	public void cambiarVariable()
	{
		condicion = false;
	}
	
	public void controlarColi()
	{
		PositionList<GameObject> listaColision = new ListaDoblementeEnlazada<GameObject>();
		for(GameObject g : j.getTodo()) 
		{
			if(b.getRect().intersects(g.getRect()))
			{
				listaColision.addLast(g);
			}
		}
		for (Bala ba : j.getBalasEnemigo())
		{
			if (b.getRect().intersects(ba.getRect()))
			{
				listaColision.addLast(ba);
			}
		}
		boolean seguir = true;
		Iterator<GameObject> it = listaColision.iterator();			
		GameObject g;
		while(it.hasNext() && seguir)
		{
			g = it.next();
			seguir= !(g.colisionarCon(b.getColider()) && seguir);
		}		
	}	
}