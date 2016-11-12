package Unidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TanqueDePoder extends Enemigo
{
		
	public TanqueDePoder(int x,int y,int dir)
	{
		super(1,6,3,x,y,300,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/PoderU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/PoderD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/PoderL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/PoderR.gif"));
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}	
}