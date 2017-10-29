package farmyard;

import javafx.scene.paint.Color;

/** An egg that a farmer collects. */
public class Egg extends FarmItem {

  public Egg() {
    super("o", Color.ROSYBROWN);
  }

  int getX() {
    return col;
  }
}
