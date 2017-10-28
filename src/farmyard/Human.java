package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** A Human */
public class Human extends MovableFarmItem {

  /** (int)(640/6) columns, (int)(480/10) rows. */
  public static Object[][] myFarmAnimals = new Object[(int) (480 / 10)][(int) (640 / 6)];
  /** Indicates whether this human is moving right. */
  boolean goingRight;

  private ArrayList<Egg> myBasket = new ArrayList<Egg>();

  private GraphicsContext g;

  /** The animal food the human is feeding his/her beloved animals. */
  static final String thing = ".";

  /** Constructs a new Human. */
  public Human() {
    super("human", Color.SANDYBROWN.darker());
    goingRight = true;
  }

  /** Causes human to drop down 4 piece s of food all around. */
  protected void dropFood() {
    AnimalFood fooood = new AnimalFood();
    fooood.setLocation(col - 1, row - 1);
    myFarmAnimals[row - 1][col - 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(col - 1, row + 1);
    myFarmAnimals[row + 1][col - 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(col + 1, row - 1);
    myFarmAnimals[row - 1][col + 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(col + 1, row + 1);
    myFarmAnimals[row + 1][col + 1] = fooood;
  }

  /**
   * Draws this farm pen item.
   *
   * @param g the graphics context in which to draw this item.
   */
  public void draw(GraphicsContext g) {
    super.draw(g);
    this.g = g;
    g.fillText("Eggs: " + myBasket.size(), 2 * 10, 2 * 6);
  }

  Egg target = null;

  /** Causes this item to take its turn in the farm-pensimulation. */
  public void move() {

    if (target == null) {
      target = Chicken.aneggishere();
    }

    if (target != null) {
      System.out.println(
          "Target acquired: " + target.getX() + " " + target.row + "| Me: " + col + " " + row);
      // Am I on an egg?
      if (row == target.getX() && col == target.row) {
        System.out.println("Egg!");
        this.myBasket.add(target);
        target = null;
        if (myBasket.size() % 12 == 0) {
          System.out.println("Dozen!");
          g.fillText("Eggs: " + myBasket.size(), 1 * 10, 1 * 6);
        }

      } else {

        // move toward the egg
        if (row < target.getX()) {
          row += 1;
        } else {
          row -= 1;
        }
        if (col < target.row) {
          col += 1;
        } else {
          col -= 1;
        }
      }
    } else // no egg to pick up
    // Move one spot to the right or left.
    if (goingRight) {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        row += 1;
      } else if (d < 0.2) {
        row -= 1;
      }
      col += 1;
    } else {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        row += 1;
      } else if (d < 0.2) {
        row -= 1;
      }
      col -= 1;
    }

    // Figure out whether I should drop food.
    double d = Math.random();
    if (d < 0.05) {
      dropFood();
    }

    // Figure out whether I turn around.
    d = Math.random();
    if (d < 0.1) {
      turnAround();
    }
  }
}
