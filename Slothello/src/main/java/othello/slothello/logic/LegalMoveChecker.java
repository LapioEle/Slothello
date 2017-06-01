package othello.slothello.logic;

public class LegalMoveChecker {

    private Grid grid;

    public LegalMoveChecker(Grid grid) {
        this.grid = grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean isMoveLegal(int x, int y, boolean a) {
        Cell cell = grid.getCellInCoordinate(x, y);

        if (cell.isEmpty()) {
            if (this.findFirstSameColourToUpLeftForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToUpForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToUpRightForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToRightForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToDownRightForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToDownForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToDownLeftForLegalMove(x, y, a)) {
                return true;
            }
            if (this.findFirstSameColourToLeftForLegalMove(x, y, a)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCellToLeftSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == 0) {
            return true;
        }
        x--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToLeftForLegalMove(int x, int y, boolean a) {
        if (isCellToLeftSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x - 2;
        while (x >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                x--;
            }
        }
        return false;
    }

    public boolean isCellToRightSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == grid.getGridSizeMinusOne()) {
            return true;
        }
        x++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToRightForLegalMove(int x, int y, boolean a) {
        if (isCellToRightSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x + 2;
        while (x <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                x++;
            }
        }
        return false;
    }

    public boolean isCellToUpSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (y == 0) {
            return true;
        }
        y--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToUpForLegalMove(int x, int y, boolean a) {
        if (isCellToUpSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        y = y - 2;
        while (y >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y--;
            }
        }
        return false;
    }

    public boolean isCellToDownSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (y == grid.getGridSizeMinusOne()) {
            return true;
        }
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToDownForLegalMove(int x, int y, boolean a) {
        if (isCellToDownSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        y = y + 2;
        while (y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y++;
            }
        }
        return false;
    }

    public boolean isCellToUpLeftSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == 0 || y == 0) {
            return true;
        }
        x--;
        y--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToUpLeftForLegalMove(int x, int y, boolean a) {
        if (isCellToUpLeftSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x - 2;
        y = y - 2;
        while (x >= 0 || y >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y--;
                x--;
            }
        }
        return false;
    }

    public boolean isCellToUpRightSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == grid.getGridSizeMinusOne() || y == 0) {
            return true;
        }
        x++;
        y--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToUpRightForLegalMove(int x, int y, boolean a) {
        if (isCellToUpRightSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x + 2;
        y = y - 2;
        while (x <= grid.getGridSizeMinusOne() || y >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y--;
                x++;
            }
        }
        return false;
    }

    public boolean isCellToDownRightSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == grid.getGridSizeMinusOne() || y == grid.getGridSizeMinusOne()) {
            return true;
        }
        x++;
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToDownRightForLegalMove(int x, int y, boolean a) {
        if (isCellToDownRightSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x + 2;
        y = y + 2;
        while (x <= grid.getGridSizeMinusOne() || y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y++;
                x++;
            }
        }
        return false;
    }

    public boolean isCellToDownLeftSameColourOrEmptyOrDoesNotExist(int x, int y, boolean a) {
        if (x == 0 || y == grid.getGridSizeMinusOne()) {
            return true;
        }
        x--;
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToDownLeftForLegalMove(int x, int y, boolean a) {
        if (isCellToDownLeftSameColourOrEmptyOrDoesNotExist(x, y, a)) {
            return false;
        }
        x = x - 2;
        y = y + 2;
        while (x >= 0 || y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return true;
            } else {
                y++;
                x--;
            }
        }
        return false;
    }

}
