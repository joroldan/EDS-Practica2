/************************************************************************
  Jugador.java

  Implementacion de la clase abstrata Jugador (domino)

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/


import java.util.ArrayList;

public abstract class Jugador
{
	private String nombre;
	ArrayList<Ficha> listaFichas;

	public Jugador(String s)
	{
		this.nombre = s;
		this.listaFichas = new ArrayList<Ficha>();
	}

	public void recibirFicha(Ficha f)
	{
		//System.out.println("Recibiendo la ficha " + f);
		boolean noAdd = true;
		int i = 0, lenght = this.numFichas();
		while ((i<lenght)&&(noAdd))
		{
			if (this.listaFichas.get(i).sumaValores()<f.sumaValores())
			{
				this.listaFichas.add(i,f);
				noAdd=false;
			}
			else i++;
		}
		if (noAdd) this.listaFichas.add(f);
		//System.out.println("Ahora las fichas que tenemos son: ");
		//mostrarFichas();
	}

	public abstract void ponerFicha(Mesa m);

	public void mostrarFichas()
	{
		System.out.println("");
		for (Ficha f: listaFichas)
			System.out.print(f + " ");
	}

	public int numFichas()
	{
		return this.listaFichas.size();
	}

	public boolean puedeColocar(Mesa m)
	{
		boolean puede = false;
		int i = m.extremoIzq();
		int d = m.extremoDcha();
		int c = 0;
		while ((!puede)&&(c<this.numFichas()))
		{
			puede = (listaFichas.get(c).estaNumero(i)||listaFichas.get(c).estaNumero(d));
			c++;
		}
		//System.out.println("Puede colocar? " + puede);
		return puede;
	}
	/*
	public void ponerFichaMayor(Mesa m)
	{
		System.out.println("La ficha mayor es " + listaFichas.get(0));
		m.colocaFicha(listaFichas.remove(0),0);
	}
	*/
	public int maxDoble()
	{
		int i=6, j=0;
		while (i>=0)
		{
			j=0;
			while (j<numFichas())
			{
				if (listaFichas.get(j).esDoble(i)) return i;
				if (listaFichas.get(j).sumaValores()<2*i) break;
				j++;
			}
			i--;
		}
		return -1;
	}

	public void ponerDobleMayor(Mesa m)
	{
		int max = maxDoble();
		//System.out.println("La doble mayor es " + max);
		for (int j=0; j<numFichas(); j++)
		{
			if (listaFichas.get(j).esDoble(max)) m.colocaFicha(listaFichas.remove(j),0);
		}
	}
}