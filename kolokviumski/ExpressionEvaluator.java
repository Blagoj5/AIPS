package kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {
	
	
	
	static int calculator(String line) {

		Stack<Integer> stack = new Stack<>();
		Stack<Character> stackchar = new Stack<>();
													// MOZI I SO line.toCharArray();
		
		char[] chararray = line.toCharArray();
		int broj = 0;
		int rezz = 0;
		int i = 0;
		
		while (i < chararray.length) {
			if ( chararray[i] >= '0' && chararray[i] <= '9' ) {
				StringBuffer sBuffer = new StringBuffer();
				// AKO BROJOT E DVOCIFREN
				while ( i < chararray.length && chararray[i] >= '0' && chararray[i] <= '9' )  
					sBuffer.append(chararray[i++]);
				stack.push(Integer.parseInt(sBuffer.toString())); 
			}
			if (i > chararray.length-1) {
				break;
			}
			else if (chararray[i] == '*' ) {
					broj = stack.pop();
					i++;					// ZA DA ne e SAMIOT TOJ *
					StringBuffer sBuffer = new StringBuffer();
					while ( i < chararray.length && chararray[i] >= '0' && chararray[i] <= '9' )  
						sBuffer.append(chararray[i++]);
					int brojce = Integer.parseInt(sBuffer.toString());
					rezz = broj * brojce; // ZA DA GO ZGOLEMI NA LICE MESTO ZA da GO ZEMI SLEDNIOT A NE *
					stack.push(rezz);
			} 
			
			if (i > chararray.length-1) {
				break;
			}
			else if ( chararray[i] == '+' ) // DOKOLKU e +
			{ 
				stackchar.push(chararray[i]);
				i++;
			}
		}
		
		while (!stackchar.isEmpty()) {
			stackchar.pop();
			int broj1 = stack.pop();
			int broj2 = stack.pop();
			
			
			rezz = broj1 + broj2;
			stack.push(rezz);
		}

		return stack.peek();
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(calculator(in.readLine()));
	}
	
}
