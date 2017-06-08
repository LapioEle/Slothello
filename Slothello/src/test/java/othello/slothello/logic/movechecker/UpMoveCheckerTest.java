package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class UpMoveCheckerTest {

    public UpMoveCheckerTest() {
    }

    Grid grid;
    UpMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new UpMoveChecker(grid);
    }

    @Test
    public void colouredCellsToUpCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 4, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 4, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 4, true), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 4, false), true);
    }

    @Test
    public void emptyCellToUpRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 1, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 1, false), true);
    }

    @Test
    public void cellToUpOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 0, false), true);
    }

    @Test
    public void goToUpUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(2, 4, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 2);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(3, 4, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 2);
    }

    @Test
    public void goToUpUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(2, 4, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(3, 4, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false), null);
    }

    @Test
    public void goToUpUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(2, 4, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(2, 5, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 2);
        grid.setCellInCoordinate(3, 4, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(3, 5, false);
        assertEquals(i[0], 3);
        assertEquals(i[1], 2);
    }

    @Test
    public void goToUpUntilBorderFound() {
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(2, 1, false);
        grid.setCellInCoordinate(2, 0, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(2, 4, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        checker.turnTilesToDirectionForLegalMove(2, 4, true);
        assertEquals(grid.getCellInCoordinate(2, 3).getColour(), true);
        grid.setCellInCoordinate(3, 1, false);
        grid.setCellInCoordinate(3, 0, false);
        grid.setCellInCoordinate(3, 3, false);
        checker.turnTilesToDirectionForLegalMove(3, 4, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), false);
    }

}
