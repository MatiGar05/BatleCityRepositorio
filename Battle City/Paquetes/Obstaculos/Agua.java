package Obstaculos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class Agua extends Obstaculo
{
	public Agua (int gR, int x, int y)
	{
		super(gR,x,y,1);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Agua.gif"));
	}
	
	public void mover(int dir)
	{	
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) 
	{
		return v.ColisionarAgua(this);
	}
}