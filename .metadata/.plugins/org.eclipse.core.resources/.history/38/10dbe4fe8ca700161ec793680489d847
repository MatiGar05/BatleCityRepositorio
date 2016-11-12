package Unidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TanqueRapido extends Enemigo
{
		
	public TanqueRapido(int x,int y,int dir)
	{
		super(1,8,1,x,y,200,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/RapidoU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/RapidoD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/RapidoL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/RapidoR.gif"));
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}	
}