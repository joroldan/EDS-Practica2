/************************************************************************
  Partida.java

  Implementacion de partida (domino)

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

import java.util.Random;

class Partida
{
	private Mesa m;
	private Jugador [] jug;
	private int turno;
	private int numJugadores;
	private int pasando;

	public Partida(int numMaquina, int numHumano)
	{
		this.m = new Mesa();
		this.numJugadores = numMaquina+numHumano;
		this.pasando=0;
		this.jug = new Jugador[numJugadores];
		for (int i=0;i<numMaquina; i++)
		{
			this.jug[i] = new JugadorMaquina("");
		}
		for (int i=numMaquina; i<numJugadores; i++)
		{
			this.jug[i] = new JugadorHumano("");
		}
	}

	public void crearFichas()
	{
		Ficha [] f = new Ficha[28];
		int k=0;
		for (int i=0; i<7; i++)
		{
			for(int j=i; j<7; j++)
			{
				f[k++]=new Ficha(i,j);
			}
		}
 		//ahora se barajan

		Random generador = new Random();
		int n1,n2;
		Ficha aux;
		for (int i=0; i<10000; i++)
		{
			n1 = generador.nextInt(28);
			n2 = generador.nextInt(28);
			aux = f[n1];
			f[n1] = f[n2];
			f[n2] = aux;
		}

		//A continuacion se reparten las fichas
		int i;
		for (i=0; (i<numJugadores*7)&&(i<28); i++)
		{
			jug[i%numJugadores].recibirFicha(f[i]);
		}
		while(i<28) 
		{
			m.addMonRobar(f[i]);
			i++;
		}
	}


	public void realizarJugada()
	{
		System.out.println("\n\n\nComienza otra jugada");
		if(this.jug[turno].puedeColocar(m))
		{
			System.out.println("Coloco ficha");
			this.jug[turno].ponerFicha(m);
			pasando=0;
		}
		else if (!m.vacioMonRobar())
		{
			System.out.println("Robo");
			this.jug[turno].recibirFicha(m.robar());
		}
		else
		{
			System.out.println("Paso");
			pasando++;
		}
	}

	public Jugador buscarGanador()
	{
		//System.out.println("El jugador " + turno + " le quedan " + this.jug[turno].numFichas() + " fichas.");
		/*if((this.jug[turno].numFichas()==0)||(pasando==numJugadores))
		{
			return turno;
		}*/
		if (this.jug[turno].numFichas()==0)
		{
			return this.jug[turno];
		}
		else if (pasando==numJugadores)
		{
			throw new JugadaInvalida("Nadie mas puede colocar fichas.");
		}
		return null;
	}

	public void avanzarTurno()
	{
		m.mostrarFichasColocadas();
		this.turno = (this.turno+1)%numJugadores;
		//System.out.println("El turno pasa a : " + turno);
	}

	public void turnoInicial()
	{
		int maxD = -1, maxJ = 0, doble;
		for(int i=0; i<numJugadores; i++)
		{
			doble = this.jug[i].maxDoble();
			if (doble>maxD)
			{
				maxJ = i;
				maxD = doble;
			}
		}
		//Ya tenemos quien tiene la mayor doble, luego asignamos:
		turno = maxJ;
		System.out.println("Es el turno de: " + turno);
		this.jug[turno].ponerDobleMayor(m);
		
		//Metodo viejo
		/*
		Random generador = new Random();
		turno= generador.nextInt(numJugadores);
		System.out.println("Es el turno de: " + turno);
		this.jug[turno].ponerFichaMayor(m);
		*/
	}
}