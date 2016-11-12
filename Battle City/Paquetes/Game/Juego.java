package Game;

import java.util.Iterator;
import TDALista.*;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Unidades.*;
import Obstaculos.*;
import General.GameObject;
import Municion.*;
import PowerUps.*;
import Nivel.*;
import InteligenciaArtificial.*;
import Fabricas.*;
import java.applet.AudioClip;

public class Juego 
{	
	AudioClip sonido;
	private Jugador jugador;
	private PositionList<GameObject> todo;
	private PositionList<Obstaculo> obs;
	private PositionList<Enemigo> malos;
	private PositionList<Obstaculo> borde;
	private PositionList<Bala> balasJugador;
	private PositionList<Bala> balasEnemigas;
	private PositionList<Obstaculo> base;	
	private AbstractFactoryPowerUp fabricaPower;	
	private InteligenciaEnemigo tiempo;
	private InteligenciaPala iapala;
	private InteligenciaCreadorEnemigos creadorEne;
	private ReproductorSonido reproductor;
	private int puntaje;
	private int muertes;
	private int enemigosAct;
	private GUI gui;
	private int dir = 1;
	private Random r;
	private int probabilidadDisparo = 2;
	private PositionList<PowerUp> powers;
	private JPanel panel1;
	
	public Juego(GUI gui, PositionList<Obstaculo> listaObs, PositionList<Enemigo> listaEne, PositionList<GameObject> listaTodo, PositionList<Obstaculo> listaBorde,PositionList<Obstaculo>base)
	{
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/GOT.wav"));
		sonido.play();
		fabricaPower = new FabricaPowerUp();
		this.setTodo(listaTodo);
		this.setMalos(listaEne);
		this.setObs(listaObs);
		this.setBorde(listaBorde);
		this.setBase(base);
		balasJugador = new ListaDoblementeEnlazada<Bala>();
		balasEnemigas = new ListaDoblementeEnlazada<Bala>();
		r = new Random();
		puntaje = 0;
		muertes = 0;
		enemigosAct = 0;
		this.gui = gui;
		panel1 = gui.getPanel1();
		cargarFondo();
		gui.setLabelVidas("4");
		jugador = new Jugador(1,5,0,335,575,4,4,1);
		jugador.setJuego(this);
		powers = new ListaDoblementeEnlazada<PowerUp>();	
		for(Obstaculo o : borde)
		{
			panel1.add(o.getGrafico());
		}
		for(Obstaculo o : obs)
		{		
			panel1.add(o.getGrafico());
			
		}
		for(Enemigo e : malos)
		{
			panel1.add(e.getGrafico());
			e.setJuego(this);
			enemigosAct++;
		}
		panel1.add(jugador.getGrafico());
		gui.setLabelActuales(enemigosAct+"");
		tiempo = new InteligenciaEnemigo(this);
		tiempo.start();
		creadorEne=new InteligenciaCreadorEnemigos(this);
		creadorEne.start();
		iapala = new InteligenciaPala(this);
		reproductor = new ReproductorSonido(sonido);
		reproductor.start();
	}
	
	public void mover(int dir)
	{
		if (jugador != null)
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
	}
	
	public void cargarFondo()
	{
		JLabel grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Nieve.gif")));
		grafico.setBounds(0,0, 965,685 );
		panel1.add(grafico);
		gui.actualizar();
	}
	
	public int getEnemigosAct()
	{
		return  enemigosAct;
	}
	
	public void setEnemigosAct(int e)
	{
		enemigosAct = e;
	}
	
	public int getMuertes()
	{
		return muertes;
	}
	
