package othello.slothello.logic;

import java.util.List;
import javax.swing.SwingUtilities;
import othello.slothello.ui.Board;

public class Main {

    public static void main(String[] args) {
//        Grid grid = new Grid(4);
//        grid.printGrid();
//        Othello othello = new Othello(grid);
//        List<IntPair> lailliset = othello.findAllLegalMoves(false);
//        for (int i = 0; i < lailliset.size(); i++) {
//            System.out.println(lailliset.get(i).giveX());
//            System.out.println(lailliset.get(i).giveY());
//        }
//        Grid grid = new Grid(4);
//        grid.setCellInCoordinate(2, 1, true);
//        grid.setCellInCoordinate(1, 2, true);
//        Othello othello = new Othello(grid);
//        othello.runGame();
//    }
    SwingUtilities.invokeLater(new Board());

}
