package ispitnaLista;


import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


 class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

 class SLL<E> {
	private SLLNode<E> first;

	public SLL() {
		// Construct an empty SLL
		this.first = null;
	}

	public void deleteList() {
		first = null;
	}

	public int length() {
		int ret;
		if (first != null) {
			SLLNode<E> tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;

	}
	
	// OVAJ MI E METODOT VO SAMATA KLASA ZA PODREDVANJE !!!!!!!!!!!!!!!!!!!!
	// <---------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// --------------------------------------------------------------------->
	public void podredi(int X) {
		SLLNode<Integer> n1 = null;
		SLLNode<Integer> n2 = null;
		
		SLLNode<Integer> head = (SLLNode<Integer>) first;
		SLLNode<Integer> saveList = null;
		SLLNode<Integer> saveList2 = null;

		
		boolean isFirst = true;
		boolean isFirst2 = true;
		while (head != null) {
			if (head.element < X) {
			  // ZA PRVIOT
				if (isFirst) {
					n1 = head;
					head = head.succ;
					isFirst = false;
					saveList = n1; // ZA DA GO CUVAM PRVIOT NODE ZA POTOA DA GO PREFRLAM VO GLAVNATA LISTA
				} 
				else {
					SLLNode<Integer> tmp = head;
					head = head.succ;
					n1.succ = tmp;
					n1 = n1.succ;
				}
			} 
			else {
				if (isFirst2) {
					n2 = head;
					head = head.succ;
					isFirst2 = false;
					saveList2 = n2; // GO CUVAM PRVIOT OD VTORIOT NODE, ZA SPOJUVANJE NA DVATA NODES NA KRAJ
				} 
				else {
					SLLNode<Integer> tmp = head;
					head = head.succ;
					n2.succ = tmp;
					n2 = n2.succ;
				}
				
			}
		}
		n1.succ = saveList2;
		first = (SLLNode<E>) saveList;
		
		head = (SLLNode<Integer>) first;
		while (head != null) {
			if (head.succ == null) {
				System.out.print(head.element);
				break;
			} 
			System.out.print(head.element + "->");
			head = head.succ;
		}
		
		
	}

	@Override
	public String toString() {
		String ret = new String();
		if (first != null) {
			SLLNode<E> tmp = first;
			ret += tmp + "->";
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret += tmp + "->";
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}

	public void insertFirst(E o) {
		SLLNode<E> ins = new SLLNode<E>(o, first);
		first = ins;
	}

	public void insertAfter(E o, SLLNode<E> node) {
		if (node != null) {
			SLLNode<E> ins = new SLLNode<E>(o, node.succ);
			node.succ = ins;
		} else {
			System.out.println("Dadenot jazol e null");
		}
	}

	public void insertBefore(E o, SLLNode<E> before) {
		
		if (first != null) {
			SLLNode<E> tmp = first;
			if(first==before){
				this.insertFirst(o);
				return;
			}
			//ako first!=before
			while (tmp.succ != before)
				tmp = tmp.succ;
			if (tmp.succ == before) {
				SLLNode<E> ins = new SLLNode<E>(o, before);
				tmp.succ = ins;
			} else {
				System.out.println("Elementot ne postoi vo listata");
			}
		} else {
			System.out.println("Listata e prazna");
		}
	}

	public void insertLast(E o) {
		if (first != null) {
			SLLNode<E> tmp = first;
			while (tmp.succ != null)
				tmp = tmp.succ;
			SLLNode<E> ins = new SLLNode<E>(o, null);
			tmp.succ = ins;
		} else {
			insertFirst(o);
		}
	}

	public E deleteFirst() {
		if (first != null) {
			SLLNode<E> tmp = first;
			first = first.succ;
			return tmp.element;
		} else {
			System.out.println("Listata e prazna");
			return null;
		}
	}

	public E delete(SLLNode<E> node) {
		if (first != null) {
			SLLNode<E> tmp = first;
			if(first ==node){
				return this.deleteFirst();
			}
			while (tmp.succ != node && tmp.succ.succ != null)
				tmp = tmp.succ;
			if (tmp.succ == node) {
				tmp.succ = tmp.succ.succ;
				return node.element;
			} else {
				System.out.println("Elementot ne postoi vo listata");
				return null;
			}
		} else {
			System.out.println("Listata e prazna");
			return null;
		}

	}

	public SLLNode<E> getFirst() {
		return first;
	}
	
	public SLLNode<E> find(E o) {
		if (first != null) {
			SLLNode<E> tmp = first;
			while (tmp.element != o && tmp.succ != null)
				tmp = tmp.succ;
			if (tmp.element == o) {
				return tmp;
			} else {
				System.out.println("Elementot ne postoi vo listata");
			}
		} else {
			System.out.println("Listata e prazna");
		}
		return first;
	}
	
    public Iterator<E> iterator () {
    // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<E>();
    }

	// //////////Inner class ////////////

	private class LRIterator<E> implements Iterator<E> {

		private SLLNode<E> place, curr;

		private LRIterator() {
			place = (SLLNode<E>) first;
			curr = null;
		}

		public boolean hasNext() {
			return (place != null);
		}

		public E next() {
			if (place == null)
				throw new NoSuchElementException();
			E nextElem = place.element;
			curr = place;
			place = place.succ;
			return nextElem;
		}

		public void remove() {
			//Not implemented
		}
	}
	
	public void mirror(){
		if (first != null) {
			//m=nextsucc, p=tmp,q=next
			SLLNode<E> tmp = first;
			SLLNode<E> newsucc = null;
			SLLNode<E> next;
			
			while(tmp != null){
				next = tmp.succ;
				tmp.succ = newsucc;
				newsucc = tmp;
				tmp = next;
			}
			first = newsucc;
		}
		
	}
	
	public void merge (SLL<E> in){
		if (first != null) {
			SLLNode<E> tmp = first;
			while(tmp.succ != null)
				tmp = tmp.succ;
			tmp.succ = in.getFirst();
		}
		else{
			first = in.getFirst();
		}
	}
}


public class FinalArray {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			SLL<Integer> lista = new SLL();
			
			int N = in.nextInt();
			
			in.nextLine();
			String s = in.nextLine();
			String[] array = new String[N]; // ZA DA NE E POGOLEM OD N-ot
			array = s.split(" ");
			
			for (int i = 0; i < N; i++) {
				lista.insertLast(Integer.parseInt(array[i]));
			
			}
			int X = Integer.parseInt(in.nextLine());
			lista.podredi(X);
		}
}
