package Game;

import java.util.Iterator;
import TDALista.*;
import java.util.Random;
import Unidades.*;
import Obstaculos.Obstaculo;
import General.GameObject;
import Municion.*;

public class Juego {
	private Jugador jugador;
	private PositionList<GameObject> todo;
	private PositionList<Obstaculo> obs;
	private PositionList<Enemigo> malos;
	private PositionList<Obstaculo> borde;
	private PositionList<Bala> balasJugador;
	private PositionList<Bala> balasEnemigas;
	private boolean pulsado;
	private int puntaje;
	private int i = 0;
	private GUI gui;
	private int dir = 1;
	private int dispAct;
	private Random r;
	private int probabilidadDisparo = 2;

	
	public Juego(GUI gui, PositionList<Obstaculo> listaObs, PositionList<Enemigo> listaEne, PositionList<GameObject> listaTodo, PositionList<Obstaculo> listaBorde)
	{
		this.setTodo(listaTodo);
		this.setMalos(listaEne);
		this.setObs(listaObs);
		this.setBorde(listaBorde);
		balasJugador = new ListaDoblementeEnlazada<Bala>();
		balasEnemigas = new ListaDoblementeEnlazada<Bala>();
		r = new Random();
		puntaje = 0;
		pulsado = false;
		this.gui = gui;
		dispAct = 0;
		jugador = new Jugador(1,5,10,335,595,4,1,1);
		jugador.setJuego(this);	
		for(Obstaculo o : borde)
		{
			gui.add(o.getGrafico());
		}
		for(Obstaculo o : obs)
		{			
			gui.add(o.getGrafico());
		}
		for(Enemigo e : malos)
		{
			gui.add(e.getGrafico());
			e.setJuego(this);
		}
		gui.add(jugador.getGrafico());
	}
	
	public void mover(int dir)
	{			
		PositionList<GameObject>listaColision=new ListaDoblementeEnlazada<GameObject>();
		jugador.adelantarMovimiento(dir);
		for(GameObject g : todo) 
		{
			if(jugador.getRect().intersects(g.getRect()))
			{
				listaColision.addLast(g);
			}
		}
		boolean moverse=true;
		Iterator<GameObject> it = listaColision.iterator();			
		GameObject g ;
		while(it.hasNext() && moverse)
		{
			g=it.next();
			moverse = !(g.colisionarCon(jugador.getColider())) && moverse;
		}
		if(moverse)
		{
			jugador.retrocederMovimiento(dir);
			jugador.mover(dir);	
		}
		else
		{
			jugador.retrocederMovimiento(dir);
		}
	}	
	
	public PositionList<Bala> getBalasJugador()
	{
		return balasJugador;
	}
	
	public PositionList<Bala> getBalasEnemigo()
	{
		return balasEnemigas;
	}
	
	public Jugador getJugador()
	{
		return jugador;
	}
	
	public int getPuntaje()
	{
		return puntaje;
	}
	
	public void setPuntaje(int pun)
	{
		puntaje = pun;
	}
	
	public PositionList<GameObject> getTodo()
	{
		return todo;
	}
	
	public PositionList<Enemigo> getMalos()
	{
		return malos;
	}
	
	public PositionList<Obstaculo> getObs()
	{
		return obs;
	}
	
	public PositionList<Obstaculo> getBorde()
	{
		return borde;
	}
	
	public void setTodo(PositionList<GameObject> t)
	{
		todo = t;
	}
	
	public void setMalos(PositionList<Enemigo> m)
	{
		malos = m;
	}
	
	public void setObs(PositionList<Obstaculo> o)
	{
		obs = o;
	}
	
	public void setBorde(PositionList<Obstaculo> o)
	{
		borde = o;
	}
	
	public void setPulsado(boolean pul)
	{
		pulsado = pul;
	}
	
	public int getDispAct()
	{
		return dispAct;
	}
	
	public void setDispAct(int dis)
	{
		dispAct = dis;
	}
	
	public void disparoEnemigo()
	{
		for (Enemigo o : malos)
		{
			if (o.getDispAct() == 0)
			{
				if (r.nextInt(30) < probabilidadDisparo)
				{
					BalaEnemigo b = o.disparar();
					balasEnemigas.addLast(b);
					gui.add(b.getGrafico());
					b.getHiloEnemigo().start();
					o.setDispAct(o.getDispAct() + 1);
				}
			}
		}
	}
	
