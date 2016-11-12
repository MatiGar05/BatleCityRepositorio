package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{

	GUI gui;
	
	public KeyInput(GUI gui)
	{
		this.gui = gui;
	}
	
	public void keyPressed(KeyEvent e)
	{
		gui.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e)
	{
		gui.keyReleased(e);
	}
}