	public void setMuertes(int m)
	{
		muertes = m;
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
	
	public void disparoEnemigo()
	{
		for (Enemigo o : malos)
		{
			if (o.getDispAct() == 0)
			{
				if (r.nextInt(20) < probabilidadDisparo)
				{
					BalaEnemigo b = o.disparar();
					balasEnemigas.addLast(b);
					panel1.add(b.getGrafico());
					b.getHiloEnemigo().start();
					o.setDispAct(o.getDispAct() + 1);
				}
			}
		}
	}
	
	public void moverBalaJugador()
	{	
		if (jugador.getDisparos() < jugador.getDisparosSim())
		{
			BalaJugador b = jugador.disparar();
			balasJugador.addLast(b);
			panel1.add(b.getGrafico());
			b.getHiloJugador().start();
			jugador.setDisparos(jugador.getDisparos() + 1);
		}
	}
	
	public void setVulnerable()
	{
		Nivel n = jugador.getNivel();
		panel1.remove(jugador.getGrafico());
		jugador = new Jugador(jugador.getGolpesResi(),jugador.getVelocidadMovimiento(), jugador.getVelocidadDisparo(), jugador.getPos().x, jugador.getPos().y, 4, jugador.getVida(), jugador.getDisparosSim());
		jugador.setJuego(this);
		this.setJugador(jugador);
		jugador.setNivel(n);
		panel1.add(jugador.getGrafico());
	}
	
	public void insertarPowerUp()
	{
		PowerUp power = null;
		int i = r.nextInt(6);
		switch (i)
		{
			case 0 :
				power = fabricaPower.CrearPowerUp1();
				break;
			case 1 : 
				power = fabricaPower.CrearPowerUp2();
				break;
			case 2 :
				power = fabricaPower.CrearPowerUp3();
				break;
			case 3 :
				power = fabricaPower.CrearPowerUp4();
				break;
			case 4 :
				power = fabricaPower.CrearPowerUp5();
				break;
			case 5 :
				power = fabricaPower.CrearPowerUp6();
				break;
		}	
		InteligenciaPowerUp ia = new InteligenciaPowerUp(this, power);
		power.setIA(ia);
		ia.start();
		powers.addLast(power);
		todo.addLast(power);
		panel1.add(power.getGrafico());
	}
	
	public void eliminarPowerUp(PowerUp p)
	{
		try
		{
			p.getIA().cambiarVariable();
			Position<PowerUp> puntero = powers.first();
			boolean encontre = false;
			for(int j=0; j < powers.size() && !encontre; j++)
			{
				encontre= puntero.element().equals(p);
				if(!encontre)
				puntero = powers.next(puntero);					
			}	
			if(encontre)
			{
				powers.remove(puntero);
				panel1.remove(puntero.element().getGrafico());
			}
			Position<GameObject> puntero2 = todo.first();
			encontre = false;
			for(int j=0; j < todo.size() && !encontre; j++)
			{
				encontre= puntero2.element().equals(p);
				if(!encontre)
				puntero2 = todo.next(puntero2);					
			}	
			if(encontre)
			{
				todo.remove(puntero2);
			}
			p = null;
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException exc)
		{
			exc.getMessage();
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
				panel1.remove(puntero.element().getGrafico());
				jugador.setDisparos(jugador.getDisparos() - 1);
			}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException e)
		{
			e.getMessage();
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
				panel1.remove(puntero.element().getGrafico());
			}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException e)
		{
			e.getMessage();
		}
	}
	
	public void setJugador(Jugador j)
	{
		jugador = j;
		panel1.add(jugador.getGrafico());
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
			if (jugador!=null && o.getRect().intersects(jugador.getRect()))
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
	
	public GUI getGui()
	{
		return gui;
	}
	
	public void GameOver()
	{
		panel1.remove(jugador.getGrafico());
		tiempo.cambiarVariable();
		tiempo=null;
		JLabel grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Game Over.gif")));
		grafico.setBounds(300, 200, 440, 200);
		panel1.add(grafico);
		for (GameObject g : todo)
		{
			panel1.remove(g.getGrafico());
			panel1.add(g.getGrafico());
		}	
		for (Enemigo o : malos)
		{
			panel1.remove(o.getGrafico());
			o = null;
		}
		for (PowerUp p : powers)
		{
			panel1.remove(p.getGrafico());
			p = null;
		}
		creadorEne.interrumpir();
		creadorEne = null;
		gui.eliminarKeyListener();	
		gui.actualizar();		
	}
	
	public void ganar()
	{
		panel1.remove(jugador.getGrafico());
		tiempo.cambiarVariable();
		tiempo=null;
		JLabel grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Win.gif")));
		grafico.setBounds(300,200, 440, 200);
		panel1.add(grafico);
		for (GameObject g : todo)
		{
			panel1.remove(g.getGrafico());
			panel1.add(g.getGrafico());
		}	
		for (Enemigo o : malos)
		{
			panel1.remove(o.getGrafico());
			o = null;
		}
		for (PowerUp p : powers)
		{
			panel1.remove(p.getGrafico());
			p = null;
		}
		creadorEne.interrumpir();
		creadorEne = null;
		gui.eliminarKeyListener();	
		gui.actualizar();		
	}
	

	public void setBase(PositionList<Obstaculo>b)
	{
		base=b;
	}
	
	public PositionList<Obstaculo> getBase() 
	{
		return base;
	}
	
	public void agregarMalos(Enemigo e)
	{
		malos.addLast(e);
		todo.addLast(e);
		e.setJuego(this);
		panel1.add(e.getGrafico());
		enemigosAct++;
		gui.setLabelActuales(enemigosAct+"");
	}
	
	public InteligenciaCreadorEnemigos getCreadorEnemigo() {
		return creadorEne;
	}
	
	public InteligenciaEnemigo getIAEnemigo()
	{
		return tiempo;
	}
	
	public void baseNormal()
	{
		PositionList<Obstaculo> listaAux = new ListaDoblementeEnlazada<Obstaculo>();
		try
		{
			for (Position<Obstaculo> o : base.positions()) 
			{
				panel1.remove(o.element().getGrafico());
				for (Position<GameObject> g : todo.positions()) 
				{
					if (g.element() == o.element()) 
					{					
						todo.remove(g);
					} 
				}
				for (Position<Obstaculo> g : obs.positions()) {
					if (g.element() == o.element()) 
					{					
						obs.remove(g);					
					} 
				}
				Obstaculo aux = new ParedLadrillo(4,o.element().getPos().x,o.element().getPos().y);
				base.remove(o);
				todo.addLast(aux);
				obs.addLast(aux);
				panel1.add(aux.getGrafico());
				listaAux.addLast(aux);
			}
			for (Obstaculo x : listaAux)
			{
				base.addLast(x);
			}
			iapala = new InteligenciaPala(this);
			gui.actualizar();
		}
		catch(InvalidPositionException exc)
		{
			exc.getMessage();
		}
	}	
	
	public InteligenciaPala getInteligenciaPala() 
	{
		return iapala;
	}
}
