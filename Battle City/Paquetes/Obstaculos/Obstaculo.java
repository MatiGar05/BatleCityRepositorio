package Obstaculos;

import java.awt.Rectangle;

import javax.swing.JLabel;

import General.GameObject;

public abstract class Obstaculo extends GameObject 
{
	protected int golpesResis;
	protected int ancho, largo;
	
	public Obstaculo(int gR, int x, int y, int n)
	{
		super(x, y, n);
		golpesResis = gR;
		ancho = 60;
		largo = 60;
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
	
	public int getGolpeResis()
	{
		return golpesResis;
	}
	
	public void setGolpesResis(int g)
	{
		golpesResis = g;
	}
	
	public void recibirGolpe()
	{
		golpesResis--;
	}
}