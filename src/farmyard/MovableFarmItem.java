package farmyard;

import javafx.scene.paint.Color;

public class MovableFarmItem extends FarmItem{
    /** Indicates whether this Chicken is moving right. */
    protected boolean goingRight;

    public MovableFarmItem(String appearance, Color colour){
        super(appearance, colour);
        goingRight = true;
    }

    public void move() {

    }

    /** Turns this pig around, causing it to reverse direction. */
    protected void turnAround() {
        goingRight = !goingRight;
        appearance = reverseAppearance();
    }

    /** Build and initialize this Pig's forward and backward appearances. */
    private String reverseAppearance() {
        StringBuilder reverse = new StringBuilder();
        for (int i = appearance.length() - 1; i >= 0; i--) {
            char current = appearance.charAt(i);
            switch (current) {
                case '\\':
                    current = '/';
                    break;
                case '/':
                    current = '\\';
                    break;
                case ')':
                    current = '(';
                    break;
                case '(':
                    current = ')';
                    break;
                case '>':
                    current = '<';
                    break;
                case '<':
                    current = '>';
                    break;
                case '}':
                    current = '{';
                    break;
                case '{':
                    current = '}';
                    break;
                case '[':
                    current = ']';
                    break;
                case ']':
                    current = '[';
                    break;
                default:
                    break;
            }
            reverse.append(current);
        }

        return reverse.toString();
    }
}
