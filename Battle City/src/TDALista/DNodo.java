package TDALista;

public class DNodo<E> implements Position<E> {
	
	protected E elemento;
	protected DNodo<E> anterior,siguiente;
	
	public DNodo(E elem,DNodo<E> ant,DNodo<E> sig) {
		elemento=elem;
		anterior=ant;
		siguiente=sig;
	}
	
	public DNodo() {
		this(null,null,null);
	}
	
	public DNodo(E elem) {
		this(elem,null,null);
	}
	
	public DNodo<E> getAnterior() {
		return anterior;
	}
	
	public DNodo<E> getSiguiente() {
		return siguiente;
	}
	
	public E getElemento() {
		return elemento;
	}
	
	public void setAnterior(DNodo<E> ant) {
		anterior=ant;
	}
	
	public void setSiguiente(DNodo<E> sig) {
		siguiente=sig;
	}
	
	public void setElemento(E elem) {
		elemento=elem;
	}
	
	public E element() {
		return elemento;
	}
}
