package PowerUps;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class TanqueP extends PowerUp
{

	public TanqueP(int x, int y)
	{
		super(x, y);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/TanqueT.gif"));
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
		return v.ColisionarTanqueP(this);
	}
}
