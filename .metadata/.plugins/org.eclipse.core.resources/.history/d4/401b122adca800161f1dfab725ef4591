package General;

import java.awt.Point;
import Visitantes.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Rectangle;

public abstract class GameObject 
{
	protected Point pos;
	protected Icon [] ColeccionDeImagenes;
	protected JLabel grafico;
	
	protected GameObject(int x, int y, int n) 
	{
		this.pos = new Point(x, y);
		this.ColeccionDeImagenes = new Icon[n];
	}

	public Point getPos() 
	{
		return pos;
	}
	
	public void cambiarX (int x)
	{
		pos.x = x;
	}
	
	public void cambiarY (int y)
	{
		pos.y = y;
	}
	
	protected abstract void cambiarGrafico(int dir);	
	
	public abstract void mover(int dir);		
		
	public abstract JLabel getGrafico();	
	
	public abstract void setImagen(Icon i , int pos);
	
	public abstract Rectangle getRect();
	
	public abstract boolean colisionarCon(Visitor v);	
}