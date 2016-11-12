package PowerUps;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class Estrella extends PowerUp
{

	public Estrella(int x, int y)
	{
		super(x, y);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Estrella.gif"));
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
		return v.ColisionarEstrella(this);
	}
}
