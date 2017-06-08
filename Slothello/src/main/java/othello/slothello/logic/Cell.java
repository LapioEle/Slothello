package othello.slothello.logic;

/**
 * Luokka mahdollistaa ruudun värin asettamisen ja lisäksi sen aseman
 * tarkistamisen.
 */
public class Cell {

    //true is empty
    private boolean empty;
    //true is "white", false is "black"
    private boolean colour;

    public Cell() {
        empty = true;
    }

    public void setWhite() {
        if (empty = true) {
            empty = false;
        }
        colour = true;
    }

    public void setBlack() {
        if (empty = true) {
            empty = false;
        }
        colour = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean getColour() {
        return colour;
    }

    @Override
    public String toString() {
        if (empty) {
            return "_";
        }
        if (colour) {
            return "W";
        } else {
            return "B";
        }
    }
}
