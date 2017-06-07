package othello.slothello.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LegalMoveCheckerTest {

    public LegalMoveCheckerTest() {
    }

    MoveChecker checker;

    @Before
    public void setUp() {
        Grid grid = new Grid(4);
        checker = new MoveChecker(grid);
    }

//    @Test
//    public void colouredCellsToLeftCorrectlyRecognized() {
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 2, true), true);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 1, true), false);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 2, false), false);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
//    }
//
//    @Test
//    public void emptyCellToLeftRecognized() {
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(1, 0, false), true);
//    }
//
//    @Test
//    public void cellToLeftOnBorder() {
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
//    }
//
//    @Test
//    public void colouredCellsToRightCorrectlyRecognized() {
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 1, false), false);
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 2, true), false);
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 2, false), true);
//    }
//
//    @Test
//    public void emptyCellToRightRecognized() {
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
//        assertEquals(checker.isCellToLeftSameColourOrEmptyOrDoesNotExist(2, 0, false), true);
//    }
//
//    @Test
//    public void cellToRightOnBorder() {
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(3, 2, true), true);
//        assertEquals(checker.isCellToRightSameColourOrEmptyOrDoesNotExist(3, 3, false), true);
//    }
//
//    @Test
//    public void colouredCellsToUpCorrectlyRecognized() {
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(1, 3, true), false);
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(2, 3, true), true);
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(2, 3, false), false);
//    }
//
//    @Test
//    public void emptyCellToUpRecognized() {
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 3, true), true);
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
//    }
//
//    @Test
//    public void cellToUpOnBorder() {
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
//        assertEquals(checker.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
//    }
//
//    @Test
//    public void colouredCellsToDownCorrectlyRecognized() {
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 0, false), false);
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(2, 0, true), false);
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(2, 0, false), true);
//    }
//
//    @Test
//    public void emptyCellToDownRecognized() {
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(0, 0, false), true);
//    }
//
//    @Test
//    public void cellToDownOnBorder() {
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 3, true), true);
//        assertEquals(checker.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
//    }
//
//    @Test
//    public void colouredCellsToUpLeftCorrectlyRecognized() {
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 3, true), true);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 3, false), false);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 2, true), false);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 2, false), true);
//    }
//
//    @Test
//    public void emptyCellToUpLeftRecognized() {
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 1, true), true);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
//    }
//
//    @Test
//    public void cellToUpLeftOnBorder() {
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
//        assertEquals(checker.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
//    }
//
//    @Test
//    public void colouredCellsToUpRightCorrectlyRecognized() {
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 3, true), false);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 2, false), false);
//    }
//
//    @Test
//    public void emptyCellToUpRightRecognized() {
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 3, true), true);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 3, false), true);
//    }
//
//    @Test
//    public void cellToUpRightOnBorder() {
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(3, 3, false), true);
//        assertEquals(checker.isCellToUpRightSameColourOrEmptyOrDoesNotExist(3, 0, true), true);
//    }
//
//    @Test
//    public void colouredCellsToDownRightCorrectlyRecognized() {
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 0, false), false);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 1, true), false);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
//    }
//
//    @Test
//    public void emptyCellToDownRightRecognized() {
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 2, false), true);
//    }
//
//    @Test
//    public void cellToDownRightOnBorder() {
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(1, 3, true), true);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
//        assertEquals(checker.isCellToDownRightSameColourOrEmptyOrDoesNotExist(3, 3, true), true);
//    }
//
//    @Test
//    public void colouredCellsToDownLeftCorrectlyRecognized() {
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(2, 0, false), false);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(3, 0, true), false);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(3, 0, false), true);
//    }
//
//    @Test
//    public void emptyCellToDownLeftRecognized() {
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
//    }
//
//    @Test
//    public void cellToDownLeftOnBorder() {
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
//        assertEquals(checker.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 3, true), true);
//    }
//
//    @Test
//    public void allLegalMovesFoundInStarterPositionIn4by4() {
//        assertEquals(checker.isMoveLegal(0, 1, false), true);
//        assertEquals(checker.isMoveLegal(0, 2, true), true);
//        assertEquals(checker.isMoveLegal(1, 0, false), true);
//        assertEquals(checker.isMoveLegal(2, 0, true), true);
//        assertEquals(checker.isMoveLegal(3, 1, true), true);
//        assertEquals(checker.isMoveLegal(3, 2, false), true);
//        assertEquals(checker.isMoveLegal(1, 3, true), true);
//        assertEquals(checker.isMoveLegal(2, 3, false), true);
//    }
//
//    @Test
//    public void goRightOverManyBlacksWorks() {
//        Grid grid = new Grid(4);
//        grid.setCellInCoordinate(1, 2, false);
//        grid.setCellInCoordinate(2, 2, false);
//        grid.setCellInCoordinate(3, 2, false);
//        checker.setGrid(grid);
//        assertEquals(checker.findFirstSameColourToRightForLegalMove(0, 2, true), false);
//        grid = new Grid(4);
//        grid.setCellInCoordinate(1, 2, false);
//        grid.setCellInCoordinate(2, 2, false);
//        grid.setCellInCoordinate(3, 2, true);
//        checker.setGrid(grid);
//        assertEquals(checker.findFirstSameColourToRightForLegalMove(0, 2, true), true);
//    }
//
//    @Test
//    public void isMoveLegalWorksOverManyWhites() {
//        Grid grid = new Grid(4);
//        grid.setCellInCoordinate(0, 3, false);
//        grid.setCellInCoordinate(1, 2, true);
//        grid.setCellInCoordinate(2, 1, true);
//        checker.setGrid(grid);
//        assertEquals(checker.isMoveLegal(3, 0, false), true);
//    }
}
