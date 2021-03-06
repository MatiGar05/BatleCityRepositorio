package Unidades;

import java.awt.Rectangle;

import javax.swing.Icon;
import InteligenciaArtificial.InteligenciaBalaJugador;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import PowerUps.PowerUp;
import Visitantes.ColisionadorJugador;
import Visitantes.Visitor;
import Municion.*;
import Nivel.*;
import java.applet.AudioClip;

public class Jugador extends Tanque 
{
	protected int Vida;
	protected int DispSim;
	protected Nivel estado;
	protected Visitor colider;
	protected int VelocidadMov;
	protected int ancho, largo;
	protected int disparos;
	protected int nivel;
	
	public Jugador(int golpes, int VM, int VD ,int x,int y ,int n,int v, int disp)
	{
		super(golpes, VD, x, y, n);
		Vida=v;
		DispSim = disp;
		VelocidadMov = VM;
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/1JugadorU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/1JugadorD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/1JugadorL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/1JugadorR.gif"));
		colider=new ColisionadorJugador(this); 
		ancho = 30;
		largo = 50;
		estado = new NivelUno();
		nivel = 0;
		disparos = 0;
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public int getNumNivel()
	{
		return nivel;
	}
	
	public void setNumNivel(int n)
	{
		nivel = n;
	}
	
	public int getVida()
	{
		return Vida;
	}
	
	public void setVida(int v)
	{
		Vida=v;
	}
	
	public void destruir()
	{
		
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
	}
	
	public BalaJugador disparar()
	{
		sonido.play();
		BalaJugador b = new BalaJugador(this.getPos().x + 8,this.getPos().y +20,4,this,this.getDireccion());
		b.setTanque(this);
		InteligenciaBalaJugador i= new InteligenciaBalaJugador(mij,b);
		b.setInteligenciaArtificialJugador(i);
		return b;
		
	}
	
	public void powered(PowerUp p) 
	{		
	}	
	
	public void setNivel(Nivel n)
	{
		estado = n;
		nivel = estado.getNivel();
		DispSim += estado.getDispSim();
		VelocidadMov += estado.getVelMovimiento();
		VelocidadDis += estado.getVelDisparo();
		GolpesResis += estado.getGolpesResis();
		int i = 0;
		for (Icon icono : estado.getColeccionDeImagenes()) 
		{
			this.setImagen(icono,i);
			i++;
		}
	}
	
	public int getVelocidadMovimiento()
	{
		return VelocidadMov;
	}
	
	public int getVelocidadDisparo()
	{
		return VelocidadDis;
	}
	
	public int getDisparosSim()
	{
		return DispSim;
	}
	
	public int getGolpesResi()
	{
		return GolpesResis;
	}
	
	public Visitor getColider()
	{
		return colider;
	}	
	
	public Nivel getNivel()
	{
		return estado;
	}
	
	public int getDisparos()
	{
		return disparos;
	}
	
	public void setDisparos(int i)
	{
		disparos = i;
	}

	public boolean colisionarCon(Visitor v){
		return v.ColisionarTanqueJugador(this);
	}
	
	public void cambiarGrafico(int dir)
	{
		if(this.grafico != null)
		{
			this.grafico.setIcon(this.ColeccionDeImagenes[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
		}
	}
	
	public JLabel getGrafico()
	{
		if(this.grafico == null)
		{
			this.grafico = new JLabel(ColeccionDeImagenes[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
		}		
		return this.grafico;
	}
	
	public void mover(int dir)
	{	
		direccion = dir;
		switch (dir) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - this.getVelocidadMovimiento());								
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + this.getVelocidadMovimiento());
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - this.getVelocidadMovimiento(), pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + this.getVelocidadMovimiento(), pos.y);
				break;
		}
		cambiarGrafico(dir);
		direccion = dir;
	}
	
	public void adelantarMovimiento(int dir)
	{	
		switch (dir) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - this.getVelocidadMovimiento());				
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + this.getVelocidadMovimiento());
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - this.getVelocidadMovimiento(), pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + this.getVelocidadMovimiento(), pos.y);
				break;
		}
	}	
	
	public void retrocederMovimiento(int dir)
	{	
		switch (dir) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y + this.getVelocidadMovimiento());			
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y - this.getVelocidadMovimiento());
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x + this.getVelocidadMovimiento(), pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x - this.getVelocidadMovimiento(), pos.y);
				break;
		}
		cambiarGrafico(dir);
		direccion = dir;
	}
	
	public void renacer()
	{
		estado = new NivelUno();
		nivel = estado.getNivel();
		DispSim += estado.getDispSim();
		VelocidadMov += estado.getVelMovimiento();
		VelocidadDis += estado.getVelDisparo();
		GolpesResis += estado.getGolpesResis();
		int i = 0;
		for (Icon icono : estado.getColeccionDeImagenes()) 
		{
			this.setImagen(icono,i);
			i++;
		}
	}
	
	public void subirNivel() {
		if( estado.getSiguiente()!=null)
		{
			estado=estado.getSiguiente();
			nivel = estado.getNivel();
			DispSim += estado.getDispSim();
			VelocidadMov += estado.getVelMovimiento();
			VelocidadDis += estado.getVelDisparo();
			GolpesResis += estado.getGolpesResis();
			int i = 0;
			for (Icon icono : estado.getColeccionDeImagenes()) {
				this.setImagen(icono,i);
				i++;
			}
			
		}		
	}
}
