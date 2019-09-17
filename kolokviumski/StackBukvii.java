package kolokviumski;

import java.util.Scanner;
import java.util.Stack;


public class StackBukvii {
	
	// NAMESTO VAKA ZA POEDNOSTAVNO MOZEVME SAMO DA NAPRAVIME FUNKCIJATA VO SLUCAJOT funkc. brojac
	// DA VRAKA ARRAY OD Integer int[] i NAMESTO VO NOV STACK DA GO SMESTUVAME BROJACOT, VO
	// TAA NIZA I POTOA VO GLAVNATA checkforT funkcija samo da sporeduvame i != i+1
	// VO GLAVNATA FUNKCIJA KE NAPRAVIME SAMO NOVA INT NIZA vo koja ke ja povikuvame samata
	// funkcija brojac i potoa pravime for do taa niza.lenght i go sporeduvame niza[i] > niza[i+1]
	// vaka so niza mislam e podobro reshenie
	static Stack<Integer> brojac(Stack<Character> s) {
		Stack<Integer> stack = new Stack<>(); 
		int brojac = 0;
		while(!s.isEmpty()) {
			Character popper = s.pop();
			
			if (popper == 'T') {
				brojac ++;
			}
			
			if (popper == 'S') {
				stack.push(brojac);
				brojac = 0;
			}
		}
		return stack;
	}
	
	static int checkforT(String s) {
		char [] array = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stackstore = new Stack<>();

		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
	
		stackstore = brojac(stack);
		int broj1 = stackstore.pop();

		while (!stackstore.isEmpty()) {
			int broj2 = stackstore.pop();
			if (broj1 != broj2) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(checkforT(s));
		in.close();
	}
}
