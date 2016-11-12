package Nivel;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class NivelTres extends Nivel 
{
	
	public NivelTres()
	{
		GolpesResis=1;
		nivel = 3;
		VelMovimiento=0;
		VelDisparo=1;
		DispSim=1; 
		siguiente = new NivelCuatro();
		ColeccionDeImagenes=new Icon[4];
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/3JugadorU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/3JugadorD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/3JugadorL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/3JugadorR.gif"));
	}
}
