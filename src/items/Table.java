package items;

public class Table {

	private int[][] diagram;
	private int[] group = { 0, 3, 6 };
	private int counter = 0;

	public Table() {
		diagram = new int[9][9];
	}

	public int get(int i, int j) {
		return diagram[i][j];
	}

	public void set(int value, int i, int j) {
		diagram[i][j] = value;

	}

	public boolean checkAvailability(int value, int i, int j) {
		int x = group[i / 3];
		int y = group[j / 3];
		for (int it = 0; it < 9; it++) {
			if (diagram[it][j] == value || diagram[i][it] == value || diagram[x][y] == value) {
				return false;
			}
			y++;
			if (it == 2 || it == 5 || it == 8) {
				y -= 3;
				x++;
			}

		}
		return true;
	}

	public int getCounter() {
		return counter;
	}

	public void addCounter() {
		counter++;
	}

}
