/************************************************************************
  JugadaInvalida.java

  Excepcion en la partida de domino

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

@SuppressWarnings("serial")
class JugadaInvalida extends RuntimeException
{
	public JugadaInvalida()
	{
		super();
	}

	public JugadaInvalida(String s)
	{
		super(s);
	}
}