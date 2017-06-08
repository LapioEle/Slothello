package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class DownRightMoveCheckerTest {

    public DownRightMoveCheckerTest() {
    }

    Grid grid;
    DownRightMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new DownRightMoveChecker(grid);
    }

    @Test
    public void colouredCellsToDownRightCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 1, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 1, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 1, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 1, true), false);
    }

    @Test
    public void emptyCellToDownRightRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 0, false), true);
    }

    @Test
    public void cellToDownRightOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 5, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 3, false), true);
    }

    @Test
    public void goToDownRightUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        grid.setCellInCoordinate(2, 2, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 1, true);
        assertEquals(i[0], 3);
        assertEquals(i[1], 3);
        grid.setCellInCoordinate(2, 1, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 0, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 2);
    }

    @Test
    public void goToDownRightUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 4, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 5, false), null);
    }

    @Test
    public void goToDownRightUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(4, 4, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 1, false);
        assertEquals(i[0], 4);
        assertEquals(i[1], 4);
        grid.setCellInCoordinate(2, 1, false);
        grid.setCellInCoordinate(4, 3, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 0, true);
        assertEquals(i[0], 4);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToDownRightUntilBorderFound() {
        grid.setCellInCoordinate(4, 4, true);
        grid.setCellInCoordinate(5, 5, true);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 1, false), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        grid.setCellInCoordinate(4, 3, true);
        checker.turnTilesToDirectionForLegalMove(2, 1, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
        grid.setCellInCoordinate(4, 4, false);
        checker.turnTilesToDirectionForLegalMove(1, 1, false);
        assertEquals(grid.getCellInCoordinate(3, 3).getColour(), false);
    }

}
