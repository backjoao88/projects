package jpb.exercise2;

import java.util.Arrays;

public class Table {

	private char[][] table = null;

	public Table(int size) {
		table = new char[size][size];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = '-';
			}
		}
	}

	public void showTable() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + " | ");
			}
			System.out.println();
		}
	}

	public boolean insert(char value, int row, int column) {
		table[row][column] = value;

		return continuaJogo();
	}

	private boolean continuaJogo() {

		if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] != '-') {
			return true;
		}

		if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] != '-') {
			return true;
		}

		if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][0] != '-') {
			return true;
		}

		if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] != '-') {
			return true;
		}

		if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] != '-') {
			return true;
		}

		if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] != '-') {
			return true;
		}

		if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] != '-') {
			return true;
		}

		if (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] != '-') {
			return true;
		}

		return false;
	}

	public boolean tableFull() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if (table[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public char[][] getTable() {
		return table;
	}

	public void setTable(char[][] table) {
		this.table = table;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tabuleiro [tabuleiro=");
		builder.append(Arrays.toString(table));
		builder.append("]");
		return builder.toString();
	}

}
