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
    public void sameColouredCellToLeftFound() {
        othello = new Othello();
        //to do
    }
    
}
