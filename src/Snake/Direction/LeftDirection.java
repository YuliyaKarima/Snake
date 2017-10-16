package Snake.Direction;

import Snake.Field.Field;
import Snake.Snake.Snake;

/**
 * Extends Direction class for left direction of snake's travel
 */
public class LeftDirection extends Direction {

    public LeftDirection(Snake snake, Field field) {
        super(snake, field);
    }

    @Override
    public boolean isOppositeBorder() {
        return field.isLeftBorder(snake.getCurrentPosition());
    }

    @Override
    public void turnSnake() {
        turnVertically();
    }

    @Override
    public boolean isNextFree() {
        return isNextLeftFree();
    }

    @Override
    public void pushSnake() {
        snake.moveLeft(1);
    }
}
