package core;

import items.Table;

public class TableProcessor {

	public static void convert(String input, Table table, int row) {

		for (int i = 0; i < 9; i++) {
			char a = input.charAt(i);
			if (a != '-') {
				table.set(Integer.parseInt(String.valueOf(a)), row, i);
			} else {
				table.addCounter();
			}
		}

	}

}
