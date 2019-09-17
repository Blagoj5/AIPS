package vtorKolok;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "warrup.";
		String[] arr = s.split("[, ?.@]+");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
