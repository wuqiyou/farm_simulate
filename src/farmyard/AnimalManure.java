package farmyard;

import javafx.scene.paint.Color;

public class AnimalManure extends FarmItem {

  /** The apperance of the feces. */
  static String manure_appearnce = ".";
  
  public AnimalManure() {
    super(".", Color.BLACK.darker().darker().darker());
  }
}
