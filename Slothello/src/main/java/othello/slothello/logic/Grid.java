package othello.slothello.logic;

/**
 * Luokka on ruudukko, jossa pystyy vaihtamaan tietyssä koordinaatissa olevien
 * ruutujen tietojen muuttamista ja tarkistamista .
 */
public class Grid {

    private Cell[][] cells;
    private int side;

    /**
     * Metodi luo uuden ruudukon, johon on laitettu 2 mustaa ja 2 valkoista
     * nappulaa keskelle ruudukkoa aloitus asemiin.
     *
     * @param side ruudukon koko. Eri kokoisia testausta varten. Aina 8 pelissä
     */
    public Grid(int side) {

        if (side < 4) {
            side = 4;
        }
        if (side % 2 != 0) {
            side++;
        }
        this.side = side;
        cells = new Cell[side][side];
        setUpGrid();
    }

    public Integer getBottomRightCenterCell() {
        return side / 2;
    }

    public void setUpGrid() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells.length; y++) {
                cells[x][y] = new Cell();
            }
        }
        setUpCenter();
    }

    /**
     * Metodi asettaa 4 nappulaa keskelle lautaa. Valkoiset menevät vasemmasta
     * yläkulmasta alaoikealle menevälle lävistäjälle ja mustat toiselle
     * lävistäjälle.
     */
    public void setUpCenter() {
        int x = getBottomRightCenterCell();
        int y = x;
        cells[x][y].setWhite();
        cells[x - 1][y - 1].setWhite();
        cells[x - 1][y].setBlack();
        cells[x][y - 1].setBlack();
    }

    public void printGrid() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String grid = "";
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells.length; x++) {
                grid = grid + cells[x][y].toString() + " ";
            }
            grid = grid + "\n";
        }
        return grid;
    }

    /**
     * Metodi palauttaa annettussa koordinaatissa olevan ruudun.
     *
     * @param x leveyskoordinaatti
     * @param y korkeuskoordinaatti
     *
     * @return koordinaatissa ollut ruutu
     */
    public Cell getCellInCoordinate(int x, int y) {
        return cells[x][y];
    }

    /**
     * Metodi asettaa annetussa koordinaatissa olevan ruudun värin haluttuun.
     *
     * @param x leveyskoordinaatti
     * @param y korkeuskoordinaatti
     * @param a asetettava väri. True valkoinen, false musta
     *
     */
    public void setCellInCoordinate(int x, int y, boolean a) {
        if (a) {
            cells[x][y].setWhite();
        } else {
            cells[x][y].setBlack();
        }
    }

    public boolean isCellInCoordinateEmptyOrSameColour(int x, int y, boolean a) {
        Cell cell = cells[x][y];
        if (cell.isEmpty()) {
            return true;
        } else {
            return cell.getColour() == a;
        }
    }

    public boolean isCellInCoordinateSameColour(int x, int y, boolean a) {
        Cell cell = cells[x][y];
        if (cell.isEmpty()) {
            return false;
        } else {
            return cell.getColour() == a;
        }
    }

    public int getGridSizeMinusOne() {
        return side - 1;
    }
}
