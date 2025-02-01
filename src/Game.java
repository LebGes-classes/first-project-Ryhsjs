import java.util.Scanner;

public class Game {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		Maze maze = new Maze();
		Player player = new Player(maze);
		int levelCounter = 1;
		String input = new String();
		boolean newLevel = true;

		Screen.drawScreenWithText("Лабиринт");
		scan.nextLine();
		
		Screen.drawGuideScreen();
		input = scan.nextLine();

		while (!(input.toUpperCase().equals("Q"))) {
			if (newLevel) {
				Screen.drawScreenWithText("Уровень " + levelCounter);
				scan.nextLine();
				maze.generateMaze();
				player.setPosition(maze);
				Screen.drawMaze(maze);
				newLevel = false;
			}
			else if (player.move(input.toUpperCase())) {
				Screen.drawMaze(maze);
			}
			else {
				System.out.println("Некоректный ввод");
			}

			if (player.isOnExit()) {
				Screen.drawScreenWithText("Поздравляю вы прошли уровень!");
				levelCounter++;
				newLevel = true;
			}

			input = scan.nextLine();
		}

		Screen.drawFinalScreen();
	}
}