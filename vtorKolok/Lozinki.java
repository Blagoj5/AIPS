package vtorKolok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lozinki {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
	BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
	HashMap<String, String> map = new HashMap<>();
	
	int N = Integer.parseInt(brBufferedReader.readLine());
	
	
	for (int i = 0; i < N; i++) {
		String[] s = brBufferedReader.readLine().split(" ");
		map.put(s[0], s[1]);
	}
	
	for (int i = 0; i < N; i++) {
		String[] s = brBufferedReader.readLine().split(" ");
		if (!map.isEmpty()) {
			if (map.containsKey(s[0])) {
				String storing = map.get(s[0]);
				while (!storing.equals(s[1])) {
					System.out.println("Nenajaven");
					s = brBufferedReader.readLine().split(" ");
					if (!map.containsKey(s[0])) {
						System.out.println("KEY " + s[0] + " NOT IN THE MAP");
					}
				}	
				if (storing.equals(s[1])) {
					System.out.println("Najaven");
				}
				 
			} 
			else 
				System.out.println("KEY " + s[0] + " NOT IN THE MAP");			
		} else 
			break;
		if (s[0] == "KRAJ") {
			break;
		}
		
	 }
	
	}
}

