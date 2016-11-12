package PowerUps;

import java.awt.Rectangle;
import javax.swing.JLabel;
import General.*;
import InteligenciaArtificial.InteligenciaPowerUp;

public abstract class PowerUp extends GameObject 
{
	
	protected int ancho, largo;
	protected InteligenciaPowerUp i;
	
	public PowerUp (int x, int y)
	{
		super(x,y,1);
		ancho = 40;
		largo = 40;
	}
	
	public Rectangle getRect() 
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
	}
	
	public void cambiarGrafico(int dir)
	{
		if(this.grafico != null)
		{
			this.grafico.setIcon(this.ColeccionDeImagenes[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
			
		}
	}
	
	public JLabel getGrafico()
	{
		if(this.grafico == null)
		{
			this.grafico = new JLabel(ColeccionDeImagenes[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
		}		
		return this.grafico;
	}
	
	public void setIA(InteligenciaPowerUp ia){i=ia;}
	
	public InteligenciaPowerUp getIA()
	{
		return i;
	}
}
