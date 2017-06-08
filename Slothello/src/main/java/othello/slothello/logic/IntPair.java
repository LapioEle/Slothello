package othello.slothello.logic;

/**
 * Luokka, johon pystyy asettamaan kaksi kokonaislukua ja ottamaan ne pois jotta
 * toisen luokan metodit voivat palauttaa kaksi kokonaislukua.
 */
public class IntPair {

    private int x;
    private int y;

    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int giveX() {
        return x;
    }

    public int giveY() {
        return y;
    }

}
