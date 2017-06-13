package othello.slothello.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import othello.slothello.logic.movechecker.MoveChecker;

/**
 * Luokka sisältää pelin aloittamiseen, sen kulkuun, pelaamiseen ja
 * lopettamiseen liittyviä metodeja.
 */
public class Othello {

    Scanner reader = new Scanner(System.in);
    private Grid grid;
    private MoveChecker checker;

    public Othello() {
        this.grid = new Grid(8);
        this.checker = new MoveChecker(grid);
    }
    
    public Othello(Grid grid) {
        this.grid = grid;
        this.checker = new MoveChecker(this.grid);
    }

    public void setSpecificGrid(Grid grid) {
        this.grid = grid;
        this.checker = new MoveChecker(this.grid);
    }

    public void setGameGrid(int size) {
        this.grid = new Grid(size);
        this.checker = new MoveChecker(this.grid);
    }

    public boolean turnTilesForLegalMove(int x, int y, boolean a) {
        checker.isMoveLegal(x, y, a);
        checker.makeMove(x, y, a);
        return true;
    }

    public void printGrid() {
        System.out.println(grid);
    }

    public List<IntPair> findAllLegalMoves(boolean a) {
        List<IntPair> legals = new ArrayList<>();
        for (int y = 0; y <= 3; y++ ) {
            for (int x = 0; x <= 3; x++) {
                if (checker.isMoveLegal(x, y, a)) {
                    legals.add(new IntPair(x, y));
                }
            }
        }
        return legals;
    }
    
    public void makeMoveWithInput(boolean a) {
        System.out.print("Anna x koordinaatti: ");
        int x = reader.nextInt();
        System.out.println("Anna y koordinaatti: ");
        int y = reader.nextInt();
        turnTilesForLegalMove(x, y, a);       
    }
    
    public int countPoint(boolean a) {
        int points = 0;
        for (int y = 0; y <= 3; y++ ) {
            for (int x = 0; x <= 3; x++) {
                if (grid.isCellInCoordinateSameColour(x, y, a)) {
                    points++;
                }
            }
        }
        return points;
    }
    
    public void runGame() {
//        this.setGameGrid(4);
        while (true) {
            if (!findAllLegalMoves(false).isEmpty()) {
                System.out.println(grid);
                makeMoveWithInput(false);
            }
            if (!findAllLegalMoves(true).isEmpty()) {
                System.out.println(grid);
                makeMoveWithInput(true);
            }
            if (findAllLegalMoves(true).isEmpty() && findAllLegalMoves(false).isEmpty()) {
                break;
            }
        }
        System.out.println(this.countPoint(true));
        System.out.println(this.countPoint(false));
    }
}
