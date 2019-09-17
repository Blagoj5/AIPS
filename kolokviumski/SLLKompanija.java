package kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class SLLNode {
	protected int id;
	protected int plata;
	protected SLLNode succ;

	public SLLNode(int id,int plata, SLLNode succ) {
		this.id = id;
		this.plata=plata;
		this.succ = succ;
	}

	
}

class SLL {
	private SLLNode first;

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
			SLLNode tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;

	}


	public void insertFirst(int id, int plata) {
		SLLNode ins = new SLLNode(id,plata, first);
		first = ins;
	}

	public void insertLast(int id,int plata) {
		if (first != null) {
			SLLNode tmp = first;
			while (tmp.succ != null)
				tmp = tmp.succ;
			SLLNode ins = new SLLNode(id, plata, null);
			tmp.succ = ins;
		} else {
			insertFirst(id,plata);
		}
	}

	public SLLNode getFirst() {
		return first;
	}
	
	
	public SLL brisi_pomali_od(int iznos) {
		// Vasiot kod tuka
		SLLNode current = first;
		SLL newlist = new SLL();
		while (current != null) {
		if (current.plata >= iznos) {
			newlist.insertLast(current.id, current.plata);
			current = current.succ;
		} else if (current.plata < iznos) {
			current = current.succ;
		}
		}
		if (newlist.length() == 0) {
			System.out.println("nema");
		}
		return newlist;
	}
   
	public SLL sortiraj_opagacki() {		
		SLLNode firstNode = first;
		SLLNode currentNode = first;
		SLL newlistSll = new SLL();
		for (int i = this.length()-1; i >= 0; i--) {
		currentNode = first;
		firstNode = first;
		while (currentNode != null) {
			if (firstNode.id >= currentNode.id) {
				currentNode = currentNode.succ;
			}
			else if (firstNode.id < currentNode.id) {
				firstNode = currentNode;
				currentNode = currentNode.succ;
			}
			else {
				currentNode = currentNode.succ;
			}
		}
		currentNode = firstNode;
		newlistSll.insertLast(firstNode.id, firstNode.plata);
		currentNode.id = -1; // ZA DA GO RIPA POSTO TOJ E VEKE ZEMEN, MOZI I SO OTSRANUVANJE NA NODEOT
		}
		return newlistSll;
	}
	
    public void pecati (SLL lista)
    {
    	SLLNode p=lista.first;
    	while(p!=null)
    	{
    		System.out.println(p.id+" "+p.plata);
    		p=p.succ;
    	}
    }
	
}
public class SLLKompanija {
	public static void main(String[] args) throws IOException {

		SLL lista1 = new SLL();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String s = stdin.readLine();
		int N = Integer.parseInt(s);
		
		for (int i = 0; i < N; i++) {
			s=stdin.readLine();
			String s1=stdin.readLine();
			lista1.insertLast(Integer.parseInt(s),Integer.parseInt(s1));
		}
		s = stdin.readLine();
		
		lista1=lista1.brisi_pomali_od(Integer.parseInt(s));
		if(lista1!=null)
        {
		    lista1=lista1.sortiraj_opagacki();
		    lista1.pecati(lista1);
        }
	}
}
