package Unidades;

import java.awt.Rectangle;

import javax.swing.Icon;
import InteligenciaArtificial.InteligenciaBalaJugador;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PowerUps.PowerUp;
import Visitantes.ColisionadorJugador;
import Visitantes.Visitor;
import Municion.*;

public class Jugador extends Tanque 
{

	protected int Vida;
	protected int DispSim;
	protected Nivel estado ;
	protected Visitor colider;
	protected int VelocidadMov;
	protected int ancho, largo;
	
	public Jugador(int golpes, int VM, int VD ,int x,int y ,int n,int v, int disp)
	{
		super(golpes, VD, x, y, n);
		Vida=v;
		DispSim = disp;
		VelocidadMov = VM;
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/NJugadorU.gif"));
		ColeccionDeImagenes[1]=  new ImageIcon(this.getClass().getResource("/Recursos/NJugadorD.gif"));
		ColeccionDeImagenes[2]=  new ImageIcon(this.getClass().getResource("/Recursos/NJugadorL.gif"));
		ColeccionDeImagenes[3]=  new ImageIcon(this.getClass().getResource("/Recursos/NJugadorR.gif"));
		colider=new ColisionadorJugador(); 
		ancho = 34;
		largo = 34;
		estado= new NivelUno();
	}
	
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public int getVida()
	{
		return Vida;
	}
	
	public void setVida(int v)
	{
		Vida=v;
	}
	
	public int getDispSim()
	{
		return estado.getDispSim();
	}
	
//	public void setDispSim(int d)
//	{
//		DispSim=d;
//	}
	
	public void destruir()
	{
		
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
	}
	
	public BalaJugador disparar()
	{
		BalaJugador b = new BalaJugador(this.getPos().x + 12,this.getPos().y + 12,4,this,this.getDireccion());
		b.setTanque(this);
		InteligenciaBalaJugador i= new InteligenciaBalaJugador(mij,b);
		b.setInteligenciaArtificialJugador(i);
		return b;
		
	}
	
	public void powered(PowerUp p) 
	{		
	}	
	
	public void setNivel(Nivel n)
	{
		estado=n;
	}
	
	public int getVelocidadMovimiento()
	{
		return estado.getVelMovimiento();
	}
	
	public int getVelocidadDisparo()
	{
		return estado.getVelDisparo();
	}
	
	public int getDisparosSim()
	{
		return estado.getDispSim();
	}
	
	public int getGolpesResi()
	{
		return estado.getGolpesResis();
	}
	
	public Visitor getColider()
	{
		return colider;
	}	

	public boolean colisionarCon(Visitor v){
		return v.ColisionarTanqueJugador(this);
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
	
	public void setVelocidadMov(int g)
	{
		VelocidadMov=g;
	}
	
	public void mover(int dir)
	{	
		direccion = dir;
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
