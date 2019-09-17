//На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно 
//за соседниот град МинТаун. Цената на еден билет е 100 денари. Ако некој возрасен сака да 
//патува со k деца, треба да плати еден билет за него и k-1 билети за децата (за едно дете не
//мора да плаќа билет). Исто така, возрасен може да се вози и сам, во тој случај ќе си 
//плати еден билет за него. Дополнително знаеме дека децата не можат да се возат без да се 
//придружени од некој возрасен. Во првиот ред од влезот е даден бројот N. Во вториот ред е
//даден бројот M. Потребно е да пресметате колкав е минималниот и максималниот број на денари
//што може да ги платат патниците за билети и да ги испечатите во две линии. Во автобусот ќе
//има најмалку еден возрасен.
//
//Име на класата: Bus

package kolokviumski;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bus {
    
	public static void max(int N, int M) {
		int maximum = 0;
		if (M != 0) {
			maximum = N*100 + (M-1)*100;
		}
		else {
			maximum = N*100;
		}
		System.out.println(maximum);
	}
	
	public static void min(int N, int M) {
		boolean validation = false;
		int maximum = 0;
		if (M == 0 || M == 1 || N == 1) {
			max(N, M);
		}
		else if (N > M) {
			maximum = N*100;
			validation = true;
		}
		else if(N < M) {
			maximum = M*100; // ISTO E KO DA NAPRAM (M-N)*100 + N*100
			validation = true;
		}
		
		if (validation) {
			System.out.println(maximum);
		}
	}
   
	public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        br.close();
        
        // Vasiot kod tuka
        min(N, M);
        max(N, M);
        
        
    }

    
}
