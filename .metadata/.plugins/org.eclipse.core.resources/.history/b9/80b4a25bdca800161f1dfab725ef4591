package Obstaculos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class ParedAcero extends Obstaculo
{
	public ParedAcero (int gR, int x, int y)
	{
		super(gR,x,y,4);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/ParedAcero.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/ParedAcero1.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/ParedAcero2.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/ParedAcero3.gif"));
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
		return v.ColisionarParedAcero(this);
	}
}