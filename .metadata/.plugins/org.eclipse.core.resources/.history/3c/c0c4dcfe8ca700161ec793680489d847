package Unidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TanqueBlindado extends Enemigo
{
		
	public TanqueBlindado(int x,int y,int dir)
	{
		super(4,5,1,x,y,400,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/BlindadoU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/BlindadoD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/BlindadoL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/BlindadoR.gif"));
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}	
}