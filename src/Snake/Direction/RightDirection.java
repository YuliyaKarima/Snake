package Snake.Direction;

import Snake.Field.Field;
import Snake.Snake.Snake;

/**
 * Extends Direction class for right direction of snake's travel
 */
public class RightDirection extends Direction {

    public RightDirection(Snake snake, Field field) {
        super(snake, field);
    }

    @Override
    public boolean isOppositeBorder() {
        return field.isRightBorder(snake.getCurrentPosition());
    }

    @Override
    public boolean isNextFree() {
        return isNextRightFree();
    }

    @Override
    public void pushSnake() {
        snake.moveRight(1);
    }

    @Override
    public void turnSnake() {
        turnVertically();
    }
}
