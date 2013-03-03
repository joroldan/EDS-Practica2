/************************************************************************
  JugadorHumano.java

  Implementacion de la version humana del jugador de domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

import java.util.Scanner;

class JugadorHumano extends Jugador
{
	public JugadorHumano(String s)
	{
		super(s);
	}

	public void ponerFicha(Mesa m)
	{
		int elegida, lado;
		int donde=-1;
		System.out.println("Los extremos para colocar son: " + m.extremoIzq() + " y " + m.extremoDcha());
		System.out.println("Tienes las siguientes fichas:");
		this.mostrarFichas();
		System.out.println("Elige una de las fichas:");
		Scanner scan = new Scanner(System.in);
		do
		{
			elegida = scan.nextInt();
			donde=m.posibilidades(this.listaFichas.get(elegida));
				// -1 no se puede colocar, se vuelve a pedir ficha
				//  0 a izquierda
				//  1 a derecha
				//  2 cualquiera, se pregunta
		}
		while (((0>elegida)||(elegida>this.numFichas())||donde==-1));
		if (donde==2)
		{
			System.out.println("Elige lado para colocar: 0 a izquierda, 1 a derecha");
			do
			{
				lado = scan.nextInt();
			}
			while ((0!=lado)&&(1!=lado));
			m.colocaFicha(listaFichas.remove(elegida),lado);
		}
		else m.colocaFicha(listaFichas.remove(elegida),0);
	}
}