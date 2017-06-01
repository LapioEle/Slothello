package othello.slothello.logic;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(4);
        Othello othello = new Othello();
        othello.setGameGrid(4);
        othello.isMoveLegal(1, 2, false);
    }

}
