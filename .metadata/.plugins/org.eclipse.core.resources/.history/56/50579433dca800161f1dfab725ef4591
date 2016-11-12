package InteligenciaArtificial;

public class InteligenciaExplo extends Thread 
{
	
	private boolean condicion;
	
	public InteligenciaExplo() 
	{
		condicion = true;
	}
	
	public void run()
	{
		while(condicion)
		{
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			condicion = false;
		}
	}
	
	public void interrumpir()
	{
		condicion = false;
	}
}