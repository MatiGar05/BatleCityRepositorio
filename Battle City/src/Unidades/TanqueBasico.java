package Unidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TanqueBasico extends Enemigo
{
		
	public TanqueBasico(int x,int y, int VM, int dir)
	{
		super(1,VM,10 ,x,y,100,dir);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/N1EnemigoU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/N1EnemigoD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/N1EnemigoL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/N1EnemigoR.gif"));
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}	
}