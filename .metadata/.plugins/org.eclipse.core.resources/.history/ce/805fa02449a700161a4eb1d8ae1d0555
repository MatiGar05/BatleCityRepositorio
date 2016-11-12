package Obstaculos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class Arbol extends Obstaculo
{
	public Arbol (int gR, int x, int y)
	{
		super(gR,x,y,1);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Arbol.gif"));
	}

	public void mover(int dir)
	{	
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) {
		return v.ColisionarArbol(this);
	}
}