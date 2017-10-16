package Snake.Direction;

import Snake.Field.Field;
import Snake.Snake.Snake;

/**
 * Extends Direction class for down direction of snake's travel
 */
public class DownDirection extends Direction {

    public DownDirection(Snake snake, Field field) {
        super(snake, field);
    }

    @Override
    public void turnSnake() {
        turnHorizontally();
    }

    @Override
    public boolean isOppositeBorder() {
        return field.isDownBorder(snake.getCurrentPosition());
    }

    @Override
    public boolean isNextFree() {
        return isNextDownFree();
    }

    @Override
    public void pushSnake() {
        snake.moveDown(1);
    }
}