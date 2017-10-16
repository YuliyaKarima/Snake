package Snake.Snake;

/**
 * Encapsulates parameters of two-dimensional coordinate x and y
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * increase y-coordinate on 'step' value
     *
     * @param step value of shift
     */
    public void right(int step) {
        y += step;
    }

    /**
     * decrease y-ccordinate on 'step' value
     *
     * @param step value of shift
     */
    public void left(int step) {
        y -= step;
    }


    /**
     * increases x-ccordinate on 'step' value
     *
     * @param step value of shift
     */
    public void down(int step) {
        x += step;
    }

    /**
     * decreases x-ccordinate on 'step' value
     *
     * @param step value of shift
     */
    public void up(int step) {
        x -= step;
    }

    /**
     * sets right down shift of coordinate on 'step' value
     *
     * @param stepDown  value of down shift
     * @param stepRight value of right shift
     */
    public void rightDownShift(int stepDown, int stepRight) {
        down(stepDown);
        right(stepRight);
    }

    /**
     * sets right up shift of coordinate on 'step' value
     *
     * @param stepUp    value of up shift
     * @param stepRight value of right shift
     */
    public void rightUpShift(int stepUp, int stepRight) {
        up(stepUp);
        right(stepRight);
    }

    /**
     * sets left down shift of coordinate on 'step' value
     *
     * @param stepDown value of down shift
     * @param stepLeft value of left shift
     */
    public void leftDownShift(int stepDown, int stepLeft) {
        down(stepDown);
        left(stepLeft);
    }

    /**
     * sets left up shift of coordinate on 'step' value
     *
     * @param stepUp   value of up shift
     * @param stepLeft value of left shift
     */
    public void leftUpShift(int stepUp, int stepLeft) {
        up(stepUp);
        left(stepLeft);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
}
