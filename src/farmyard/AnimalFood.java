package farmyard;

import javafx.scene.paint.Color;

/** Animal Food */
public class AnimalFood extends FarmItem {

  /** Use for random movement left and right. */
  public double d;

  public AnimalFood() {
    super("%", Color.GRAY.darker().darker().darker());
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up in
   * this case
   */
  public void blownUp() {
    // Move upwards
    row--;
  }
  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Down
   * in this case
   */
  public void blownDown() {

    // Move downwards
    row++;
  }
  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Left in this case
   */
  public void blownLeft() {

    // Move left.
    col = col - 1;
  }
  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Right in this case
   */
  public void blownRight() {

    // Move right
    col = col + 1;
  }
}
