package kolokviumski;

import java.util.Scanner;
import java.util.Stack;


public class StackBukvi {
	
	static int brojac(Stack<Character> s) {
		int brojac = 0;
		while(!s.isEmpty()) {
			
			if (s.peek() == 'T') {
				brojac ++;
				s.pop();
			}
			else if (s.peek() == 'S') {
				break;
			} 
			else {
				s.pop();
			}
		}
		return brojac;
	}
	
	static int checkforT(String s) {
		char [] array = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		boolean pomoshnik = true;
		int compare = 0;
		
		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		
		while (!stack.isEmpty()) {
			int compareTo = 0;
			boolean anotherone = false;

			// ZA DA VLEZI SAMO EDNASH A TO E PRVIOT PAT
			if (pomoshnik) {
				compare = brojac(stack);
				pomoshnik = false;
			}
			
			// DO KAJ SHO E SLEDNOTO S
			if (stack.pop() == 'S') {
				compareTo = brojac(stack);
				anotherone = true;
			}
			
			if (compare != compareTo && anotherone) {
				return 0;
			} else {
				continue;
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
