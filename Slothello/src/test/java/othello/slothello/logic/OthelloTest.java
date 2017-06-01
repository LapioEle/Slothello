package othello.slothello.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OthelloTest {

    public OthelloTest() {
    }
    
    Othello othello;
    
    @Before
    public void setUp() {
        othello = new Othello();
        othello.setGameGrid(4);
    }

    @Test
    public void colouredCellsToLeftCorrectlyRecognized() {
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 2, true), true);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 1, true), false);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 2, false), false);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
    }
    
    @Test
    public void emptyCellToLeftRecognized() {
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(1, 0, false), true);
    }
    
    @Test
    public void cellToLeftOnBorder() {
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
    }
    
    @Test
    public void colouredCellsToRightCorrectlyRecognized() {
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 1, false), false);
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 2, true), false);
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(0, 2, false), true);
    }
    
    @Test
    public void emptyCellToRightRecognized() {
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
        assertEquals(othello.isCellToLeftSameColourOrEmptyOrDoesNotExist(2, 0, false), true);
    }
    
    @Test
    public void cellToRightOnBorder() {
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(3, 2, true), true);
        assertEquals(othello.isCellToRightSameColourOrEmptyOrDoesNotExist(3, 3, false), true);
    }
    
    @Test
    public void colouredCellsToUpCorrectlyRecognized() {
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(1, 3, true), false);
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(2, 3, true), true);
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(2, 3, false), false);
    }
    
    @Test
    public void emptyCellToUpRecognized() {
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 3, true), true);
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
    }
    
    @Test
    public void cellToUpOnBorder() {
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
        assertEquals(othello.isCellToUpSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
    }
    
    @Test
    public void colouredCellsToDownCorrectlyRecognized() {
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 0, false), false);
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(2, 0, true), false);
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(2, 0, false), true);
    }
    
    @Test
    public void emptyCellToDownRecognized() {
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(0, 0, false), true);
    }
    
    @Test
    public void cellToDownOnBorder() {
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 3, true), true);
        assertEquals(othello.isCellToDownSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
    }
    
    @Test
    public void colouredCellsToUpLeftCorrectlyRecognized() {
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 3, true), true);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 3, false), false);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 2, true), false);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 2, false), true);
    }
    
    @Test
    public void emptyCellToUpLeftRecognized() {
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 1, true), true);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
    }
    
    @Test
    public void cellToUpLeftOnBorder() {
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(1, 0, true), true);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
        assertEquals(othello.isCellToUpLeftSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
    }
    
    @Test
    public void colouredCellsToUpRightCorrectlyRecognized() {
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 3, true), false);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 3, false), true);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(0, 2, false), false);
    }
    
    @Test
    public void emptyCellToUpRightRecognized() {
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 3, true), true);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 3, false), true);
    }
    
    @Test
    public void cellToUpRightOnBorder() {
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(3, 3, false), true);
        assertEquals(othello.isCellToUpRightSameColourOrEmptyOrDoesNotExist(3, 0, true), true);
    }
    
    @Test
    public void colouredCellsToDownRightCorrectlyRecognized() {
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 0, true), true);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 0, false), false);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 1, true), false);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
    }
    
    @Test
    public void emptyCellToDownRightRecognized() {
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 2, true), true);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(0, 2, false), true);
    }
    
    @Test
    public void cellToDownRightOnBorder() {
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(1, 3, true), true);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(3, 1, false), true);
        assertEquals(othello.isCellToDownRightSameColourOrEmptyOrDoesNotExist(3, 3, true), true);
    }
    
    @Test
    public void colouredCellsToDownLeftCorrectlyRecognized() {
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(2, 0, true), true);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(2, 0, false), false);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(3, 0, true), false);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(3, 0, false), true);
    }
    
    @Test
    public void emptyCellToDownLeftRecognized() {
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, false), true);
    }
    
    @Test
    public void cellToDownLeftOnBorder() {
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 1, true), true);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(1, 3, false), true);
        assertEquals(othello.isCellToDownLeftSameColourOrEmptyOrDoesNotExist(0, 3, true), true);
    }
    
    @Test
    public void allLegalMovesFoundInStarterPositionIn4by4() {
        assertEquals(othello.isMoveLegal(0, 1, false), true);
        assertEquals(othello.isMoveLegal(0, 2, true), true);
        assertEquals(othello.isMoveLegal(1, 0, false), true);
        assertEquals(othello.isMoveLegal(2, 0, true), true);
        assertEquals(othello.isMoveLegal(3, 1, true), true);
        assertEquals(othello.isMoveLegal(3, 2, false), true);
        assertEquals(othello.isMoveLegal(1, 3, true), true);
        assertEquals(othello.isMoveLegal(2, 3, false), true);
    }
    
    @Test
    public void goRightOverManyBlacksWorks() {
        Grid grid = new Grid(4);
        grid.setCellInCoordinate(1, 2, false);
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(3, 2, false);
        othello.setSpecificGrid(grid);
        assertEquals(othello.findFirstSameColourToRightForLegalMove(0, 2, true), false);
        grid = new Grid(4);
        grid.setCellInCoordinate(1, 2, false);
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(3, 2, true);
        othello.setSpecificGrid(grid);
        assertEquals(othello.findFirstSameColourToRightForLegalMove(0, 2, true), true);
    }
    
    @Test
    public void isMoveLegalWorksOverManyWhites() {
        Grid grid = new Grid(4);
        grid.setCellInCoordinate(0, 3, false);
        grid.setCellInCoordinate(1, 2, true);
        grid.setCellInCoordinate(2, 1, true);
        othello.setSpecificGrid(grid);
        assertEquals(othello.isMoveLegal(3, 0, false), true);
    }
}
