package othello.slothello.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void startsAsEmpty() {
        Cell cell = new Cell();
        assertEquals(true, cell.isEmpty());
    }

    Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void gettingColourWhenColourNotYetSet() {
        cell.getColour();
    }

    @Test
    public void setWhiteSetsCellAsUsed() {
        cell.setWhite();
        assertEquals(false, cell.isEmpty());
    }

    @Test
    public void setBlackSetsCellAsUsed() {
        cell.setBlack();
        assertEquals(false, cell.isEmpty());
    }

    @Test
    public void setWhiteSetsCellWhite() {
        cell.setWhite();
        assertEquals(true, cell.getColour());
        assertEquals(false, cell.isEmpty());
    }

    @Test
    public void setBlackSetsCellBlack() {
        cell.setBlack();
        assertEquals(false, cell.getColour());
        assertEquals(false, cell.isEmpty());
    }

    @Test
    public void cellGetsCorrectString() {
        assertEquals("_", cell.toString());
        cell.setBlack();
        assertEquals("B", cell.toString());
        cell.setWhite();
        assertEquals("W", cell.toString());
    }

}
