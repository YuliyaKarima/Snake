package Snake.Direction;

import Snake.Field.Field;
import Snake.Snake.Snake;

/**
 * Manages snake's motion on the field
 */
public abstract class Direction {
    protected Snake snake;
    protected Field field;

    public Direction(Snake snake, Field field) {
        this.snake = snake;
        this.field = field;
    }

    /**
     * Imitates snake motion on the field
     */
    public void moveSnake() {
        field.fillCell(snake.getCurrentPosition());
        while (snake.isGoing()) {
            if (!isOppositeBorder()) {
                if (isNextFree()) {
                    pushSnake();
                    if (!isOppositeBorder()) {
                        field.fillCell(snake.getCurrentPosition());
                    }
                } else {
                    field.fillCell(snake.getCurrentPosition());
                    turnSnake();
                }
            } else {
                field.fillCell(snake.getCurrentPosition());
                turnSnake();
            }
        }
    }

    /**
     * turn snake vertically or stop if there is no free way for snake to go
     */
    public void turnVertically() {
        if (field.isUpBorder(snake.getCurrentPosition())) {
            if (isNextDownFree()) {
                snake.turnDown();
            } else {
                snake.stop();
            }
        } else if (field.isDownBorder(snake.getCurrentPosition())) {
            if (isNextUpFree()) {
                snake.turnUp();
            } else {
                snake.stop();
            }
        } else if (isNextDownFree()) {
            snake.turnDown();
        } else if (isNextUpFree()) {
            snake.turnUp();
        } else {
            snake.stop();
        }
    }

    /**
     * turn snake horizontally or stop if there is no free way for snake to go
     */
    public void turnHorizontally() {
        if (field.isLeftBorder(snake.getCurrentPosition())) {
            if (isNextRightFree()) {
                snake.turnRight();
            } else {
                snake.stop();
            }
        } else if (field.isRightBorder(snake.getCurrentPosition())) {
            if (isNextLeftFree()) {
                snake.turnLeft();
            } else {
                snake.stop();
            }
        } else if (isNextLeftFree()) {
            snake.turnLeft();
        } else if (isNextRightFree()) {
            snake.turnRight();
        } else {
            snake.stop();
        }
    }

    /**
     * checks if current snake position is opposite border of the field
     *
     * @return true if current snake position is opposite border of the field relatively to the direction
     */
    public abstract boolean isOppositeBorder();

    /**
     * turns snake
     */
    public abstract void turnSnake();

    /**
     * checks if next to the snake area in the field is free
     *
     * @return true if next to the snake area in the field is free
     */
    public abstract boolean isNextFree();

    /**
     * checks if next right to the snake area in the field is free
     *
     * @return true if next right to the snake area in the field is free
     */
    public boolean isNextRightFree() {
        return field.isFreeArea(snake.nextRight(1), snake.nextRight(2),
                snake.nextDownRightShift(1, 1), snake.nextDownRightShift(1, 2),
                snake.nextUpRightShift(1, 1), snake.nextUpRightShift(1, 2));
    }

    /**
     * checks if next left to the snake area in the field is free
     *
     * @return true if next left to the snake area in the field is free
     */
    public boolean isNextLeftFree() {
        return field.isFreeArea(snake.nextLeft(1), snake.nextLeft(2),
                snake.nextDownLeftShift(1, 1), snake.nextDownLeftShift(1, 2),
                snake.nextUpLeftShift(1, 1), snake.nextUpLeftShift(1, 2));
    }

    /**
     * checks if next down to the snake area in the field is free
     *
     * @return true if next down to the snake area in the field is free
     */
    public boolean isNextDownFree() {
        return field.isFreeArea(snake.nextDown(1), snake.nextDown(2),
                snake.nextDownLeftShift(1, 1), snake.nextDownLeftShift(2, 1),
                snake.nextDownRightShift(1, 1), snake.nextDownRightShift(2, 1));
    }

    /**
     * checks if next up to the snake area in the field is free
     *
     * @return return true if next up to the snake area in the field is free
     */
    public boolean isNextUpFree() {
        return field.isFreeArea(snake.nextUp(1), snake.nextUp(2),
                snake.nextUpLeftShift(1, 1), snake.nextUpLeftShift(2, 1),
                snake.nextUpRightShift(1, 1), snake.nextUpRightShift(2, 1));
    }

    /**
     * moves snake to next cell of the field
     */
    public abstract void pushSnake();
}
