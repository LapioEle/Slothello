package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class UpRightMoveCheckerTest {

    public UpRightMoveCheckerTest() {
    }

    Grid grid;
    UpRightMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new UpRightMoveChecker(grid);
    }

    @Test
    public void colouredCellsToUpRightCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 4, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 4, true), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 3, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 3, false), false);
    }

    @Test
    public void emptyCellToUpRightRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 5, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 5, false), true);
    }

    @Test
    public void cellToUpRightOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 2, false), true);
    }

    @Test
    public void goToUpRightUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        grid.setCellInCoordinate(2, 3, true);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 4, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 2);
        grid.setCellInCoordinate(3, 1, true);
        grid.setCellInCoordinate(2, 2, false);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, true);
        assertEquals(i[0], 3);
        assertEquals(i[1], 1);
    }

    @Test
    public void goToUpRightUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 4, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 5, false), null);
    }

    @Test
    public void goToUpRightUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(4, 1, true);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 4, true);
        assertEquals(i[0], 4);
        assertEquals(i[1], 1);
        grid.setCellInCoordinate(3, 1, true);
        grid.setCellInCoordinate(4, 0, false);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, false);
        assertEquals(i[0], 4);
        assertEquals(i[1], 0);
    }

    @Test
    public void goToUpRightUntilBorderFound() {
        grid.setCellInCoordinate(4, 1, false);
        grid.setCellInCoordinate(5, 0, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 4, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        grid.setCellInCoordinate(3, 1, false);
        checker.turnTilesToDirectionForLegalMove(1, 3, false);
        assertEquals(grid.getCellInCoordinate(2, 2).getColour(), false);
        grid.setCellInCoordinate(4, 1, true);
        checker.turnTilesToDirectionForLegalMove(1, 4, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
    }

}
