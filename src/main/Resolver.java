package main;

import java.util.Scanner;

import core.TableProcessor;
import items.Table;

public class Resolver {

	Table table;

	public Resolver() {
		table = new Table();
	}

	public void preProcess() {
		Scanner in = new Scanner(System.in);
		int count = 0;
		while (in.hasNextLine() && count < 9) {
			String input = in.nextLine();
//			System.out.println(input);
			TableProcessor.convert(input, table, count);
			count++;
		}
		in.close();
	}

	public void show() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(table.get(i, j));
			}
			System.out.println();
		}
	}

	public void resolve() {
		System.out.println("This sudoku is resolvable: " + recursiveAl(0, 0, 0));
		show();
	}

	private boolean recursiveAl(int initx, int inity, int counter) {
		if (counter == table.getCounter()) {
			return true;
		}
		for (int x = initx; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (table.get(x, y) == 0) {
					for (int val = 1; val < 10; val++) {
						if (table.checkAvailability(val, x, y)) {
							table.set(val, x, y);
							if (recursiveAl(x, y, counter + 1)) {
								return true;
							}
						}
					}
					table.set(0, x, y);
					return false;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Resolver r = new Resolver();
		r.preProcess();
		r.resolve();
	}

}
