package Obstaculos;

import java.awt.Rectangle;

import javax.swing.JLabel;

import General.GameObject;

public abstract class Obstaculo extends GameObject 
{
	protected boolean Atravesable;
	protected boolean Destruible;
	protected int golpesResis;
	protected int ancho, largo;
	
	public Obstaculo(boolean A, boolean D, int gR, int x, int y, int n)
	{
		super(x, y, n);
		Atravesable = A;
		Destruible = D;
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
		
	public boolean esAtravesable()
	{
		return Atravesable;
	}
	
	public boolean esDestruible()
	{
		return Destruible;
	}
	
	public int getGolpeResis()
	{
		return golpesResis;
	}
	
	public void setAtravesable(boolean a)
	{
		Atravesable = a;
	}
	
	public void setDestruible(boolean d)
	{
		Destruible = d;
	}
	
	public void setGolpesResis(int g)
	{
		golpesResis = g;
	}
	
	public void recibirGolpe()
	{
		golpesResis--;
	}
	
	public abstract int profundidad();
}