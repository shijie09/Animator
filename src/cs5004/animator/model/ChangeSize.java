package cs5004.animator.model;


/**
 * Represent the motion of the change size.
 */
public class ChangeSize extends AbstractMotion {

  private int startWidth;
  private int startHeight;
  private int endWidth;
  private int endHeight;

  /**
   * Constructor of the changesize motion.
   *
   * @param shape       the shape that change size.
   * @param uniqueCode  the only unique code for the shape.
   * @param startWidth  the start width of the shape.
   * @param startHeight the start height of the shape.
   * @param endWidth    the end width of the shape.
   * @param endHeight   the end height of the shape.
   * @param startTime   the start time of the motion.
   * @param endTime     the end time of the motion.
   */
  public ChangeSize(AbstractShape shape, String uniqueCode, int startWidth, int startHeight,
      int endWidth, int endHeight, int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setUniqueCode(uniqueCode);
    super.setShapeType(shape.getShapeType());
    super.setMotion(Motions.CHANGESIZE);
    super.setCopyOfShape(shape);
    this.setStartWidth(startWidth);
    this.setStartHeight(startHeight);
    this.setEndWidth(endWidth);
    this.setEndHeight(endHeight);

  }

  /**
   * Get the start x of the motion.
   *
   * @return the start x of the motion.
   */
  @Override
  public int getStartX() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Get the start y of the motion.
   *
   * @return the start y of the motion.
   */
  @Override
  public int getStartY() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Get the end x of the motion.
   *
   * @return the end x of the motion.
   */
  @Override
  public int getEndX() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Get the end y of the motion.
   *
   * @return the end y of the motion.
   */
  @Override
  public int getEndY() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Set the start x of the motion.
   *
   * @param x the x of the motion.
   */
  @Override
  public void setStartX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Set the start y of the motion.
   *
   * @param y the start y of the motion.
   */
  @Override
  public void setStartY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Set the end x of the motion.
   *
   * @param x the end x of the motion.
   */
  @Override
  public void setEndX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  /**
   * Set the end y of the motion.
   *
   * @param y the end x of the motion.
   */
  @Override
  public void setEndY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public int getStartWidth() {
    return this.startWidth;
  }


  /**
   * Get the start height of the motion.
   *
   * @return the start height of the motion.
   */
  @Override
  public int getStartHeight() {
    return this.startHeight;
  }

  /**
   * Get the end width of the motion.
   *
   * @return the end width of the motion.
   */
  @Override
  public int getEndWidth() {
    return this.endWidth;
  }

  /**
   * Get the end height of the motion.
   *
   * @return the end height of the motion.
   */
  @Override
  public int getEndHeight() {
    return this.endHeight;
  }

  /**
   * Set the start width of the motion.
   *
   * @param startWidth the start width of the motion.
   */
  @Override
  public void setStartWidth(int startWidth) {
    this.startWidth = startWidth;
  }

  /**
   * Set the start Heightof the motion.
   *
   * @param startHeight the start Height of the motion.
   */
  @Override
  public void setStartHeight(int startHeight) {
    this.startHeight = startHeight;
  }

  /**
   * Set the end width of the motion.
   *
   * @param endWidth the end width of the motion.
   */
  @Override
  public void setEndWidth(int endWidth) {
    this.endWidth = endWidth;
  }

  /**
   * Set the end height of the motion.
   *
   * @param endHeight the end height of the motion.
   */
  @Override
  public void setEndHeight(int endHeight) {
    this.endHeight = endHeight;

  }

  /**
   * Get the start red value of the motion.
   *
   * @return the start red value of the motion.
   */
  @Override
  public int getStartR() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Get the start greeen value of the motion.
   *
   * @return the start green value of the motion.
   */
  @Override
  public int getStartG() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Get the start blue value of the motion.
   *
   * @return the start blue value of the motion.
   */
  @Override
  public int getStartB() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Get the end red value of the motion.
   *
   * @return the end red value of the motion.
   */
  @Override
  public int getEndR() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Get the end green value of the motion.
   *
   * @return the green value of the motion.
   */
  @Override
  public int getEndG() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Get the end blue value of the motion.
   *
   * @return the blue red value of the motion.
   */
  @Override
  public int getEndB() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the red value of the motion.
   *
   * @param r the red value of the motion.
   */
  @Override
  public void setStartR(int r) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the green value of the motion.
   *
   * @param g the green value of the motion.
   */
  @Override
  public void setStartG(int g) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the blue value of the motion.
   *
   * @param b the blue value of the motion.
   */
  @Override
  public void setStartB(int b) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the end red value of the motion.
   *
   * @param r the end red value of the motion.
   */
  @Override
  public void setEndR(int r) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the end green value of the motion.
   *
   * @param g the end green value of the motion.
   */
  @Override
  public void setEndG(int g) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the end blue value of the motion.
   *
   * @param b the end blue value of the motion.
   */
  @Override
  public void setEndB(int b) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  /**
   * Set the copy of the shape.
   *
   * @param shape the shape.
   */
  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setWidth(endWidth);
    this.currentShape.setHeight(endHeight);

  }


  /**
   * Get the copy of the shape.
   *
   * @return the copy of the shape.
   */
  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setWidth(endWidth);
    this.currentShape.setHeight(endHeight);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changeSizeString;
    if (this.getStartHeight() == this.getEndHeight()) {
      changeSizeString =
          this.getUniqueCode() + " changes width from " + this.getStartWidth() + " to "
              + this.getEndWidth() + " from time t =" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    } else if (this.getEndWidth() == this.getStartWidth()) {
      changeSizeString =
          this.getUniqueCode() + " changes height from " + this.getStartHeight() + " to "
              + this.getEndHeight() + "  time t=" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    } else {
      changeSizeString =
          this.getUniqueCode() + " changes width from " + this.getStartWidth() + " to "
              + this.getEndWidth() + " and changes height from" + this.getStartHeight() + " to "
              + this.getEndHeight() + " from time t=" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    }
  }
}
