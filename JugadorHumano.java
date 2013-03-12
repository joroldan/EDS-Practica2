/************************************************************************
  JugadorHumano.java

  Implementacion de la version humana del jugador de domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

import java.util.Scanner;
import java.util.NoSuchElementException;

class JugadorHumano extends Jugador
{
	public JugadorHumano(String s)
	{
		super(s);
	}

	public Ficha getFicha(Mesa m)
	{
		int elegida, lado;
		int donde=-1;
		System.out.println("Los extremos para colocar son: " + m.extremoIzq() + " y " + m.extremoDcha());
		System.out.println("Tienes las siguientes fichas:");
		this.mostrarFichas();
		Scanner scan = new Scanner(System.in);
		do
		{
			System.out.println("\n\nElige una de las fichas:");
			try
			{
				elegida = scan.nextInt();
			}
			catch (NoSuchElementException e)
			{
				elegida = 1;
			}
			if ((0<=elegida)&&(elegida<this.numFichas()))
				{
					// -1 no se puede colocar, se vuelve a pedir ficha
					//  0 a izquierda
					//  1 a derecha
					//  2 cualquiera, se pregunta
					donde=m.posibilidades(this.listaFichas.get(elegida));
				}
				else donde=-1;
		}
		while (donde==-1);
		return this.listaFichas.remove(elegida);
	}

	public int ladoFicha(Mesa m, Ficha f)
	{
		Scanner scan = new Scanner(System.in);
		int donde= m.posibilidades(f);
		if (donde==2)
		{
			do
			{	
				System.out.println("Elige lado para colocar: 0 a izquierda, 1 a derecha");
				try
				{
					donde = scan.nextInt();
				}
				catch (NoSuchElementException e)
				{
					donde = 1;
				}
			}
			while ((0!=donde)&&(1!=donde));
		}
		return donde;
	}
}