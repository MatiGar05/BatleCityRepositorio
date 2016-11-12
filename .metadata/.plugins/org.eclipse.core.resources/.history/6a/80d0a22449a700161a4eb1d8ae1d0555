package Obstaculos;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitantes.Visitor;

public class Bloqueo extends Obstaculo
{
	protected int ancho, largo;
	
	public Bloqueo (int gR, int x, int y)
	{
		super(gR,x,y,1);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Bloqueo.gif"));
		ancho = 30;
		largo = 30;
	}

	public void mover(int dir)
	{	
	}
	
	public Rectangle getRect() 
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
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
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) 
	{
		return v.ColisionarBloqueo(this);
	}
}