package Snake.SnakeTest;

import Snake.Field.Field;
import Snake.Snake.Snake;

import java.util.Scanner;

/**
 * Tests snake motion on an array
 */
public class SnakeTest {
    private Snake snake;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SnakeTest test = new SnakeTest();
        test.setUpSnake();
        test.moveSnake();
    }

    /**
     * Initializes snake by user-input parameters from console
     */
    public void setUpSnake() {
        int fieldSize;
        do {
            System.out.println("Enter field size: ");
            fieldSize = sc.nextInt();
            if (fieldSize <= 0) {
                System.out.println("Field  size cannot be negative or equals to zero");
            }
        } while (fieldSize < 0);
        Field field = new Field(fieldSize);
        int x;
        int y;
        do {
            System.out.println("Enter initial ccordinates: from 0 to " + fieldSize);
            x = sc.nextInt();
            y = sc.nextInt();
            if (x < 0 || y < 0 || x > fieldSize || y > fieldSize) {
                System.out.println("Input coordinates are wrong. Try again");
            }
        } while (x < 0 || y < 0 || x > fieldSize || y > fieldSize);
        snake = new Snake(x, y, field);
        setUpSnakeDirection();
    }

    /**
     * Offer user to enter an option of direction and set direction to the snake
     */
    private void setUpSnakeDirection() {
        System.out.println("Select dorection option(1-4): ");
        System.out.println("1. Right");
        System.out.println("2. Left");
        System.out.println("3. Down");
        System.out.println("4. Up");
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            num = sc.nextInt();
            switch (num) {
                case (1):
                    snake.setCurrentDirection(snake.getRightDirection());
                    break;
                case (2):
                    snake.setCurrentDirection(snake.getLeftDirection());
                    break;
                case (3):
                    snake.setCurrentDirection(snake.getDownDirection());
                    break;
                case (4):
                    snake.setCurrentDirection(snake.getUpDirection());
                    break;
                default:
                    System.out.println("Option is wrong. Try again");
            }
        } while (num > 4 || num < 0);
    }

    /**
     * Starts snake movement and outputs on the console field's array
     */
    public void moveSnake() {
        snake.go();
        snake.printPath();
    }
}