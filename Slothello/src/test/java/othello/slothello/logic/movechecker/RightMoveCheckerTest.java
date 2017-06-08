package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class RightMoveCheckerTest {

    public RightMoveCheckerTest() {
    }

    Grid grid;
    RightMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new RightMoveChecker(grid);
    }

    @Test
    public void colouredCellsRightCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 2, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 2, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 3, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(1, 3, true), false);
    }

    @Test
    public void emptyCellToRightRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 0, false), true);
    }

    @Test
    public void cellToRightOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 2, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 3, false), true);
    }

    @Test
    public void goToRightUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, true);
        assertEquals(i[0], 3);
        assertEquals(i[1], 3);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 2, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 2);
    }

    @Test
    public void goToRightUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 2, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(3, 4, false), null);
    }

    @Test
    public void goToRightUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(4, 2, true);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 2, true);
        assertEquals(i[0], 4);
        assertEquals(i[1], 2);
        grid.setCellInCoordinate(2, 3, true);
        grid.setCellInCoordinate(4, 3, false);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(1, 3, false);
        assertEquals(i[0], 4);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToRightUntilBorderFound() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(4, 2, false);
        grid.setCellInCoordinate(5, 2, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(1, 2, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        checker.turnTilesToDirectionForLegalMove(1, 2, false);
        assertEquals(grid.getCellInCoordinate(2, 2).getColour(), false);
        grid.setCellInCoordinate(5, 3, true);
        grid.setCellInCoordinate(4, 3, true);
        grid.setCellInCoordinate(2, 3, true);
        checker.turnTilesToDirectionForLegalMove(1, 3, false);
        assertEquals(grid.getCellInCoordinate(2, 3).getColour(), true);
    }

}
