/************************************************************************
  JugadorMaquina.java

  Implementacion de la version maquina del jugador de domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

class JugadorMaquina extends Jugador
{
	public JugadorMaquina(String s)
	{
		super(s);
	}

	public Ficha getFicha(Mesa m)
	{
		int i=0;
		boolean fin=false;
		while ((i<this.numFichas())&&(!fin))
		{
			if (m.posibilidades(this.listaFichas.get(i))!=-1) fin=true;
			else i++;
		}
		return this.listaFichas.remove(i);
	}

	public int ladoFicha(Mesa m, Ficha f)
	{
		System.out.println("La ficha " + f + " se puede colocar en: " + m.posibilidades(f));
		if (m.posibilidades(f)==1) return 1; //Si solo se puede colocar en la derecha va ahi
		else return 0; //Si se puede colocar a amabos lados, se coloca a izquier
	}
}