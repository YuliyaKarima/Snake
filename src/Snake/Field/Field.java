package Snake.Field;

import Snake.Snake.Coordinate;

/**
 * Encapsulates parameter of the field as a two-dimension array of int numbers
 */
public class Field {
    private int[][] field;

    public Field(int size) {
        field = new int[size][size];
    }

    /**
     * Checks if given coordinate on the field is free
     *
     * @param c Coordinate object
     * @return true if given coordinate in the filed is free
     */
    public boolean isNextFree(Coordinate c) {
        if (c.getX() > field.length - 1
                || c.getY() > field.length - 1
                || c.getX() < 0
                || c.getY() < 0)
            return true;
        else
            return (field[c.getX()][c.getY()] == 0);
    }

    /**
     * Checks if given coordinates in the field are free.
     *
     * @param c varargs Coordinate object
     * @return true if all the given coordinates in the field are free
     */
    public boolean isFreeArea(Coordinate... c) {
        int count = 0;
        for (Coordinate coordinate : c) {
            if (isNextFree(coordinate)) {
                count++;
            }
        }
        return (count == c.length);
    }

    /**
     * 'Print' given coordinate (sets value 1)
     *
     * @param c Coordinate object
     */
    public void fillCell(Coordinate c) {
        field[c.getX()][c.getY()] = 1;
    }

    /**
     * Outputs field's array state on the console
     */
    public void print() {
        for (int i = 0; i < field.length; i++) {
            for (int z = 0; z < field.length; z++) {
                System.out.print(field[i][z]);
            }
            System.out.println();
        }
    }

    /**
     * returns field size
     */
    public int fieldSize() {
        return field.length;
    }

    /**
     * Checks if the given coordinate is up border of the field
     *
     * @param c Coordinate object
     * @return true if given coordinate if up border of the field
     */
    public boolean isUpBorder(Coordinate c) {
        return (c.getX() == 0);
    }

    /**
     * Checks if the given coordinate is down border of the field
     *
     * @param c Coordinate object
     * @return true if given coordinate if down border of the field
     */
    public boolean isDownBorder(Coordinate c) {
        return (c.getX() == fieldSize() - 1);
    }

    /**
     * Checks if the given coordinate is right border of the field
     *
     * @param c Coordinate object
     * @return true if given coordinate if right border of the field
     */
    public boolean isRightBorder(Coordinate c) {
        return (c.getY() == fieldSize() - 1);
    }

    /**
     * Checks if the given coordinate is left border of the field
     *
     * @param c Coordinate object
     * @return true if given coordinate if left border of the field
     */
    public boolean isLeftBorder(Coordinate c) {
        return (c.getY() == 0);
    }

}