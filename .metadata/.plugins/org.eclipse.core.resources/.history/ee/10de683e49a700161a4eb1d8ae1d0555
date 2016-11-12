package Unidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TanqueBasico extends Enemigo
{
		
	public TanqueBasico(int x,int y,int dir)
	{
		super(1,5,0,x,y,100,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/BasicoU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/BasicoD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/BasicoL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/BasicoR.gif"));
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}	
}