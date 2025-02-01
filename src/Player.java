public class Player {
	private int x;
	private int y;
	private final Maze maze;

	public Player (Maze maze) {
		this.maze = maze;
	}

	public void setPosition(Maze maze) {
		x = maze.getStartX();
		y = maze.getStartY();
	}

	public boolean move(String input) {
		int newX = x;
		int newY = y;
		switch (input) {
			case "W":
				if (y - 1 < 0) return false; 
				newY--;
				break;
			case "A":
				if (x - 1 < 0) return false; 
				newX--;
				break;
			case "S":
				if (y + 1 >= Maze.height) return false; 
				newY++;
				break;
			case "D":
				if (x + 1 >= Maze.width) return false;
				newX++;
				break;
			default:
				return false;
		}
		if (maze.getCellValue(newX, newY) != Maze.WALL) {
			maze.setPlayerPosition(x, y, newX, newY);
			x = newX;
			y = newY;
			return true;
		}
		return false;
	}

	public boolean isOnExit() {
		if (x == maze.getExitX() && y == maze.getExitY()) {
			return true;
		}
		return false;
	}
}