package farmyard;

import javafx.scene.paint.Color;

public class Pig extends FarmItem {

  /** Indicates whether this Pig is moving right. */
  boolean goingRight;

  /** Constructs a new Pig. */
  public Pig() {
    super(":(8)", Color.PINK.darker().darker().darker());
    goingRight = true;
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

  /** Turns this pig around, causing it to reverse direction. */
  protected void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }

  /** Causes this item to take its turn in the farm-pen simulation. */
  public void move() {

    double d3 = Math.random();
    if (d3 < 0.1) {
      turnAround();
    }

    // Move one spot to the right or left.
    if (goingRight) {
      col += 1;
    } else {
      col -= 1;
    }

    // Sometimes we digest.
    double d = Math.random();
    if (d < 0.2) {
      clearStomach();
    }
  }

  /**
   * Helps animal clear stomach
   *
   * @return
   */
  private final boolean clearStomach() {
    System.out.println("Pig stink");

    AnimalManure newManure = new AnimalManure("*");
    newManure.setLocation(col, row);

    Human.myFarmAnimals[row][col] = newManure;

    return true;
  }
}
