/************************************************************************
  Mesa.java

  Implementacion de la mesa para jugar al domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

import java.util.ArrayList;

public class Mesa
{
	private Pila <Ficha> montonRobar;
	private DobleCola <Ficha> montonColocadas;
	
	public Mesa()
	{
		montonColocadas = new DobleCola<Ficha>();
		montonRobar = new Pila<Ficha>();
	}

	public void addMonRobar(Ficha f)
	{
		this.montonRobar.apilar(f);
	}
	
	public void colocaFicha(Ficha f, int lado)
	{
		System.out.println("Procedemos a colocar " + f + " en el lado " + lado);
		if (!vacioMonColocadas())
		{
			if (lado==0)
			{
				int a = this.extremoIzq();
				if (f.estaNumero(a))
				{
					if (f.getDcha()==a) this.montonColocadas.addPrincipio(f);
					else
					{
						f.girar();
						this.montonColocadas.addPrincipio(f);
					}
				}
				else
				{
					throw new JugadaInvalida("No se ha podido colocar la ficha en la mesa.");
				}
			}
			else if (lado==1)
			{
				int a = this.extremoDcha();
				if (f.estaNumero(a))
				{
					if (f.getIzq()==a) this.montonColocadas.addFinal(f);
					else
					{
						f.girar();
						this.montonColocadas.addFinal(f);
					}
				}
				else
				{
					throw new JugadaInvalida("No se ha podido colocar la ficha en la mesa.");
				}
				
			}
			else throw new JugadaInvalida("No existe ese lado para colocar ficha.");
		}
		else this.montonColocadas.addPrincipio(f);
	}

	public boolean vacioMonRobar()
	{
		return this.montonRobar.pilaVacia();
	}
	
	public boolean vacioMonColocadas()
	{
		return this.montonColocadas.vacia();
	}

	public Ficha robar()
	{
		return this.montonRobar.desapilar();
	}
	
	public int posibilidades(Ficha f)
	{ 
		//devuelve -1 si no se puede colocar en nigun extremo
		//0 a la izquierda, 1 a la derecha, 2 en cualquier lado
		if (vacioMonColocadas()) return 0;
		int i=-1;
		if (f.estaNumero(extremoIzq()))  i=0;
		if (f.estaNumero(extremoDcha()))
		{
			if (i==0) i=2;
			else i=1;
		}
		return i;
	}
	
	public int extremoIzq()
	{
		if (!vacioMonColocadas()) return this.montonColocadas.primero().getIzq();
		else return -1;
	}

	public int extremoDcha()
	{
		if (!vacioMonColocadas()) return this.montonColocadas.ultimo().getDcha();
		else return -1;
	}
	
	public void mostrarFichasColocadas()
	{
		this.montonColocadas.mostrar();
	}
}
