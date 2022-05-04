package cs5004.animator.model;

/**
 * Represent the motion of the change position.
 */
public class ChangePosition extends AbstractMotion {

  private int startX;
  private int startY;
  private int endX;
  private int endY;

  /**
   * Constructor of the motion of change position.
   *
   * @param shape      the shape that change position.
   * @param uniqueCode the only unique code of the shape.
   * @param startX     the start x coordinate of the shape.
   * @param startY     the start y coordinate of the shape.
   * @param endX       the end  x coordinate of the shape.
   * @param endY       the end  y coordinate of the shape.
   * @param startTime  the start time of the motion.
   * @param endTime    the end time of the motion.
   */
  public ChangePosition(AbstractShape shape, String uniqueCode, int startX, int startY, int endX,
      int endY, int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeType(shape.getShapeType());
    super.setMotion(Motions.CHANGEPOSITION);
    super.setUniqueCode(uniqueCode);
    super.setCopyOfShape(shape);
    this.setStartX(startX);
    this.setStartY(startY);
    this.setEndX(endX);
    this.setEndY(endY);

  }


  /**
   * Get the start x of the motion.
   *
   * @return the start x of the motion.
   */
  @Override
  public int getStartX() {
    return this.startX;
  }

  /**
   * Get the start y of the motion.
   *
   * @return the start y of the motion.
   */
  @Override
  public int getStartY() {
    return this.startY;
  }

  /**
   * Get the end x of the motion.
   *
   * @return the end x of the motion.
   */
  @Override
  public int getEndX() {
    return this.endX;
  }

  /**
   * Get the end y of the motion.
   *
   * @return the end y of the motion.
   */
  @Override
  public int getEndY() {
    return this.endY;
  }

  /**
   * Set the start x of the motion.
   *
   * @param x the x of the motion.
   */
  @Override
  public void setStartX(int x) {
    this.startX = x;

  }

  /**
   * Set the start y of the motion.
   *
   * @param y the start y of the motion.
   */
  @Override
  public void setStartY(int y) {
    this.startY = y;
  }

  /**
   * Set the end x of the motion.
   *
   * @param x the end x of the motion.
   */
  @Override
  public void setEndX(int x) {
    this.endX = x;
  }

  /**
   * Set the end y of the motion.
   *
   * @param y the end x of the motion.
   */
  @Override
  public void setEndY(int y) {
    this.endY = y;

  }

  /**
   * Get the start width of the motion.
   *
   * @return the start width of the motion.
   */
  @Override
  public int getStartWidth() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Get the start height of the motion.
   *
   * @return the start height of the motion.
   */
  @Override
  public int getStartHeight() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Get the end width of the motion.
   *
   * @return the end width of the motion.
   */
  @Override
  public int getEndWidth() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Get the end height of the motion.
   *
   * @return the end height of the motion.
   */
  @Override
  public int getEndHeight() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Set the start width of the motion.
   *
   * @param startWidth the start width of the motion.
   */
  @Override
  public void setStartWidth(int startWidth) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Set the start Heightof the motion.
   *
   * @param startHeight the start Height of the motion.
   */
  @Override
  public void setStartHeight(int startHeight) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Set the end width of the motion.
   *
   * @param endWidth the end width of the motion.
   */
  @Override
  public void setEndWidth(int endWidth) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  /**
   * Set the end height of the motion.
   *
   * @param endHeight the end height of the motion.
   */
  @Override
  public void setEndHeight(int endHeight) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }


  /**
   * Get the start red value of the motion.
   *
   * @return the start red value of the motion.
   */
  @Override
  public int getStartR() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Get the start greeen value of the motion.
   *
   * @return the start green value of the motion.
   */
  @Override
  public int getStartG() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Get the start blue value of the motion.
   *
   * @return the start blue value of the motion.
   */
  @Override
  public int getStartB() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Get the end red value of the motion.
   *
   * @return the end red value of the motion.
   */
  @Override
  public int getEndR() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Get the end green value of the motion.
   *
   * @return the green value of the motion.
   */
  @Override
  public int getEndG() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Get the end blue value of the motion.
   *
   * @return the blue red value of the motion.
   */
  @Override
  public int getEndB() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the red value of the motion.
   *
   * @param r the red value of the motion.
   */
  @Override
  public void setStartR(int r) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the green value of the motion.
   *
   * @param g the green value of the motion.
   */
  @Override
  public void setStartG(int g) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the blue value of the motion.
   *
   * @param b the blue value of the motion.
   */
  @Override
  public void setStartB(int b) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the end red value of the motion.
   *
   * @param r the end red value of the motion.
   */
  @Override
  public void setEndR(int r) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the end green value of the motion.
   *
   * @param g the end green value of the motion.
   */
  @Override
  public void setEndG(int g) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the end blue value of the motion.
   *
   * @param b the end blue value of the motion.
   */
  @Override
  public void setEndB(int b) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  /**
   * Set the copy of the shape.
   *
   * @param shape the shape.
   */
  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setX(this.endX);
    this.currentShape.setY(this.endY);

  }

  /**
   * Get the copy of the shape.
   *
   * @return the copy of the shape.
   */
  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setX(this.endX);
    this.currentShape.setY(this.endY);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changePositionString;
    changePositionString =
        this.getUniqueCode() + " moves from " + "(" + this.getStartX() + "," + this.getStartY()
            + ") to ( " + this.getEndX() + "," + this.getEndY() + ") from time t= "
            + this.getStartTime() + " to time t= " + this.getEndTime() + ".\n";
    return changePositionString;
  }

}
