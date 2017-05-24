package othello.slothello.logic;

/**
 *
 * @author Eelis
 */
public class Cell {
    
    //true is empty
    private boolean empty;
    //true is "white", false is "black"
    private boolean colour;
    
    public Cell() {
        empty = true;
    }
    
    public boolean setWhite() {
        if (empty = true) {
            empty = false;
        }
        colour = true;
        return true;
    }
    
    public boolean setBlack() {
        if (empty = true) {
            empty = false;
        }
        colour = false;
        return true;
    }
    
    public boolean isEmpty() {
        return empty;
    }
    
    public boolean getColour() {
        return colour;
    }
    
}
