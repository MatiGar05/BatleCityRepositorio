package Obstaculos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class Aguila extends Obstaculo
{
	
	public Aguila (boolean A, boolean D, int gR, int x, int y)
	{
		super(A,D,gR,x,y,1);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Aguila.gif"));
	 }

	public void mover(int dir)
	{	
	}
		
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) {
		return v.ColisionarAguila(this);

	}
	
	public int profundidad(){return 1;}
}