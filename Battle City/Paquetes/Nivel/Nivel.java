package Nivel;

import javax.swing.Icon;

public abstract class Nivel 
{
	
	protected int GolpesResis;
	protected int VelMovimiento;
	protected int VelDisparo;
	protected int DispSim; 
	protected Icon [] ColeccionDeImagenes;
	protected Nivel siguiente;
	protected int nivel;
	
	
	public int getGolpesResis()
	{
		return GolpesResis;
	}
	
	public int getVelMovimiento()
	{
		return VelMovimiento;
	}
	
	public int getVelDisparo()
	{
		return VelDisparo;
	}
	
	public int getDispSim()
	{
		return DispSim;
	}
	
	public Icon[] getColeccionDeImagenes()
	{
		return ColeccionDeImagenes;
	}
	
	public Nivel getSiguiente() 
	{
		return siguiente;
	}
	
	public int getNivel()
	{
		return nivel;
	}
}
