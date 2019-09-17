package kolokviumski;

import java.util.*;

public class MVR {
	
	static void podreduvanje(Gragjanin[] gragjanin) {
		
		Queue<Gragjanin> licnikarti = new LinkedList<>(); 
		Queue<Gragjanin> pasosi = new LinkedList<>();
		Queue<Gragjanin> vozackadozvoli = new LinkedList<>();
		
		for (int i = 0; i < gragjanin.length; i++) {
			if (gragjanin[i].getLicna() == 1) {
				licnikarti.offer(gragjanin[i]);
			}
			else if (gragjanin[i].getPasos() == 1) {
				pasosi.offer(gragjanin[i]);
			}
			else if (gragjanin[i].getVozacka() == 1) {
				vozackadozvoli.offer(gragjanin[i]);
			}
		}
		
		// MOZI DA SE IZIGRA I SO licnikarti.size == 0;
		while (!(licnikarti.isEmpty())) {
			if (licnikarti.peek().getPasos() == 1) {
				pasosi.offer(licnikarti.poll());
			}
			else if (licnikarti.peek().getVozacka() == 1) {
				vozackadozvoli.offer(licnikarti.poll());
			}
			else {
				System.out.println("NAME: " + licnikarti.poll().getName());
			}
		}
		
		while ( !(pasosi.isEmpty()) ) {
			if (pasosi.peek().getVozacka() == 1) {
				vozackadozvoli.offer(pasosi.poll());
			}
			else {
				System.out.println("NAME: " + pasosi.poll().getName());
			}
		}
		
		while ( !(vozackadozvoli.isEmpty()) ) {
			System.out.println("NAME: " + vozackadozvoli.poll().getName());
		}
		
	}

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		Gragjanin[] gragjanin = new Gragjanin[N];
		
		for (int i = 0; i < N; i++) {
			String name = input.nextLine();
			int licnakarta = Integer.parseInt(input.nextLine());
			int pasos = Integer.parseInt(input.nextLine());
			int vozackadozvola = Integer.parseInt(input.nextLine());
			gragjanin[i] = new Gragjanin(name, licnakarta, pasos, vozackadozvola);
		}
		podreduvanje(gragjanin);
		
		input.close();
	}
	
}


class Gragjanin {
	
	private String name;
	private int licnakarta;
	private int pasos;
	private int vozackadozvola;

	public Gragjanin(String name, int licnakarta, int pasos, int vozackadozvola) {
		this.name = name;
		this.licnakarta = licnakarta;
		this.pasos = pasos ;
		this.vozackadozvola = vozackadozvola;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLicna() {
		return licnakarta;
	}
	
	public int getPasos() {
		return pasos;
	}
	
	public int getVozacka() {
		return vozackadozvola;
	}
	
}