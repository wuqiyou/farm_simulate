package farmyard;

import javafx.scene.paint.Color;

public class Chicken extends FarmItem {
  /** Indicates whether this Chicken is moving right. */
  boolean goingRight;
  /** Constructs a new Chicken. */

  public Chicken() {
    super("/'/>", Color.RED);
    goingRight = true;
  }

  /** Set this item's location. */
  public static Egg aneggishere() {
    for (int r = 0; r != Human.myFarmAnimals.length; r++)
      for (int c = 0; c != Human.myFarmAnimals[0].length; c++)
        if (Human.myFarmAnimals[r][c] instanceof Egg) return (Egg) Human.myFarmAnimals[r][c];
    return null;
  }

  /** Build and initialize this Chicken's forward and backward appearances. */
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

  /** Turns this fish around, causing it to reverse direction. */
  protected void turnAround() {
    goingRight = !goingRight;
    if (goingRight) {
      appearance = reverseAppearance();
    } else {
      appearance = reverseAppearance();
    }
  }

  /** Causes this item to take its turn in the farm-pen simulation. */
  public void move() {

    // Sometimes food doesn't sit well in the stomach, so I have to clear my stomach
    double d1 = Math.random();
    if (d1 < 0.2) {
      digest();
    }

    // Move one spot to the right or left.
    if (goingRight) {
      col += 1;
    } else {
      col -= 1;
    }

    // Every now and then lay an egg.
    double d2 = Math.random();
    if (d1 < 0.1) {
      layEgg();
    }

    double d3 = Math.random();
    if (d1 < 0.1) {
      turnAround();
    }
  }

  /** Lay an egg. */
  private void layEgg() {
    System.out.println("Breakfast! " + "Egg loc: " + col + " " + row);
    Egg egg = new Egg();
    egg.setLocation(col, row);

    Human.myFarmAnimals[col][row] = egg;
  }

  /**
   * Finish digesting
   *
   * @return
   */
  private final boolean digest() {
    System.out.println("New stuff to make things grow.");

    AnimalManure getTheScoop = new AnimalManure(".");
    getTheScoop.setLocation(col, row);

    Human.myFarmAnimals[row][col] = getTheScoop;

    return true;
  }
}
