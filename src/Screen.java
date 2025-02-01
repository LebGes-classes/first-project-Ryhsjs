public class Screen {
	public static void drawScreenWithText(String text) {
		cleanConsole();
		for (int y = 0; y < Maze.height; y++) {
			if (y == 0 || y == Maze.height - 1) {
				drawFullLine();
			}
			else if (y == Maze.height / 2 - 1) {
				drawLineWithText(text);
			}
			else if (y == Maze.height - 3) {
				drawLineWithText("Далее - Enter");
			}
			else {
				drawEmptyLine();
			}
		}
	}

	public static void drawGuideScreen() {
		cleanConsole();
		String text[] = {
			"Обозначения:", 
			"'" + Maze.WALL + "' - стена", 
			"'" + Maze.PATH + "' - проход", 
			"'" + Maze.PLAYER + "' - игрок", 
			"'" + Maze.EXIT + "' - выход", 
			"Управление:", 
			"Вверх - W", 
			"Влево - A", 
			"Вниз - S", 
			"Вправо - D", 
			"Далее - Enter"
		};
		
		for (int y = 0; y < Maze.height; y++) {
			if (y == 0 || y == Maze.height - 1) {
				drawFullLine();
			}
			else if (y >= Maze.height / 10 && y <= Maze.height / 10 + 4) {
				drawLineWithText(text[y - Maze.height / 10]);
			}
			else if (y >= Maze.height / 2 && y <= Maze.height / 2 + 4) {
				drawLineWithText(text[y - Maze.height / 2 + 5]);
			}
			else if (y == Maze.height - 3) {
				drawLineWithText(text[text.length - 1]);
			}
			else {
				drawEmptyLine();
			}
		}
	}

	public static void drawMaze(Maze maze) {
		cleanConsole();
		for(int y = 0; y < Maze.height; y++) {
			String line = new String();
			for (int x = 0; x < Maze.width; x++) {
				line += maze.getCellValue(x, y) + " ";
			}
			System.out.println(line);
		}
	}

	public static void drawFinalScreen() {
		cleanConsole();
		for (int y = 0; y < Maze.height; y++) {
			if (y == 0 || y == Maze.height - 1) {
				drawFullLine();
			}
			else if (y == Maze.height / 2 - 1) {
				drawLineWithText("Игра окончена");
			}
			else {
				drawEmptyLine();
			}
		}
	}

	private static void drawFullLine() {
		String line = new String();
		for (int x = 0; x < Maze.width; x++) {
			line += Maze.WALL + " ";
		}
		System.out.println(line);
	}

	private static void drawEmptyLine() {
		String line = Maze.WALL + " ";
		for (int x = 1; x < Maze.width - 1; x++) {
			line += "  ";
		}
		line += Maze.WALL;  
		System.out.println(line);
	}

	private static void drawLineWithText(String text) {
		String line = Maze.WALL + " ";
		for (int x = 2; x < 2 * Maze.width - 1; x++) {
			if (x < Maze.width - (text.length() + 1) / 2 || x > Maze.width + text.length() / 2){
				line += " ";
			}
			else if (x == Maze.width - (text.length() + 1) / 2) {
				line += text;
			}
		}
		line += Maze.WALL;  
		System.out.println(line);
	}

	private static void cleanConsole() {
		try {
    		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
    	System.out.println(E);
		}
	}
}