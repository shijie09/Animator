package cs5004.animator.model;

import java.awt.Color;

/**
 * Represent the change color motion.
 */
public class ChangeColor extends AbstractMotion {

  private int startR;
  private int startG;
  private int startB;
  private int endR;
  private int endG;
  private int endB;


  /**
   * Constructor of the changecolor motion.
   *
   * @param shape      the shape which  changes color.
   * @param uniqueCode the unique code of the shape.
   * @param startR     the start red value of the shape.
   * @param startG     the start green value of the shape.
   * @param startB     the start blue value of the shape.
   * @param endR       the end red value of the shape.
   * @param endG       the end green value of the shape.
   * @param endB       the end blue value of the shape.
   * @param startTime  the start time of the motion.
   * @param endTime    the end time of the motion.
   */
  public ChangeColor(AbstractShape shape, String uniqueCode, int startR, int startG, int startB,
      int endR, int endG, int endB,
      int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeType(shape.getShapeType());
    super.setUniqueCode(uniqueCode);
    super.setMotion(Motions.CHANGECOLOR);
    super.setCopyOfShape(shape);
    this.setStartR(startR);
    this.setStartG(startG);
    this.setStartB(startB);
    this.setEndR(endR);
    this.setEndG(endG);
    this.setEndB(endB);
  }

  /**
   * Get the start x of the motion.
   *
   * @return the start x of the motion.
   */
  @Override
  public int getStartX() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Get the start y of the motion.
   *
   * @return the start y of the motion.
   */
  @Override
  public int getStartY() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Get the end x of the motion.
   *
   * @return the end x of the motion.
   */
  @Override
  public int getEndX() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Get the end y of the motion.
   *
   * @return the end y of the motion.
   */
  @Override
  public int getEndY() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Set the start x of the motion.
   *
   * @param x the x of the motion.
   */
  @Override
  public void setStartX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Set the start y of the motion.
   *
   * @param y the start y of the motion.
   */
  @Override
  public void setStartY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Set the end x of the motion.
   *
   * @param x the end x of the motion.
   */
  @Override
  public void setEndX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Set the end y of the motion.
   *
   * @param y the end x of the motion.
   */
  @Override
  public void setEndY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  /**
   * Get the start width of the motion.
   *
   * @return the start width of the motion.
   */
  @Override
  public int getStartWidth() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Get the start height of the motion.
   *
   * @return the start height of the motion.
   */
  @Override
  public int getStartHeight() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Get the end width of the motion.
   *
   * @return the end width of the motion.
   */
  @Override
  public int getEndWidth() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Get the end height of the motion.
   *
   * @return the end height of the motion.
   */
  @Override
  public int getEndHeight() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Set the start width of the motion.
   *
   * @param startWidth the start width of the motion.
   */
  @Override
  public void setStartWidth(int startWidth) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Set the start Heightof the motion.
   *
   * @param startHeight the start Height of the motion.
   */
  @Override
  public void setStartHeight(int startHeight) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Set the end width of the motion.
   *
   * @param endWidth the end width of the motion.
   */
  @Override
  public void setEndWidth(int endWidth) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Set the end height of the motion.
   *
   * @param endHeight the end height of the motion.
   */
  @Override
  public void setEndHeight(int endHeight) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  /**
   * Get the start red value of the motion.
   *
   * @return the start red value of the motion.
   */
  @Override
  public int getStartR() {
    return this.startR;
  }

  /**
   * Get the start greeen value of the motion.
   *
   * @return the start green value of the motion.
   */
  @Override
  public int getStartG() {
    return this.startG;
  }

  /**
   * Get the start blue value of the motion.
   *
   * @return the start blue value of the motion.
   */
  @Override
  public int getStartB() {
    return this.startB;
  }

  /**
   * Get the end red value of the motion.
   *
   * @return the end red value of the motion.
   */
  @Override
  public int getEndR() {
    return this.endR;
  }

  /**
   * Get the end green value of the motion.
   *
   * @return the green value of the motion.
   */
  @Override
  public int getEndG() {
    return this.endG;
  }

  /**
   * Get the end blue value of the motion.
   *
   * @return the blue red value of the motion.
   */
  @Override
  public int getEndB() {
    return this.endB;
  }

  /**
   * Set the red value of the motion.
   *
   * @param r the red value of the motion.
   */
  @Override
  public void setStartR(int r) {
    this.startR = r;

  }

  /**
   * Set the green value of the motion.
   *
   * @param g the green value of the motion.
   */
  @Override
  public void setStartG(int g) {
    this.startG = g;
  }

  /**
   * Set the blue value of the motion.
   *
   * @param b the blue value of the motion.
   */
  @Override
  public void setStartB(int b) {
    this.startB = b;
  }

  /**
   * Set the end red value of the motion.
   *
   * @param r the end red value of the motion.
   */
  @Override
  public void setEndR(int r) {
    this.endR = r;
  }

  /**
   * Set the end green value of the motion.
   *
   * @param g the end green value of the motion.
   */
  @Override
  public void setEndG(int g) {
    this.endG = g;
  }

  /**
   * Set the end blue value of the motion.
   *
   * @param b the end blue value of the motion.
   */
  @Override
  public void setEndB(int b) {
    this.endB = b;
  }

  /**
   * Get the start color of the motion.
   * @return the start color of the motion.
   */
  public Color getStartColor() {

    return new Color(startR, startG, startB);
  }

  /**
   * Get the end color of the motion.
   * @return the end color of the motion.
   */
  public Color getEndColor() {

    return new Color(endR, endG, endB);
  }


  /**
   * Set the copy of the shape.
   *
   * @param shape the shape.
   */
  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setColor(this.endR, this.endG, this.endB);

  }

  /**
   * Get the copy of the shape.
   *
   * @return the copy of the shape.
   */
  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setR(this.endR);
    this.currentShape.setG(this.endG);
    this.currentShape.setB(this.endB);
    this.currentShape.setColor(this.endR, this.endG, this.endB);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changeColorString;
    changeColorString =
        this.getUniqueCode() + " changes from color(Red: " + this.getStartR() + " Green: "
            + this.getStartG() + " Blue:" + this.getStartB() + ") to color(Red: " + this.getEndR()
            + " Green: "
            + this.getEndG() + " Blue:" + this.getEndB() + " from time t= " + this.getStartTime()
            + " to "
            + this.getEndTime() + ".\n";
    return changeColorString;
  }

}
