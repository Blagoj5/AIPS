package kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckXML {

	static int checkenzi(String[] exp) {
		
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < exp.length; i++) {
			if (exp[i].substring(0, 2).equals("[/")) {	
				String elementpop = stack.pop();
				if (!(exp[i].substring(2, exp[i].length()-1 ).equals(elementpop.substring(1, elementpop.length()-1 )))) {
					return 0;		
				}
			}	
			else if (exp[i].substring(0, 1).equals("[")) {
				stack.push(exp[i]);
			}
			
		}
		return 1;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] exp = new String[n];
		for (int i = 0; i < n; i++) {
			exp[i] = br.readLine();
		}
		int result = checkenzi(exp);
		System.out.println(result);
		System.out.println(checkenzi(exp));

		
	}

}
