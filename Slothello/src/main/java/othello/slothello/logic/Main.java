package othello.slothello.logic;

public class Main {

    public static void main(String[] args) {
        Othello othello = new Othello();
        othello.turnTilesForLegalMove(0, 2, true);
        othello.soutGrid();
        othello.turnTilesForLegalMove(0, 3, false);
        othello.soutGrid();
        
    }

}
