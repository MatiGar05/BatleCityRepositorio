package Obstaculos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class ParedAcero extends Obstaculo
{
	public ParedAcero (boolean A, boolean D, int gR, int x, int y)
	{
		super(A,D,gR,x,y,1);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/ParedAcero.gif"));
	}

	public void mover(int dir)
	{
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) {
		return v.ColisionarParedAcero(this);
	}
	
	public int profundidad(){return 1;}
}