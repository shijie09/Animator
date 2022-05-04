package cs5004.animator.model;

/**
 * This is a superclass of AbstractShape.
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructor of a rectangle shape.
   *
   * @param x             the x coordinate of the rectangle.
   * @param y             the x coordinate of the rectangle.
   * @param width         the width of the shape.
   * @param height        the height of the shape.
   * @param r             the red value of the shape color.
   * @param g             the green value of the shape color.
   * @param b             the blue value of the shape color.
   * @param uniqueCode    the only unique code of the shape.
   * @param appearTime    the appear time of  the shape.
   * @param disappearTime the disappear time of the shape.
   */
  public Rectangle(int x, int y, int width, int height, int r, int g, int b, String uniqueCode,
      int appearTime, int disappearTime) {
    super(x, y, width, height, r, g, b, uniqueCode, appearTime, disappearTime);
    this.shapeType = Shapes.RECTANGLE;
  }

  /**
   * It is a constructor of rectangle.
   * @param uniqueCode the only unique code of the shape.
   */
  public Rectangle(String uniqueCode) {
    this.uniqueCode = uniqueCode;
    this.shapeType = Shapes.RECTANGLE;
  }

  /**
   * Make a copy of the shape.
   *
   * @return a copy of the shape.
   */
  @Override
  public ShapeInterface makeACopy() {
    return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getR(),
        this.getG(), this.getB(),
        this.getUniqueCode(), this.getAppearTime(), this.getDisappearTime());
  }


}
