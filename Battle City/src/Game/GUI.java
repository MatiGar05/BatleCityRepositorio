package Game;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import General.GameObject;
import java.awt.event.KeyEvent;
import InteligenciaArtificial.*;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Unidades.Enemigo;

public class GUI extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;	
	private Juego j;
	private InteligenciaEnemigo tiempo;
	private CargadorMapa cm;
	PositionList<Obstaculo> listaObs;
	PositionList<Enemigo> listaEne;
	PositionList<GameObject> listaTodo;
	PositionList<Obstaculo> listaBorde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI frame = new GUI();
					frame.setVisible(true);
					frame.setTitle("Battle City");
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() 
	{
		addKeyListener(new KeyInput(this));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,25, 965, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		cm = new CargadorMapa();
		listaObs = cm.getObs();
		listaEne = cm.getEne();
		listaTodo = cm.getTodo();
		listaBorde = cm.getBorde();
		j = new Juego(this, listaObs, listaEne, listaTodo, listaBorde);
		tiempo = new InteligenciaEnemigo(j);
		tiempo.start();
		this.setResizable(false);
	}
	
	public synchronized void actualizar()
	{
		this.repaint();
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			j.mover(0);
			this.actualizar();
		}
		else
			if (key == KeyEvent.VK_DOWN)
			{
				j.mover(1);
				this.actualizar();
			}
			else
				if (key == KeyEvent.VK_LEFT)
				{
					j.mover(2);
					this.actualizar();
				}
				else
					if (key == KeyEvent.VK_RIGHT)
					{
						j.mover(3);
						this.actualizar();
					}
					else
						if (key == KeyEvent.VK_E)
						{
							j.meterSacarEnemigo();
							this.actualizar();
						}
						else
							if (key == KeyEvent.VK_P)
							{
								j.eliminarObstaculo();
								this.actualizar();
							}
				
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE)
		{
			j.moverBalaJugador();
			this.actualizar();
		}
		else
			if (key == KeyEvent.VK_UP)
			{
				j.mover(0);
				this.actualizar();
			}
			else
				if (key == KeyEvent.VK_DOWN)
				{
					j.mover(1);
					this.actualizar();
				}
				else
					if (key == KeyEvent.VK_LEFT)
					{
						j.mover(2);
						this.actualizar();
					}
					else
						if (key == KeyEvent.VK_RIGHT)
						{
							j.mover(3);
							this.actualizar();
						}
	}
}