package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class LeftMoveCheckerTest {

    public LeftMoveCheckerTest() {
    }

    Grid grid;
    LeftMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new LeftMoveChecker(grid);
    }

    @Test
    public void colouredCellsToLeftCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 2, true), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 2, false), true);
    }

    @Test
    public void emptyCellToLeftRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 0, false), true);
    }

    @Test
    public void cellToLeftOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 2, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 3, false), true);
    }

    @Test
    public void goToLeftUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 2, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 2);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false);
        assertEquals(i[0], 2);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToLeftUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 2, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(3, 4, false), null);
    }

    @Test
    public void goToLeftUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(4, 2, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(5, 2, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 2);
        grid.setCellInCoordinate(4, 3, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(5, 3, false);
        assertEquals(i[0], 2);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToLeftUntilBorderFound() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(1, 2, false);
        grid.setCellInCoordinate(0, 2, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 2, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        checker.turnTilesToDirectionForLegalMove(4, 2, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
        grid.setCellInCoordinate(1, 3, false);
        grid.setCellInCoordinate(0, 3, false);
        grid.setCellInCoordinate(3, 3, false);
        checker.turnTilesToDirectionForLegalMove(4, 3, true);
        assertEquals(grid.getCellInCoordinate(2, 3).getColour(), false);
    }

}