	public void moverBalaJugador()
	{	
		if (dispAct == 0)
		{
			BalaJugador b = jugador.disparar();
			balasJugador.addLast(b);
			gui.add(b.getGrafico());
			b.getHiloJugador().start();
			dispAct++;
		}
	}
		
	public void borrarBalaJugador(Bala b)
	{
		try
		{
			boolean encontre= false;
			Position<Bala> puntero = balasJugador.first();
			for(int j=0; j < balasJugador.size() && !encontre; j++)
			{
				encontre= puntero.element().equals(b);
				if(!encontre)
				puntero = balasJugador.next(puntero);					
			}	
			if(encontre)
			{
				balasJugador.remove(puntero);
				gui.remove(puntero.element().getGrafico());
				dispAct--;
			}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void borrarBalaEnemigo(Bala b, Tanque t)
	{
		try
		{
			boolean encontre= false;
			Position<Bala> puntero = balasEnemigas.first();
			for(int j=0; j < balasEnemigas.size() && !encontre; j++)
			{
				encontre= puntero.element().equals(b);
				if(!encontre)
				puntero = balasEnemigas.next(puntero);					
			}	
			if(encontre)
			{
				t.setDispAct(t.getDispAct() - 1);
				balasEnemigas.remove(puntero);
				gui.remove(puntero.element().getGrafico());
			}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void mover()
	{
		PositionList<GameObject>listaColision=new ListaDoblementeEnlazada<GameObject>();
		for(Enemigo o: malos)
		{			
			Random r = new Random();
			dir = o.getDir();		
			o.adelantarMovimiento(dir);
			for(GameObject g : todo) 
			{
				if(o.getRect().intersects(g.getRect()))
				{
					if (o != g)
					{
						listaColision.addLast(g);
					}
				}
			}
			if (o.getRect().intersects(jugador.getRect()))
			{
				listaColision.addLast(jugador);
			}
			boolean moverse=true;
			Iterator<GameObject> it = listaColision.iterator();			
			GameObject g ;
			while(it.hasNext() && moverse)
			{
				g=it.next();
				moverse = !(g.colisionarCon(o.getColider())) && moverse;
			}
			if(moverse)
			{
				o.retrocederMovimiento(dir);
				o.mover(dir);
			}
			else
			{
				o.retrocederMovimiento(dir);
				o.setDir(r.nextInt(4));
			}		
		}
				
	}
	
	public void meterSacarEnemigo()
	{
		try
		{		
			if (!pulsado) 
			{
				Enemigo T = new TanqueBasico(30,30,5,r.nextInt(4));
				T.setJuego(this);
				malos.addFirst(T);
				gui.add(T.getGrafico());
				pulsado=true;
				todo.addLast(malos.first().element());
				
			} 
			else
			{
				gui.remove(malos.first().element().getGrafico());
				pulsado=false;
				puntaje+=malos.first().element().getPuntaje();
				malos.first().element().destruir();
				Enemigo ene =malos.first().element();
				malos.remove(malos.first());
				for(Position<GameObject> p: todo.positions()){
					if (p.element()==ene)
						try {
							todo.remove(p);
						} catch (InvalidPositionException e) {
							System.out.println(e.getMessage());
						}
				}
				System.out.println("Puntaje: "+puntaje);				
			}		
		}
		catch(EmptyListException | InvalidPositionException  exc)
		{
			System.out.println(exc.getMessage());
		}		
	}
	
	public void eliminarObstaculo()
	{
	   try
	   {
		   if (i < obs.size())
		   {			
			   Obstaculo o = obs.first().element();
			   boolean encontre= false;
			   Position<GameObject>puntero= todo.first();
			   for(int j=0;j<todo.size()&&!encontre;j++)
			   {
				   encontre=puntero.element()==o;
				   if(!encontre)
					   puntero=todo.next(puntero);					
			   }	
			   if(encontre)
			   {
				   obs.remove(obs.first());
				   todo.remove(puntero);
				   gui.remove(puntero.element().getGrafico());
			   }			
		   }
	   }
	   catch(EmptyListException| InvalidPositionException | BoundaryViolationException e)
	   {
		   System.out.println(e.getMessage());
	   } 
	}
	
	public GUI getGui()
	{
		return gui;
	}
}
