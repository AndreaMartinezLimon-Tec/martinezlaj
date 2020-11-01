package Tarea5;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Threads extends Thread 
{
	private JButton boton;
	private  Color customColor;
	private JProgressBar component;
	private Random porcentajeAleatorio;
	private volatile boolean haFinalizado = false;
	
	private Random getRand() 
	{
		return porcentajeAleatorio;
	}
	
	public Threads(JProgressBar component, String nombre, int R, int G, int B, JButton boton) 
	{
		this.boton = boton;
		customColor = new Color(R,G,B);
		this.component = component;
		porcentajeAleatorio = new Random();
		this.component.setName(nombre);
		this.component.setMaximum(100);
	}
	
	public synchronized boolean isCompleted() 
	{
		return haFinalizado;
	}
	
	@Override
	public void run() 
	{
		component.setStringPainted(true);
		component.setForeground(customColor);
		component.setValue(0);
		int intPorciento = 0;
		while(!haFinalizado) 
		{
			if(component.getValue() >= 100) 
			{
				haFinalizado = true;
				JOptionPane.showMessageDialog(component, component.getName() + " esta completado");
			}
			component.setValue(intPorciento); 
			intPorciento += getRand().nextInt(5);
			try 
			{
				Thread.sleep(150);
				boton.setEnabled(false);
			} catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}
		}
		boton.setEnabled(true);
	}
}
