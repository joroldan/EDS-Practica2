/************************************************************************
  DobleCola.java

  Implementacion de una doble-cola generica

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

public class DobleCola<T>
{
	private Nodo<T> primero;
	private Nodo<T>  ultimo;
	
	public DobleCola() //Constructor sin parametros de la clase DobleCola
	{ 
		this.primero=null;
		this.ultimo =null;
	}

	public void addFinal (T elemento) //coloca al final
	{
		Nodo<T> nuevo = new Nodo<T>(elemento);
		if (this.primero==null)
		{
			this.primero=nuevo;
			this.ultimo=nuevo;
		}
		else
		{
			this.ultimo.sig=nuevo;
			this.ultimo=nuevo;
		}
	}
	
	public void addPrincipio (T elemento) //coloca al principio
	{
		if (this.primero==null)
		{
			this.primero = new Nodo<T>(elemento);
			this.ultimo = this.primero;
		}
		else
		{
			Nodo<T> now = this.primero;
			this.primero = new Nodo<T>(elemento,now);
		}
	}
	
	public boolean vacia() //Devuelve true si la cola esta vacia y false en caso contrario
	{
		return (this.primero == null);
	}
	
	public T primero() //Devuelve el dato correspondiente al primer elemento de la cola, y si este no existe, devuelve null
	{
		if (this.primero!=null) return this.primero.dato;
		else return null;
	}
	
	public T eliminaPrimero() //elimina el primer elemento y lo devuelve
	{ 
		if (this.primero == null)         return null;
		if (this.primero == this.ultimo)  this.ultimo=null;

		T aux = this.primero.dato;
		this.primero = this.primero.sig;
		return aux;
	}
	
	//ant.sig nullpointerexception
	public T eliminaUltimo() //elimina y devuelve el ultimo elemento de la cola
	{
		
		if (this.ultimo == null)         return null;
		if (this.primero == this.ultimo)  this.primero=null;
		
		Nodo <T> ant = this.primero;
		Nodo <T> now = this.primero;
		
		while(now!=this.ultimo)
		{
			ant=now;
			now=now.sig;
		}
		
		T aux = this.ultimo.dato;
		ant.sig = null;
		this.ultimo=ant;
		return aux;
	}
	
	public T ultimo() //muestra el ultimo elemento de la cola
	{
		if (this.ultimo!=null) return this.ultimo.dato;
		else return null;
	}
	
	public void mostrar() //imprime la cola por pantalla haciendo uso del toString de cada elemento
	{
		Nodo <T> aux=this.primero;
		if(aux!=null)
		{
			System.out.print("\n"+aux.dato.toString()+" ");
			while(aux.sig!=null)
			{
				aux=aux.sig;
				System.out.print(aux.dato.toString()+ " ");
			}
		}
		else System.out.println("La lista esta vacia");
	}
}