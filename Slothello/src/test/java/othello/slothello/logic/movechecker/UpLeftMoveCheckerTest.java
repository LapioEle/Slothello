package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class UpLeftMoveCheckerTest {

    public UpLeftMoveCheckerTest() {
    }

    Grid grid;
    UpLeftMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new UpLeftMoveChecker(grid);
    }

    @Test
    public void colouredCellsToUpLeftCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 4, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 4, false), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, true), false);
    }

    @Test
    public void emptyCellToUpLeftRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 5, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(5, 5, false), true);
    }

    @Test
    public void cellToUpLeftOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 0, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 2, false), true);
    }

    @Test
    public void goToUpLeftUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        grid.setCellInCoordinate(3, 3, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 4, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 2);
        grid.setCellInCoordinate(2, 1, false);
        grid.setCellInCoordinate(3, 2, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false);
        assertEquals(i[0], 2);
        assertEquals(i[1], 1);
    }

    @Test
    public void goToUpLeftUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 4, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 5, false), null);
    }

    @Test
    public void goToUpLeftUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(1, 1, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 4, false);
        assertEquals(i[0], 1);
        assertEquals(i[1], 1);
        grid.setCellInCoordinate(2, 1, false);
        grid.setCellInCoordinate(1, 0, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 3, true);
        assertEquals(i[0], 1);
        assertEquals(i[1], 0);
    }

    @Test
    public void goToUpLeftUntilBorderFound() {
        grid.setCellInCoordinate(1, 1, true);
        grid.setCellInCoordinate(0, 0, true);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 4, false), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        grid.setCellInCoordinate(2, 1, true);
        checker.turnTilesToDirectionForLegalMove(4, 3, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
        grid.setCellInCoordinate(1, 1, false);
        checker.turnTilesToDirectionForLegalMove(4, 4, false);
        assertEquals(grid.getCellInCoordinate(3, 3).getColour(), false);
    }

}
