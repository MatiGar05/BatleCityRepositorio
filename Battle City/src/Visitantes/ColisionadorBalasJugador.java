package Visitantes;

import Municion.*;
import Unidades.*;
import General.*;
import TDALista.*;
import Obstaculos.*;

public class ColisionadorBalasJugador extends Visitor {
	
	protected BalaJugador miBala;
	
	public ColisionadorBalasJugador(BalaJugador b)
	{
		miBala = b;
	}
	
	public boolean ColisionarParedLadrillo(ParedLadrillo p)
	{
		try
		{
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().actualizar();
			p.setGolpesResis(p.getGolpeResis() - 1);
			if (p.getGolpeResis() == 3)
			{
				p.cambiarGrafico(1);				
			}
			else
				if (p.getGolpeResis() == 2)
				{
					p.cambiarGrafico(2);
				}
				else
					if (p.getGolpeResis() == 1)
					{
						p.cambiarGrafico(3);
					}
					else
						if (p.getGolpeResis() == 0)
						{							
							miBala.getTanque().getJuego().getGui().remove(p.getGrafico());
							boolean encontre= false;
							PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
							PositionList<Obstaculo> obs = miBala.getTanque().getJuego().getObs();
							Position<GameObject> puntero= todo.first();
							Position<Obstaculo> puntero2= obs.first();
							for(int j=0;j<todo.size()&&!encontre;j++){
								encontre=puntero.element()==p;
								if(!encontre)
									puntero=todo.next(puntero);					
							}	
							if(encontre){
								todo.remove(puntero);
								miBala.getTanque().getJuego().setTodo(todo);
							}
							encontre = false;
							for(int j=0;j<obs.size()&&!encontre;j++){
								encontre=puntero2.element()==p;
							if(!encontre)
							puntero2=obs.next(puntero2);					
							}	
							if(encontre){
								obs.remove(puntero2);
								miBala.getTanque().getJuego().setObs(obs);
							}
							p = null;
							miBala.getTanque().getJuego().getGui().actualizar();
							miBala = null;							
						}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException exc)
		{
			System.out.println(exc.getMessage());
		}
		return true;
	}
	
	public boolean ColisionarParedAcero(ParedAcero pa )
	{
		miBala.destruirBalaJugador();
		miBala.getTanque().getJuego().getGui().actualizar();
		miBala = null;
		return true;
	}
	
	public boolean ColisionarArbol(Arbol a)
	{
		return false;
	}
	
	public boolean ColisionarAgua(Agua a)
	{
		return false;
	}
	
	public boolean ColisionarAguila(Aguila a)
	{
		miBala.destruirBalaJugador();
		miBala.getTanque().getJuego().getGui().actualizar();
		miBala = null;
		return true;
	}
	
	public boolean ColisionarBloqueo(Bloqueo b)
	{
		miBala.destruirBalaJugador();
		miBala.getTanque().getJuego().getGui().actualizar();
		miBala = null;
		return true;
	}
	
	public boolean ColisionarTanqueEnemigo(Enemigo t)
	{
		try
		{	
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().remove(t.getGrafico());
			miBala.getTanque().getJuego().getGui().actualizar();
			miBala.getTanque().getJuego().setPulsado(false);
			miBala.getTanque().getJuego().setPuntaje(miBala.getTanque().getJuego().getPuntaje() + t.getPuntaje());
			System.out.println("Puntaje: "+miBala.getTanque().getJuego().getPuntaje());
			boolean encontre = false;
			PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
			Position<GameObject> puntero = todo.first();
			for(int j = 0; j < todo.size() && !encontre; j++)
			{
				encontre = puntero.element() == t;
				if(!encontre)
				puntero = todo.next(puntero);					
			}	
			if(encontre)
			{
				todo.remove(puntero);
				miBala.getTanque().getJuego().setTodo(todo);
			}
			encontre = false;
			PositionList<Enemigo> malos = miBala.getTanque().getJuego().getMalos();
			Position<Enemigo> puntero1 = malos.first();
			for(int j = 0; j < malos.size() && !encontre; j++)
			{
				encontre = puntero1.element() == t;
				if(!encontre)
				puntero1 = malos.next(puntero1);					
			}	
			if(encontre)
			{
				malos.remove(puntero1);
				miBala.getTanque().getJuego().setMalos(malos);
			}
			t = null;
			miBala = null;
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException exc)
		{
			System.out.println(exc.getMessage());
		}
		return true;
	}
	
	public boolean ColisionarTanqueJugador(Jugador j)
	{
		return true;
	}
	
	public boolean ColisionarBalaJugador(BalaJugador t)
	{	
		return false;
	}
	
	public boolean ColisionarBalaEnemigo(BalaEnemigo t)
	{
		miBala.destruirBalaJugador();
		t.destruirBalaEnemigo();
		miBala.getTanque().getJuego().getGui().remove(t.getGrafico());
		miBala.getTanque().getJuego().getGui().actualizar();
		miBala = null;
		return true;
	}
}
