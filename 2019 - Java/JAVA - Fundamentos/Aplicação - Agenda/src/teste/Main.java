package teste;

public class Main {

	public static void main(String[] args) {
		
		
		ICollection l = new ICollection();

		gravar((IArrayList) l);
		

	}
	
	private static void gravar(IArrayList c) {
		System.out.println(c);
	}

}
