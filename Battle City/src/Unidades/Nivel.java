package Unidades;

import javax.swing.Icon;

public abstract class Nivel {
	
	protected int GolpesResis;
	protected int VelMovimiento;
	protected int VelDisparo;
	protected int DispSim; 
	protected Icon [] ColeccionDeImagenes;
	
	public abstract int getGolpesResis();
	
	public abstract int getVelMovimiento();
	
	public abstract int getVelDisparo();
	
	public abstract int getDispSim();
	
	public abstract Icon[] getColeccionDeImagenes();
	
}
