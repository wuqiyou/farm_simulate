package farmyard;

import javafx.scene.paint.Color;

public class MovableFarmItem extends FarmItem{
    /** Indicates whether this Chicken is moving right. */
    protected boolean goingRight;

    public MovableFarmItem(String appearance, Color colour){
        super(appearance, colour);
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
        String reverse = "";
        for (int i = appearance.length() - 1; i >= 0; i--) {
            switch (appearance.charAt(i)) {
                case '\\':
                    reverse += '/';
                    break;
                case '/':
                    reverse += '\\';
                    break;
                case ')':
                    reverse += '(';
                    break;
                case '(':
                    reverse += ')';
                    break;
                case '>':
                    reverse += '<';
                    break;
                case '<':
                    reverse += '>';
                    break;
                case '}':
                    reverse += '{';
                    break;
                case '{':
                    reverse += '}';
                    break;
                case '[':
                    reverse += ']';
                    break;
                case ']':
                    reverse += '[';
                    break;
                default:
                    reverse += appearance.charAt(i);
                    break;
            }
        }

        return reverse;
    }
}
