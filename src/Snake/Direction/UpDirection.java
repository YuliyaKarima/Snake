package Snake.Direction;

import Snake.Field.Field;
import Snake.Snake.Snake;


/**
 * Extends Direction class for right direction of snake's travel
 */
public class UpDirection extends Direction {

    public UpDirection(Snake snake, Field field) {
        super(snake, field);
    }

    @Override
    public void turnSnake() {
        turnHorizontally();
    }

    @Override
    public boolean isOppositeBorder() {
        return field.isUpBorder(snake.getCurrentPosition());
    }

    @Override
    public boolean isNextFree() {
        return isNextUpFree();
    }

    @Override
    public void pushSnake() {
        snake.moveUp(1);
    }
}
