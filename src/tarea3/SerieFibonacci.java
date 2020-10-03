package tarea3;
import java.util.*;

public class SerieFibonacci 
{
	public static void main(String[] args)
	{ 
		Scanner leerDatos = new Scanner(System.in);
	    int intCantidadNumeros, Cantidad= 0, variable3= 0;
	    int variable1 =1, variable2=0;
	    System.out.println("Ingrese cantidad de números a generar");
	    intCantidadNumeros = leerDatos.nextInt();
	    while (Cantidad<intCantidadNumeros) 
	    {
	        variable2 = variable3;
	        variable3 = variable1 +variable3;
	        variable1 = variable2;
	        System.out.println(variable1);   
	        Cantidad++;
	    }
	}
}
