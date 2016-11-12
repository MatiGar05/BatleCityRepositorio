package InteligenciaArtificial;

import java.util.Iterator;
import Game.Juego;
import General.*;
import Municion.*;
import TDALista.*;
import Unidades.*;

public class InteligenciaBalaEnemigo extends Thread 
{

	private Juego j;
	private BalaEnemigo b;
	private boolean condicion;
	private Tanque miTanque;
	
	public InteligenciaBalaEnemigo(Juego jueg, BalaEnemigo b, Tanque t)
	{
		j=jueg;
		this.b=b;
		condicion = true;
		miTanque = t;
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
		for(GameObject o : j.getTodo()) 
		{
			if(b.getRect().intersects(o.getRect()))
			{
				if (o != miTanque)
				{
					listaColision.addLast(o);
				}
			}
		}
		for (Bala ba : j.getBalasJugador())
		{
			if (b.getRect().intersects(ba.getRect()))
			{
				listaColision.addLast(ba);
			}
		}
		if (j.getJugador()!=null && b.getRect().intersects(j.getJugador().getRect()))
		{
			listaColision.addLast(j.getJugador());
		}
		boolean seguir = true;
		Iterator<GameObject> it = listaColision.iterator();			
		GameObject g;
		while(it.hasNext() && seguir )
		{
			g = it.next();
			seguir= !(g.colisionarCon(b.getColider()) && seguir);
		}		
	}	
}