public class Cell {
        private int x;
        private int y;
        private Cell parent;

        public Cell(int y, int x, Cell parent) {
            this.y = y;
            this.x = x;
            this.parent = parent;
        }

        public Cell findOpposite() {
            if (parent.getY() < y && y + 1 < Maze.height) {
                return new Cell(y + 1, x, this);
            }
            if (parent.getY() > y && y - 1 >= 0) {
                return new Cell(y - 1, x, this);
            }
            if (parent.getX() < x && x + 1 < Maze.width) {
                return new Cell(y, x + 1, this);
            }
            if (parent.getX() > x && x - 1 >= 0) {
                return new Cell(y, x - 1, this);
            }
            return null;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }