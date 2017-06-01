package othello.slothello.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {

    public GridTest() {
    }

    @Test
    public void newGrid4by4() {
        Grid grid = new Grid(4);
        assertEquals(grid.toString(), "_ _ _ _ \n"
                + "_ W B _ \n"
                + "_ B W _ \n"
                + "_ _ _ _ \n");
    }

    @Test
    public void newGrid2by2() {
        Grid grid = new Grid(2);
        assertEquals(grid.toString(), "_ _ _ _ \n"
                + "_ W B _ \n"
                + "_ B W _ \n"
                + "_ _ _ _ \n");
    }

    @Test
    public void newGrid3by3() {
        Grid grid = new Grid(3);
        assertEquals(grid.toString(), "_ _ _ _ \n"
                + "_ W B _ \n"
                + "_ B W _ \n"
                + "_ _ _ _ \n");
    }

    @Test
    public void newGrid5by5() {
        Grid grid = new Grid(5);
        assertEquals(grid.toString(), "_ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ \n"
                + "_ _ W B _ _ \n"
                + "_ _ B W _ _ \n"
                + "_ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ \n");
    }

    @Test
    public void newGrid8by8() {
        Grid grid = new Grid(8);
        assertEquals(grid.toString(), "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ W B _ _ _ \n"
                + "_ _ _ B W _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n");
    }

    @Test
    public void newGrid7by7() {
        Grid grid = new Grid(7);
        assertEquals(grid.toString(), "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ W B _ _ _ \n"
                + "_ _ _ B W _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n"
                + "_ _ _ _ _ _ _ _ \n");
    }

    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(4);
    }

    @Test
    public void getCellInCoordinateReturnsRightValues() {
        Cell cell = grid.getCellInCoordinate(0, 0);
        assertEquals(cell.toString(), "_");
        cell = grid.getCellInCoordinate(1, 1);
        assertEquals(cell.toString(), "W");
        cell = grid.getCellInCoordinate(1, 2);
        assertEquals(cell.toString(), "B");
    }

    @Test
    public void setCellInCoordinateSetsCorrectly() {
        Cell cell = grid.getCellInCoordinate(0, 0);
        assertEquals(cell.toString(), "_");
        grid.setCellInCoordinate(0, 0, true);
        cell = grid.getCellInCoordinate(0, 0);
        assertEquals(cell.toString(), "W");
        grid.setCellInCoordinate(3, 3, false);
        cell = grid.getCellInCoordinate(3, 3);
        assertEquals(cell.toString(), "B");
        grid.setCellInCoordinate(3, 3, true);
        assertEquals(grid.getCellInCoordinate(3, 3).toString(), "W");
    }

    @Test
    public void isCellInCoordinateEmptyOrSameColourDetectsCorrectly() {
        assertEquals(grid.isCellInCoordinateEmptyOrSameColour(0, 0, true), true);
        assertEquals(grid.isCellInCoordinateEmptyOrSameColour(1, 1, true), true);
        assertEquals(grid.isCellInCoordinateEmptyOrSameColour(1, 2, true), false);
    }
}
