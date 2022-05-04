package cs5004.animator.model;

import java.awt.Color;

/**
 * Represent the abstract class of the shape.
 */
public abstract class AbstractShape implements ShapeInterface {

  private int x;
  private int y;
  private int width;
  private int height;
  private int r;
  private int g;
  private int b;
  protected Shapes shapeType;
  private Color color;
  protected String uniqueCode;
  private int appearTime;
  private int disappearTime;
  private AbstractShape shape;
  private boolean initFlag;


  /**
   * Constructor of AbstractShape.
   *
   * @param x          the x coordinate of the shape.
   * @param y          the y coordinate of the shape.
   * @param width      the width of the shape.
   * @param height     the height of the shape.
   * @param uniqueCode the only unique label of the shape.
   */
  protected AbstractShape(int x, int y, int width, int height, int r, int g, int b,
      String uniqueCode, int appearTime, int disappearTime) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("width and height must be positive.");
    }
    if (appearTime < 0 || disappearTime < 0 || appearTime > disappearTime) {
      throw new IllegalArgumentException("Appeartime and disappertime inputs might be wrong.");
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.r = r;
    this.g = g;
    this.b = b;
    this.color = new Color(this.r, this.g, this.b);
    this.uniqueCode = uniqueCode;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
    this.initFlag = true;
  }

  /**
   * Constructor of the shape.
   */
  protected AbstractShape() {
    this.width = 0;
    this.height = 0;
    this.x = 0;
    this.y = 0;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.color = new Color(this.r, this.g, this.b);
    this.uniqueCode = "";
    this.appearTime = 0;
    this.disappearTime = 0;
    this.initFlag = false;

  }


  /**
   * Get the type of the shape.
   *
   * @return the type of the shape.
   */
  @Override
  public Shapes getShapeType() {
    return this.shapeType;
  }

  /**
   * Get the width of the shape.
   *
   * @return the width of the shape.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Get the height of the shape.
   *
   * @return the height of the shape.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Get the red value for color.
   *
   * @return the red value for color.
   */
  @Override
  public int getR() {
    return this.r;
  }

  /**
   * Get the green value for color.
   *
   * @return the green value for color.
   */
  @Override
  public int getG() {
    return this.g;
  }

  /**
   * Get the blue value for color.
   *
   * @return the blue value for color.
   */
  @Override
  public int getB() {
    return this.b;
  }

  /**
   * Get the color of the shape.
   *
   * @return the color of the shape.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void setR(int r) {
    this.r = r;
  }

  @Override
  public void setG(int g) {
    this.g = g;
  }

  @Override
  public void setB(int b) {
    this.b = b;
  }

  @Override
  public void setColor(int r, int g, int b) {

    this.color = new Color(r, g, b);
  }

  /**
   * Get the x-coordinate of the shape.
   *
   * @return the x-coordinate of the shape.
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * Get the y-coordinate of the shape.
   *
   * @return the y-coordinate of the shape.
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * Set the x-coordinate of the shape.
   *
   * @param x the x-coordinate.
   */
  @Override
  public void setX(int x) {
    this.x = x;

  }

  /**
   * Set the y-coordinate of the shape.
   *
   * @param y the y-coordinate.
   */
  @Override
  public void setY(int y) {
    this.y = y;

  }


  /**
   * Set the width of the shape.
   *
   * @param width the width of the shape.
   */
  @Override
  public void setWidth(int width) {
    this.width = width;

  }

  /**
   * Set the height of the shape.
   *
   * @param height the width of the shape.
   */
  @Override
  public void setHeight(int height) {
    this.height = height;

  }

  @Override
  public String getUniqueCode() {
    return this.uniqueCode;
  }

  @Override
  public void setUniqueCode(String uniqueCode) {
    this.uniqueCode = uniqueCode;
  }

  /**
   * Get the appearing time of the shape.
   *
   * @return the appearing time of the shape.
   */
  @Override
  public int getAppearTime() {
    return this.appearTime;
  }

  /**
   * Get the disappearing time of the shape.
   *
   * @return the disappearing time of the shape.
   */
  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }

  /**
   * Set the appearing time of the shape.
   *
   * @param appearTime time that the shape appear.
   */
  @Override
  public void setAppearTime(int appearTime) {
    this.appearTime = appearTime;

  }

  /**
   * Set the disappearing time of the shape.
   *
   * @param disappearTime time that the shape disappear.
   */
  @Override
  public void setDisappearTime(int disappearTime) {
    this.disappearTime = disappearTime;

  }

  @Override
  public boolean getInitFlag() {
    return this.initFlag;
  }

  @Override
  public void setInitFlag(boolean initFlag) {
    this.initFlag = initFlag;
  }

  /**
   * Make a copy of the shape.
   *
   * @return a copy of the shape.
   */
  @Override
  public ShapeInterface makeACopy() {
    return this;
  }



}

