package Municion;

import java.awt.Rectangle;
import javax.swing.JLabel;
//import InteligenciaArtificial.*;
import General.*;
import Unidades.*;
//import Visitantes.*;

public abstract class Bala extends GameObject 
{
	protected int ancho,largo;
	protected Tanque miTanque;
	protected int direccion;
	//protected InteligenciaBalaJugador ibj;
	//protected InteligenciaBalaEnemigo ibe;
	protected boolean vive;
	//protected Visitor colider;
	
	public Bala(int x, int y, int n,Tanque t, int dir)
	{
		super(x,y,n);
		miTanque = t;
		direccion = dir;
		vive = true;
		//ibj= new InteligenciaBalaJugador(miTanque.getJuego(),this);
		//ibe= new InteligenciaBalaEnemigo(miTanque.getJuego(),this);
		ancho=12;
		largo=12;
		//colider = new ColisionadorBalasJugador(this);
	}
	
	protected void cambiarGrafico(int dir)
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
	
	public Rectangle getRect()
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
	}
	
	public boolean vive()
	{
		return vive;
	}
	
	public void mover()
	{	
		switch (direccion) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - miTanque.getVelocidadDis());
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + miTanque.getVelocidadDis());
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - miTanque.getVelocidadDis(), pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + miTanque.getVelocidadDis(), pos.y);
				break;
		}
		cambiarGrafico(direccion);
	}	
	
//	public void setInteligenciaArtificialJugador(InteligenciaBalaJugador i)
//	{
//		ibj=i;
//	}
	
//	public void setInteligenciaArtificialEnemigo(InteligenciaBalaEnemigo i)
//	{
//		ibe=i;
//	}
	
	public Tanque getTanque()
	{
		return miTanque;
	}
	
//	public InteligenciaBalaJugador getHiloJugador()
//	{
//		return ibj;
//	}
	
//	public InteligenciaBalaEnemigo getHiloEnemigo()
//	{
//		return ibe;
//	}
	
	public void setTanque (Tanque v)
	{
		miTanque=v;
	}
	
//	public Visitor getColider()
//	{
//		return colider;
//	}
	
//	public void destruirBalaJugador()
//	{
//		miTanque.getJuego().borrarBalaJugador(this);
//		this.getTanque().getJuego().getGui().repaint();
//		ibj.cambiarVariable();
//		vive = false;
//	}
	
//	public void destruirBalaEnemigo()
//	{
//		miTanque.getJuego().borrarBalaEnemigo(this);
//		miTanque.setDispAct(miTanque.getDispAct() - 1);
//		this.getTanque().getJuego().getGui().repaint();
//		ibe.cambiarVariable();
//		vive = false;
//	}
}
