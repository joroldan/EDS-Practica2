/************************************************************************
  Principal.java

  Clase principal de la practica 2

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/


import java.util.Scanner;
import java.util.NoSuchElementException;

public class Principal
{
	public static void main(String[] args)
	{
		int i,j;
		Scanner scan = new Scanner(System.in);
		do
		{
			System.out.println("¿Cuantos jugadores maquina habra?");
			try
			{
				i = scan.nextInt();
			}
			catch (NoSuchElementException e)
			{
				i = 1;
			}
			System.out.println("¿Cuantos jugadores humanos habra?");
			try
			{
				j = scan.nextInt();
			}
			catch (NoSuchElementException e)
			{
				j = 1;
			}
		} while ((0>i)||(0>j)||(2>j+i));
		Partida p = new Partida(i,j);
		p.crearFichas();
		p.turnoInicial();
		while(!p.hayGanador())
		{
			p.avanzarTurno();
			p.realizarJugada();
		}
		p.imprimirGanadores();
	}
}