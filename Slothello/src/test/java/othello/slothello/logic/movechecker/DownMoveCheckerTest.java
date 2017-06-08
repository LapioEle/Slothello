package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class DownMoveCheckerTest {

    public DownMoveCheckerTest() {
    }

    Grid grid;
    DownMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new DownMoveChecker(grid);
    }

    @Test
    public void colouredCellsToDownCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 1, true), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 1, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 1, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 1, true), true);
    }

    @Test
    public void emptyCellToDownRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 1, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 1, false), true);
    }

    @Test
    public void cellToDownOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 5, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 5, false), true);
    }

    @Test
    public void goToDownUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(3, 1, true);
        assertEquals(i[0], 3);
        assertEquals(i[1], 3);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(2, 1, false);
        assertEquals(i[0], 2);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToDownUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(3, 1, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(2, 1, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false), null);
    }

    @Test
    public void goToDownUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(2, 4, true);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(2, 1, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 4);
        grid.setCellInCoordinate(3, 2, true);
        grid.setCellInCoordinate(3, 4, false);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(3, 1, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 4);
    }

    @Test
    public void goToDownUntilBorderFound() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(2, 4, false);
        grid.setCellInCoordinate(2, 5, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(2, 1, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        checker.turnTilesToDirectionForLegalMove(2, 1, false);
        assertEquals(grid.getCellInCoordinate(2, 2).getColour(), false);
        grid.setCellInCoordinate(3, 5, true);
        grid.setCellInCoordinate(3, 4, true);
        grid.setCellInCoordinate(3, 2, true);
        checker.turnTilesToDirectionForLegalMove(3, 1, false);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
    }

}
