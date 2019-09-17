package kolokviumski;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class card_trick {

	static int counterino(int N) {
		Queue<Integer> cards = new LinkedList<>();
		Stack<Integer> stack = new Stack<Integer>();
		int number = 0;
		
		for (int i = 1; i <= 51; i++) {
			cards.offer(i);
		}
		
		while (cards.peek() != N) {
			
			for (int i = 1; i <= 7; i++) {
				stack.push(cards.poll());
			}
			
			while (!stack.isEmpty()) {
				cards.offer(stack.pop());
				cards.offer(cards.poll());
			}
			
			number++;
			
		}
		return number;
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		System.out.println(counterino(s));
	}

}
