package Fabricas;

import java.awt.Point;
import java.util.Random;
import Unidades.*;


public class FabricaEnemigoNivelUno implements AbstractFactoryEnemigo
{

	private Point [] posibilidades;
	private Random r;
	
	public FabricaEnemigoNivelUno()
	{
		posibilidades = new Point[2];
		posibilidades[0]= new Point(160,100);
		posibilidades[1]= new Point(640,100);
		r = new Random();
	}
	
	public Enemigo CrearEnemigo1(){
		int i= r.nextInt(2);
		Point p = posibilidades[i];
		return new TanqueBasico(p.x,p.y,r.nextInt(4));
	}
	
	public Enemigo CrearEnemigo2(){
		int i= r.nextInt(2);
		Point p = posibilidades[i];
		return new TanqueRapido(p.x,p.y,r.nextInt(4));
	}
	
	public Enemigo CrearEnemigo3(){
		int i= r.nextInt(2);
		Point p = posibilidades[i];
		return new TanqueDePoder(p.x,p.y,r.nextInt(4));
	}
	
	public Enemigo CrearEnemigo4(){
		int i= r.nextInt(2);
		Point p = posibilidades[i];
		return new TanqueBlindado(p.x,p.y,r.nextInt(4));
	}
}
