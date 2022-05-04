package cs5004.animator.model;

/**
 * This is a superclass of AbstractShape.
 */
public class Ellipse extends AbstractShape {


  /**
   * Constructor of oval.
   *
   * @param x             the x coordinate of the ellipse.
   * @param y             the x coordinate of the ellipse.
   * @param width         the width of the shape.
   * @param height        the height of the shape.
   * @param r             the red value of the shape color.
   * @param g             the green value of the shape color.
   * @param b             the blue value of the shape color.
   * @param uniqueCode    the only unique code of the shape.
   * @param appearTime    the appear time of  the shape.
   * @param disappearTime the disappear time of the shape.
   */
  public Ellipse(int x, int y, int width, int height, int r, int g, int b, String uniqueCode,
      int appearTime, int disappearTime) {
    super(x, y, width, height, r, g, b, uniqueCode, appearTime, disappearTime);
    this.shapeType = Shapes.ELLIPSE;
  }

  /**
   * The constructor of the shape.
   *
   * @param uniqueCode the uniquecode of the shape.
   */
  public Ellipse(String uniqueCode) {
    this.shapeType = Shapes.ELLIPSE;
    this.uniqueCode = uniqueCode;
  }


  /**
   * Make a copy of the shape.
   *
   * @return a copy of the shape.
   */
  @Override
  public ShapeInterface makeACopy() {
    return new Ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getR(),
        this.getG(), this.getB(),
        this.getUniqueCode(), this.getAppearTime(), this.getDisappearTime());
  }

}
