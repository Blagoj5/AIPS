package kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PostFixEvaluation {
	
	public static int postFix(String exp[]) {
		
		Stack<Integer> stack = new Stack<>();
		
		
		for (int i = 0; i < exp.length; i++) {
			
			if ( exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/") ) {
				
				int element1 = stack.pop();
				int element2 = stack.pop();
				
				if ( exp[i].equals("+") ) {
					
					System.out.println("The Sign is +");
					int result = (element1+element2);
					stack.push(result);					

				}
								
				if ( exp[i].equals("-") ) {
					
					System.out.println("The Sign is -");
					int result = element1-element2;
					stack.push(result);					
				}
				
				if ( exp[i].equals("*") ) {
									
					System.out.println("The Sign is *");
					int result = element1/element2;
					stack.push(result);
								
				}

				if ( exp[i].equals("/") ) {
					
					System.out.println("The Sign is /");
					int result = element1/element2;
					stack.push(result);
					
				}
				
			}
			else {
				int a = Integer.parseInt(exp[i]);
				stack.push(a);
			}
			
		}
		
		return stack.peek();
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] exp = br.readLine().split(" ");
		try {
			System.out.println(postFix(exp));
		} catch (EmptyStackException e) {
			// TODO: handle exception
			System.out.println("The Stack is empty");
		}		
		
		
//		System.out.println(exp);
		

	}

}
