package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FarmItem {
    /** How this item appears on the screen. */
    private String appearance;
    /** My colour. Ah, the vagaries of British vs. US spelling. */
    private Color colour;
    /** The row number of this item's cursor location.*/
    protected int row;
    /** The column number of this item's cursor location.*/
    protected int col;

    public FarmItem(String appearance, Color colour){
        this.appearance = appearance;
        this.colour = colour;
    }

    /**
     * Set this item's location.
     *
     * @param row the row number of location.
     * @param col the column number of location.
     */
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Draws this farm pen item.
     *
     * @param g the graphics context in which to draw this item.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.fillText(appearance, col * 10, row * 6);
    }
}
