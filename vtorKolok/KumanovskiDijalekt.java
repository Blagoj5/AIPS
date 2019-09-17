package vtorKolok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class KumanovskiDijalekt {
	
	static String tochno(String s, HashMap<String, String> map) {
		String[] niza = s.split(" ");
		String[] novaretarda = s.split(" ");
		boolean znak = false;
		boolean vtor = false;
		int ka = 0;
		for (int i = 0; i < niza.length; i++) {
			niza[i] = niza[i].toLowerCase();
			if ((niza[i].charAt(niza[i].length()-1)) == '.') {
				vtor = true;
				ka = 0;
			}
			if (ka == 2) {
				vtor = false;
			}
			ka++;

			if (map.containsKey(niza[i])) {
				if(znak || vtor){
					znak = false;
					vtor = false;
					novaretarda[i] = map.get(niza[i]);
					novaretarda[i] = Character.toUpperCase(novaretarda[i].charAt(0)) + novaretarda[i].substring(1, novaretarda[i].length());
				} else {
					novaretarda[i] = map.get(niza[i]);
				}
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < niza.length; i++) {
			sBuilder.append(novaretarda[i] + " ");
		}
		return sBuilder.toString();
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> map = new HashMap<>();
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String[] s = in.readLine().split(" ");
			map.put(s[0].toLowerCase(), s[1].toLowerCase());
		}
		String s = in.readLine();
		System.out.println(tochno(s, map));
	}
}
