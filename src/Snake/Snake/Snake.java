package Snake.Snake;

import Snake.Direction.*;
import Snake.Field.Field;

/**
 * Encapsulates snake's parameters of current coordinate and direction of travel
 */
public class Snake {
    private Coordinate currentPosition;
    private Coordinate nextPosition = null;
    private Direction currentDirection;
    private boolean isGoing;
    private Field field;
    private Direction rightDirection;
    private Direction leftDirection;
    private Direction downDirection;
    private Direction upDirection;

    public Snake(int x, int y, Field field) {
        this.field = field;
        currentPosition = new Coordinate(x, y);
        isGoing = true;
        rightDirection = new RightDirection(this, field);
        leftDirection = new LeftDirection(this, field);
        downDirection = new DownDirection(this, field);
        upDirection = new UpDirection(this, field);
    }

    /**
     * delegates snake motion on the field to snake's current direction
     */
    public void go() {
        currentDirection.moveSnake();
    }

    /**
     * change current direction to down direction
     */
    public void turnDown() {
        setCurrentDirection(downDirection);
        go();
    }

    /**
     * change current direction to left direction
     */
    public void turnLeft() {
        setCurrentDirection(leftDirection);
        go();
    }

    /**
     * change current direction to up direction
     */
    public void turnUp() {
        setCurrentDirection(upDirection);
        go();
    }

    /**
     * change current direction to right direction
     */
    public void turnRight() {
        setCurrentDirection(rightDirection);
        go();
    }

    public int getX() {
        return currentPosition.getX();
    }

    public int getY() {
        return currentPosition.getY();
    }


    /**
     * move snake right for a given number of steps
     *
     * @param step value of shift
     */
    public void moveRight(int step) {
        currentPosition.right(step);
    }


    /**
     * move snake left for a given number of steps
     *
     * @param step value of shift
     */
    public void moveLeft(int step) {
        currentPosition.left(step);
    }

    /**
     * move snake down for a given number of steps
     *
     * @param step value of shift
     */
    public void moveDown(int step) {
        currentPosition.down(step);
    }

    /**
     * move snake up for a given number of steps
     *
     * @param step value of shift
     */
    public void moveUp(int step) {
        currentPosition.up(step);
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public boolean isGoing() {
        return isGoing;
    }

    public Coordinate getCurrentPosition() {
        Coordinate coordinate = new Coordinate(currentPosition.getX(), currentPosition.getY());
        return coordinate;
    }

    /**
     * stop snake's motion
     */
    public void stop() {
        isGoing = false;
    }

    /**
     * return right shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param d value of right shift
     * @return Coordinate object
     */
    public Coordinate nextRight(int d) {
        nextPosition = getCurrentPosition();
        nextPosition.right(d);
        return nextPosition;
    }

    /**
     * return left shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param d value of left shift
     * @return Coordinate object
     */
    public Coordinate nextLeft(int d) {
        nextPosition = getCurrentPosition();
        nextPosition.left(d);
        return nextPosition;
    }

    /**
     * return up shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param d value of up shift
     * @return Coordinate object
     */
    public Coordinate nextUp(int d) {
        nextPosition = getCurrentPosition();
        nextPosition.up(d);
        return nextPosition;
    }

    /**
     * return down up shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param d value of  down shift
     * @return Coordinate object
     */
    public Coordinate nextDown(int d) {
        nextPosition = getCurrentPosition();
        nextPosition.down(d);
        return nextPosition;
    }

    /**
     * return right down shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param a value of  down shift
     * @param b value of  right shift
     * @return Coordinate object
     */
    public Coordinate nextDownRightShift(int a, int b) {
        nextPosition = getCurrentPosition();
        nextPosition.rightDownShift(a, b);
        return nextPosition;
    }

    /**
     * return left down shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param a value of  down shift
     * @param b value of  left shift
     * @return Coordinate object
     */
    public Coordinate nextDownLeftShift(int a, int b) {
        nextPosition = getCurrentPosition();
        nextPosition.leftDownShift(a, b);
        return nextPosition;
    }

    /**
     * return left up shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param a value of up shift
     * @param b value of left shift
     * @return Coordinate object
     */
    public Coordinate nextUpLeftShift(int a, int b) {
        nextPosition = getCurrentPosition();
        nextPosition.leftUpShift(a, b);
        return nextPosition;
    }

    /**
     * return right up shift coordinate relatively to the current ccordinate for a given number of steps
     *
     * @param a value of up shift
     * @param b value of right shift
     * @return Coordinate object
     */
    public Coordinate nextUpRightShift(int a, int b) {
        nextPosition = getCurrentPosition();
        nextPosition.rightUpShift(a, b);
        return nextPosition;
    }

    public String toString() {
        return getX() + " " + getY();
    }

    public Direction getRightDirection() {
        return rightDirection;
    }

    public Direction getLeftDirection() {
        return leftDirection;
    }

    public Direction getDownDirection() {
        return downDirection;
    }

    public Direction getUpDirection() {
        return upDirection;
    }

    /**
     * outputs snake path on the field to the console
     */
    public void printPath() {
        field.print();
    }
}
