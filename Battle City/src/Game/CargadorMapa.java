package Game;

import java.io.BufferedReader;
import General.GameObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import Obstaculos.*;
import TDALista.*;
import Unidades.*;

public class CargadorMapa
{
	private BufferedReader br;
	private final int tam = 30;
	private final int ancho = 960;
	PositionList<Obstaculo> listaObs;
	PositionList<Enemigo> listaEne;
	PositionList<GameObject> listaTodo;
	PositionList<Obstaculo> listaBorde;
	Random r;

	public CargadorMapa()
	{
		try
		{
			listaObs = new ListaDoblementeEnlazada<Obstaculo>();
			listaEne = new ListaDoblementeEnlazada<Enemigo>();
			listaTodo = new ListaDoblementeEnlazada<GameObject>();
			listaBorde = new ListaDoblementeEnlazada<Obstaculo>();
			br =  new BufferedReader(new FileReader("Mapa.txt"));
			r = new Random();
			String sCurrentLine;	
			int x=0;
			int y=0;
			while ((sCurrentLine = br.readLine()) != null)
			{
				for(int i = 0; i < sCurrentLine.length(); i++)
				{
					char letra = sCurrentLine.charAt(i);
					switch (letra) 
					{
		        		case 'l' :
		        			x+=30;
		        			Obstaculo paredLadrillo = new ParedLadrillo(false,true,4,x,y);
		        			listaObs.addLast(paredLadrillo);
		        			listaTodo.addLast(paredLadrillo);
		        			break;        		      			
		        		case 'e' :
		        			x+=30;
		        			Enemigo tanqueBasico = new TanqueBasico(x,y,5,r.nextInt(4));
		        			listaEne.addLast(tanqueBasico);
		        			listaTodo.addLast(tanqueBasico);
		        			break;
		        		case 'b' :
		        			Obstaculo arbol = new Arbol(true,false,1,x,y);
		        			listaObs.addLast(arbol);
		        			listaTodo.addLast(arbol);
		        			break;
		        		case 'm' :
		        			x+=30;
		        			Obstaculo paredAcero = new ParedAcero(false,false,1,x,y);
		        			listaObs.addLast(paredAcero);
		        			listaTodo.addLast(paredAcero);
		        			break;
		        		case 'g' :
		        			x+=30;
		        			Obstaculo aguila = new Aguila(false,false,1,x,y);
		        			listaObs.addLast(aguila);
		        			listaTodo.addLast(aguila);
		        			break;
		        		case 'a' :
		        			x+=30;
		        			Obstaculo agua = new Agua(false,false,1,x,y);
		        			listaObs.addLast(agua);
		        			listaTodo.addLast(agua);
		        			break;
		        		case 'n' :
		        			Obstaculo bloqueo = new Bloqueo(false,false,1,x,y);
		        			listaBorde.addLast(bloqueo);
		        			listaTodo.addLast(bloqueo);
		        			break;
		        		default :
		        			System.out.print("");		        			
		        			// Caracter no esperado
	        		}
					x += tam;
	    			if(x + tam > ancho)
	    			{
	    				x=0;
	    				y+=tam;
	    			} 
	        	} 
			}			
		}
		catch (IOException e) 
		{ // Esto es por si ocurre un error
            e.printStackTrace();
        } 
		finally 
		{ // Esto es para que, haya ocurrido error o no
            try 
            {
                if (br != null)
                	br.close(); // Cierre el archivo
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
	}
	
	public PositionList<GameObject> getTodo()
	{
		return listaTodo;
	}
	
	public PositionList<Obstaculo> getObs()
	{
		return listaObs;
	}
	
	public PositionList<Enemigo> getEne()
	{
		return listaEne;
	}
	
	public PositionList<Obstaculo> getBorde()
	{
		return listaBorde;
	}
}