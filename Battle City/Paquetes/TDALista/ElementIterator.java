package TDALista;

	import java.util.*;

	public class ElementIterator<E> implements Iterator<E>{
		
		protected PositionList<E> lista;
		protected Position<E> cursor;
		
		public ElementIterator (PositionList <E> pl){
			try{
			lista=pl;
			if (lista.isEmpty())
				cursor=null;
			else
				cursor=lista.first();
			}
			catch(EmptyListException e){
				System.out.println (e.getMessage());
			}
		}
		
		public boolean hasNext(){
			return cursor!=null;
		}
		public E next () throws NoSuchElementException{
			if (cursor==null)
				throw new NoSuchElementException ("No existe elemento siguiente.");
			E aux=cursor.element();
			try{
			if (cursor==lista.last())
				cursor=null;
			else
				cursor=lista.next(cursor);
			}
			catch (EmptyListException e){
				System.out.println (e.getMessage());
			}
			catch (InvalidPositionException e){
				System.out.println (e.getMessage());
			}
			catch (BoundaryViolationException e){
				System.out.println (e.getMessage());
			}
			return aux;
		}
	}
