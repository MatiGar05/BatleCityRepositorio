package Municion;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import InteligenciaArtificial.InteligenciaBalaJugador;
import Unidades.Tanque;
import Visitantes.ColisionadorBalasJugador;
import Visitantes.Visitor;

public class BalaJugador extends Bala 
{
	protected InteligenciaBalaJugador ibj;
	protected Visitor colider;
	
	public BalaJugador(int x, int y, int n, Tanque t, int dir)
	{
		super(x,y,n,t,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/BalaU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/BalaD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/BalaL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/BalaR.gif"));
		ibj= new InteligenciaBalaJugador(miTanque.getJuego(),this);
		colider = new ColisionadorBalasJugador(this);
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public void mover(int dir)
	{
		
	}	
	
	public void setInteligenciaArtificialJugador(InteligenciaBalaJugador i)
	{
		ibj=i;
	}
	
	public InteligenciaBalaJugador getHiloJugador()
	{
		return ibj;
	}
	
	public void destruirBalaJugador()
	{
		miTanque.getJuego().borrarBalaJugador(this);
		this.getTanque().getJuego().getGui().repaint();
		ibj.cambiarVariable();
		vive = false;
	}
	
	public Visitor getColider()
	{
		return colider;
	}
	
	public boolean colisionarCon(Visitor v)
	{
		return v.ColisionarBalaJugador(this);
	}	
}
