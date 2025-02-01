import java.util.Random;
import java.util.ArrayList;

public class Maze {
    private int startX;
    private int startY;
    private int exitX;
    private int exitY;
	private char[][] maze;
	private ArrayList<Cell> frontiers  = new ArrayList<Cell>();

	public static final int width = 20;
	public static final int height = 20;
	public static final char WALL = '#';
    public static final char PATH = '.';
    public static final char EXIT = 'E';
    public static final char PLAYER = 'P';

	public void generateMaze() {
		Random random = new Random();
		maze = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = WALL;
            }
        }

        startY = random.nextInt(height);
        startX = random.nextInt(width);
        Cell start = new Cell(startY, startX, null);
        maze[startY][startX] = PLAYER;

        addFrontiers(start);

        Cell last = null;

        while (!frontiers.isEmpty()) {
            Cell current = frontiers.remove(random.nextInt(frontiers.size()));
            Cell opposite = current.findOpposite();
            if (opposite != null) {
            	if (maze[current.getY()][current.getX()] == WALL && maze[opposite.getY()][opposite.getX()] == WALL) {
                    maze[current.getY()][current.getX()] = PATH;
                    maze[opposite.getY()][opposite.getX()] = PATH;

                    last = opposite;

                	addFrontiers(opposite);
	            }
            }
        }
        exitX = last.getX();
    	exitY = last.getY();
        maze[last.getY()][last.getX()] = EXIT;
	}

	private void addFrontiers (Cell cell) {
		if (cell.getY() > 0 && maze[cell.getY() - 1][cell.getX()] == WALL) {
        	frontiers.add(new Cell(cell.getY() - 1, cell.getX(), cell));
        }
        if (cell.getY() < height - 1 && maze[cell.getY() + 1][cell.getX()]  == WALL) {
        	frontiers.add(new Cell(cell.getY() + 1, cell.getX(), cell));
        }
        if (cell.getX() > 0 && maze[cell.getY()][cell.getX() - 1] == WALL) {
        	frontiers.add(new Cell(cell.getY(), cell.getX() - 1, cell));
        }
        if (cell.getX() < width - 1 && maze[cell.getY()][cell.getX() + 1] == WALL) {
        	frontiers.add(new Cell(cell.getY(), cell.getX() + 1, cell));
    	}
	}

	public void setPlayerPosition(int x, int y, int newX, int newY) {
		maze[newY][newX] = PLAYER;
		maze[y][x] = PATH;
	}

	public char getCellValue(int x, int y) {
		return maze[y][x];
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getExitX() {
		return exitX;
	}

	public int getExitY() {
		return exitY;
	}
}