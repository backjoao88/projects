package jpb.exercise2;

public class teste {

	public static void main(String[] args) {
		
		
		Table table = new Table(3);
		

		table.insert('X', 0, 0);
		table.insert('X', 0, 1);
		table.insert('X', 0, 2);
		table.insert('X', 1, 0);
		table.insert('X', 1, 1);
		table.insert('X', 1, 2);
		table.insert('X', 2, 0);
		table.insert('X', 2, 1);
		table.insert('X', 2, 2);
		System.out.println(table.tableFull());
		
	}

}
