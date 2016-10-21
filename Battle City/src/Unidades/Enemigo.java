package Unidades;

import java.awt.Rectangle;
import javax.swing.JLabel;

import InteligenciaArtificial.*;
import Municion.*;
import PowerUps.PowerUp;
import Visitantes.ColisionadorEnemigo;
import Visitantes.Visitor;

public abstract class Enemigo extends Tanque 
{
	protected int puntajeOtorgado;
	protected int ancho, largo;
	protected Visitor colider;
	protected int VelocidadMov;
	protected int direccion;	
	
	public Enemigo(int golpes, int VM, int VD,int x,int y,int pt,int dir)
	{
		super(golpes,VD,x,y,4);
		puntajeOtorgado = pt;
		ancho = 34;
		largo = 34;
		colider = new ColisionadorEnemigo();
		VelocidadMov = VM;
		direccion = dir;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(pos.x, pos.y, ancho, largo);
	}
	
	protected void cambiarGrafico(int dir)
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
	
	public int getDir()
	{
		return direccion;
	}
	
	public void setDir(int dir)
	{
		direccion = dir;
	}
	
	public int getPuntaje()
	{
		return puntajeOtorgado;
	}	
	
	public BalaEnemigo disparar()
	{
		BalaEnemigo b = new BalaEnemigo(this.getPos().x + 12,this.getPos().y + 12, 4, this, this.getDir());
		this.setDispAct(this.getDispAct() + 1);
		b.setTanque(this);
		InteligenciaBalaEnemigo i = new InteligenciaBalaEnemigo(mij,b,this);
		b.setInteligenciaArtificialEnemigo(i);
		return b;
	}
	
	public Visitor getColider()
	{
		return colider;
	}
	
	public boolean colisionarCon(Visitor v)
	{
		return v.ColisionarTanqueEnemigo(this);
	}	
	
	public void powered(PowerUp p) 
	{		
	}	
	
	public void mover(int dir)
	{
		switch (direccion) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - VelocidadMov);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + VelocidadMov);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - VelocidadMov, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + VelocidadMov, pos.y);
				break;
		}
		cambiarGrafico(dir);
		direccion = dir;
	}
	
	public void adelantarMovimiento(int dir)
	{
		switch (dir) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - VelocidadMov);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + VelocidadMov);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - VelocidadMov, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + VelocidadMov, pos.y);
				break;				
		}
		direccion = dir;
	}	
	
	public void retrocederMovimiento(int dir)
	{	
		switch (dir) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y + VelocidadMov);					
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y - VelocidadMov);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x + VelocidadMov, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x - VelocidadMov, pos.y);
				break;
		}
		cambiarGrafico(dir);
		direccion = dir;
	}	
}
