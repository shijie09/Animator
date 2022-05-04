package cs5004.animator.model;

import java.awt.Color;

/**
 * Represent the interface of shapeinterface.
 */
public interface ShapeInterface {

  /**
   * Get the type of the shape.
   * @return the type of the shape.
   */
  Shapes getShapeType();

  /**
   * Get the width of the shape.
   * @return the width of the shape.
   */
  int getWidth();

  /**
   * Get the height of the shape.
   * @return the height of the shape.
   */
  int getHeight();

  /**
   * Get the red value for color.
   * @return the red value for color.
   */
  int getR();

  /**
   * Get the green value for color.
   * @return the green value for color.
   */
  int getG();

  /**
   * Get the blue value for color.
   * @return the blue value for color.
   */
  int getB();

  /**
   * Get the color of the shape.
   * @return the color of the shape.
   */
  Color getColor();

  /**
   * Set the red value.
   * @param r the red value.
   */
  void setR(int r);

  /**
   * Set the green value.
   * @param g the green value.
   */
  void setG(int g);

  /**
   * Set the blue value.
   * @param b the blue value.
   */
  void setB(int b);

  /**
   * Set the color.
   * @param r red value.
   * @param g green value.
   * @param b blue value.
   */
  void setColor(int r, int g, int b);

  /**
   * Get the x-coordinate of the shape.
   * @return the x-coordinate of the shape.
   */
  int getX();

  /**
   * Get the y-coordinate of the shape.
   * @return the y-coordinate of the shape.
   */
  int getY();

  /**
   * Set the x-coordinate of the shape.
   * @param x the x-coordinate.
   */
  void setX(int x);

  /**
   * Set the y-coordinate of the shape.
   * @param y the y-coordinate.
   */
  void setY(int y);

  /**
   * Set the width of the shape.
   * @param width the width of the shape.
   */
  void setWidth(int width);

  /**
   * Set the height of the shape.
   * @param height the width of the shape.
   */
  void setHeight(int height);

  /**
   * Get the uniqueCode.
   * @return the uniqueCode.
   */
  String getUniqueCode();

  /**
   * Set the uniqueCode.
   * @param uniqueCode the uniqueCode of the shape.
   */
  void setUniqueCode(String uniqueCode);

  /**
   * Get the appearing time of the shape.
   * @return the appearing time of the shape.
   */
  int getAppearTime();

  /**
   * Get the disappearing time of the shape.
   * @return the disappearing time of the shape.
   */
  int getDisappearTime();

  /**
   * Set the appearing time of the shape.
   * @param appearTime time that the shape appear.
   */
  void setAppearTime(int appearTime);

  /**
   * Set the disappearing time of the shape.
   * @param disappearTime time that the shape disappear.
   */
  void setDisappearTime(int disappearTime);

  /**
   * Get the initial flag of whether the shape is declared or not.
   * @return the initial flag of whether the shape is declared or not.
   */
  boolean getInitFlag();

  /**
   * Set  the initial flag of whether the shape is declared or not.
   * @param initFlag  the initial flag of whether the shape is declared or not.
   */
  void setInitFlag(boolean initFlag);

  /**
   * Make a copy of the shape.
   * @return a copy of the shape.
   */
  ShapeInterface makeACopy();
}
