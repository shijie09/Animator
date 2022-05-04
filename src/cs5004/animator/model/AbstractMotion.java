package cs5004.animator.model;

/**
 * Represent the abstract class of motion which implements from the motioninterface.
 */
public abstract class AbstractMotion implements MotionInterface {

  private int startTime;
  private int endTime;
  private String uniqueCode;
  private Motions motion;
  private Shapes shapeType;
  protected AbstractShape currentShape;

  /**
   * Get the start time of the motion.
   *
   * @return the start time of the motion.
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Get end time of the motion.
   *
   * @return end time of the motion.
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Set the start time of the motion.
   *
   * @param startTime the start time of the motion.
   */
  @Override
  public void setStartTime(int startTime) {
    this.startTime = startTime;

  }

  /**
   * Set the end time of the motion.
   *
   * @param endTime the end time of the motion.
   */
  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  /**
   * Get the uniquecode of the shape.
   *
   * @return the uniquecode of the shape.
   */
  @Override
  public String getUniqueCode() {
    return this.uniqueCode;
  }

  /**
   * Set the uniquecode of the shape.
   *
   * @param uniqueCode the only unique code of the shape.
   */
  @Override
  public void setUniqueCode(String uniqueCode) {
    this.uniqueCode = uniqueCode;

  }

  /**
   * Get the shape type of the shape.
   *
   * @return the shape type of the shape.
   */
  @Override
  public Shapes getShapeType() {
    return this.shapeType;
  }

  /**
   * Set the type of the shape.
   *
   * @param shapeType the type of the shape.
   */
  @Override
  public void setShapeType(Shapes shapeType) {
    this.shapeType = shapeType;
  }

  /**
   * Get the motion.
   *
   * @return the motion.
   */
  @Override
  public Motions getMotion() {
    return this.motion;
  }

  /**
   * Set the motion.
   *
   * @param motion the motion.
   */
  @Override
  public void setMotion(Motions motion) {
    this.motion = motion;
  }

  /**
   * Set the copy of the shape.
   *
   * @param shape the shape.
   */
  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape = shape;
  }

  /**
   * Get the copy of the shape.
   *
   * @return the copy of the shape.
   */
  @Override
  public AbstractShape getCopyOfShape() {
    return this.currentShape;
  }
}
