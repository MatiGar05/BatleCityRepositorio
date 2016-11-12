package Unidades;

import Visitantes.Visitor;

public class JugadorInvulnerable extends Jugador {
	
	public JugadorInvulnerable(int golpes, int VM, int VD ,int x,int y ,int n,int v, int disp)
	{
		super(golpes,VM, VD, x, y, n, v, disp);
	}
	
	public boolean colisionarCon(Visitor v){
		return v.ColisionarJugadorInvulnerable(this);
	}	
}
