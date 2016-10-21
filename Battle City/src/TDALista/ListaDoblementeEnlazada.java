package TDALista;

import java.util.Iterator;
import java.lang.Iterable;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	
	protected DNodo<E> head,tail;
	protected int cant;
	
	public ListaDoblementeEnlazada() {
		head = new DNodo<E>();
		tail = new DNodo<E>(null,head,null);
		head.setSiguiente(tail);
		cant=0;
	}
	
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if (p==null)
			throw new InvalidPositionException("Posicion invalida");
		if (p==head)
			throw new InvalidPositionException("Head es un nodo dummy");
		if (p==tail)
			throw new InvalidPositionException("Tail es un nodo dummy");
		try {
			DNodo<E> temp = (DNodo<E>) p;
			if (temp.getAnterior()==null || temp.getSiguiente()==null)
				throw new InvalidPositionException("No existe la posicion en la lista");
			return temp;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("No existe la posicion en la lista");
		}
	}
	
	public int size() {
		return cant;
	}
	
	public boolean isEmpty() {
		return cant==0;
	}
	
	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Lista vacia");
		return head.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Lista vacia");
		return tail.getAnterior();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		DNodo<E> temp = checkPosition(p);
		DNodo<E> prev = temp.getAnterior();
		if (prev==head)
			throw new BoundaryViolationException("No se puede pedir el anterior al primer elemento");
		return prev;
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		DNodo<E> temp = checkPosition(p);
		DNodo<E> sig = temp.getSiguiente();
		if (sig==tail)
			throw new BoundaryViolationException("No se puede pedir el siguiente al ultimo elemento");
		return sig;
	}
	
	public void addFirst(E elem) {
		DNodo<E> nuevo = new DNodo<E> (elem,head,head.getSiguiente());
		head.getSiguiente().setAnterior(nuevo);
		head.setSiguiente(nuevo);
		cant++;
	}
	
	public void addLast(E elem) {
		DNodo<E> nuevo = new DNodo<E> (elem,tail.getAnterior(),tail);
		tail.getAnterior().setSiguiente(nuevo);
		tail.setAnterior(nuevo);
		cant++;
	}
	
	public void addAfter(Position<E> p,E elem) throws InvalidPositionException {
		DNodo<E> temp = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E> (elem,temp,temp.getSiguiente());
		temp.getSiguiente().setAnterior(nuevo);
		temp.setSiguiente(nuevo);
		cant++;
	}
	
	public void addBefore(Position<E> p,E elem) throws InvalidPositionException {
		DNodo<E> temp = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E> (elem,temp.getAnterior(),temp);
		temp.getAnterior().setSiguiente(nuevo);
		temp.setAnterior(nuevo);
		cant++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> temp = checkPosition(p);
		E aEliminar = temp.getElemento();
		temp.getAnterior().setSiguiente(temp.getSiguiente());
		temp.getSiguiente().setAnterior(temp.getAnterior());
		temp.setSiguiente(null);
		temp.setAnterior(null);
		cant--;
		return aEliminar;
	}
	
	public E set(Position<E> p,E elem) throws InvalidPositionException {
		DNodo<E> temp = checkPosition(p);
		E aEliminar = temp.getElemento();
		temp.setElemento(elem);
		return aEliminar;
	}
	
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> iterable = new ListaDoblementeEnlazada<Position<E>>();
		try {
			DNodo<E> aux = (DNodo<E>) this.first();
			while (aux!=tail) {
				iterable.addLast(aux);
				aux=aux.getSiguiente();
			}
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
		return iterable;
	}
	
	public void modificarLista(ListaDoblementeEnlazada<E> l) {
		try {
			for (E elem: l) {
				int cant1 = buscarCant(this,elem);
				int cant2 = buscarCant(l,elem);
				if (cant2>cant1) {
					eliminarApariciones(this,elem);
				}
				eliminarApariciones(l,elem);
			}
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private int buscarCant(ListaDoblementeEnlazada<E> l,E elem) {
		int cant=0;
		for (E e: l) {
			if (e.equals(elem))
				cant++;
		}
		return cant;
	}
	
	private void eliminarApariciones(ListaDoblementeEnlazada<E> l,E elem) throws InvalidPositionException {
		for (Position<E> pos: l.positions()) {
			DNodo<E> nodo = checkPosition(pos);
			if (nodo.element().equals(elem)) {
				l.remove(nodo);
			}
		}
	}
}
