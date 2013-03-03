/************************************************************************
  Ficha.java

  Implementacion de la fichas de domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

public class Ficha
{
	private int parteIzq;
	private int parteDcha;
	
	public Ficha(int a, int b)
	{
		this.parteIzq  = a;
		this.parteDcha = b;
	}

	public void girar()
	{
		int aux = this.parteIzq;
		this.parteIzq  = this.parteDcha;
		this.parteDcha = aux;
	}
	
	public int sumaValores()
	{
		return (this.parteIzq + this.parteDcha);
	}
	
	public boolean estaNumero(int num)
	{
		return ((num==this.parteIzq) || (num==this.parteDcha));
	}
	
	public boolean esDoble(int num)
	{
		return ((num==this.parteDcha)&&(this.parteIzq==num));
	}

	public boolean esFichaDoble()
	{
		return (this.parteIzq==this.parteDcha);
	}
	
	public int getIzq()
	{
		return this.parteIzq;
	}
	
	public int getDcha()
	{
		return this.parteDcha;
	}

	public String toString()
	{
		return ("[" + this.parteIzq + "|" + this.parteDcha + "]");
	}
}
