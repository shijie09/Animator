package cs5004.animator.model;



/**
 * It is an interface of motions.
 */
public interface MotionInterface {

  /**
   * Get the start time of the motion.
   * @return the start time of the motion.
   */
  int getStartTime();

  /**
   * Get end time of the motion.
   * @return end time of the motion.
   */
  int getEndTime();

  /**
   * Set the start time of the motion.
   * @param startTime the start time of the motion.
   */
  void setStartTime(int startTime);

  /**
   * Set the end time of the motion.
   * @param endTime the end time of the motion.
   */
  void setEndTime(int endTime);

  /**
   *Get the uniquecode of the shape.
   * @return the uniquecode of the shape.
   */
  String getUniqueCode();

  /**
   * Set the uniquecode of the shape.
   * @param uniqueCode the only unique code of the shape.
   */
  void setUniqueCode(String uniqueCode);

  /**
   * Get the start x of the motion.
   * @return the start x of the motion.
   */
  int getStartX();

  /**
   * Get the start y of the motion.
   * @return  the start y of the motion.
   */
  int getStartY();

  /**
   * Get the end x of the motion.
   * @return the end x of the motion.
   */
  int getEndX();

  /**
   * Get the end y of the motion.
   * @return the end y of the motion.
   */
  int getEndY();

  /**
   * Set the start x of the motion.
   * @param x the x of the motion.
   */
  void setStartX(int x);

  /**
   * Set the start y of the motion.
   * @param y the start y of the motion.
   */
  void setStartY(int y);

  /**
   * Set the end x of the motion.
   * @param x the end x of the motion.
   */
  void setEndX(int x);

  /**
   * Set the end y of the motion.
   * @param y the end x of the motion.
   */
  void setEndY(int y);

  /**
   * Get the start width of the motion.
   * @return the start width of the motion.
   */
  int getStartWidth();

  /**
   * Get the start height of the motion.
   * @return the start height of the motion.
   */
  int getStartHeight();

  /**
   * Get the end width of the motion.
   * @return the end width of the motion.
   */
  int getEndWidth();

  /**
   * Get the end height of the motion.
   * @return the end height of the motion.
   */
  int getEndHeight();

  /**
   * Set the start width of the motion.
   * @param startWidth the start width of the motion.
   */
  void setStartWidth(int startWidth);

  /**
   * Set the start Heightof the motion.
   * @param startHeight the start Height of the motion.
   */
  void setStartHeight(int startHeight);

  /**
   * Set the end width of the motion.
   * @param endWidth  the end width of the motion.
   */
  void setEndWidth(int endWidth);

  /**
   * Set the end height of the motion.
   * @param endHeight the end height of the motion.
   */
  void setEndHeight(int endHeight);

  /**
   * Get the start red value of the motion.
   * @return the start red value of the motion.
   */
  int getStartR();

  /**
   * Get the start greeen value of the motion.
   * @return the start green value of the motion.
   */
  int getStartG();

  /**
   * Get the start blue value of the motion.
   * @return the start blue value of the motion.
   */
  int getStartB();

  /**
   * Get the end red value of the motion.
   * @return the end red value of the motion.
   */
  int getEndR();

  /**
   * Get the end green value of the motion.
   * @return the green value of the motion.
   */
  int getEndG();

  /**
   * Get the end blue value of the motion.
   * @return the blue red value of the motion.
   */
  int getEndB();

  /**
   * Set the red value of the motion.
   * @param r the red value of the motion.
   */
  void setStartR(int r);

  /**
   * Set the green value of the motion.
   * @param g the green value of the motion.
   */
  void setStartG(int g);

  /**
   * Set the blue value of the motion.
   * @param b the blue value of the motion.
   */
  void setStartB(int b);

  /**
   * Set the end red value of the motion.
   * @param r the end red value of the motion.
   */
  void setEndR(int r);

  /**
   * Set the end green value of the motion.
   * @param g the end green value of the motion.
   */
  void setEndG(int g);

  /**
   * Set the end blue value of the motion.
   * @param b the end blue value of the motion.
   */
  void setEndB(int b);

  /**
   * Get the shape type of the shape.
   * @return the shape type of the shape.
   */
  Shapes getShapeType();

  /**
   * Set the type of the shape.
   * @param shapeType  the type of the shape.
   */
  void setShapeType(Shapes shapeType);

  /**
   * Get the motion.
   * @return the motion.
   */
  Motions getMotion();

  /**
   * Set the motion.
   * @param motion the motion.
   */
  void setMotion(Motions motion);

  /**
   * Get the string of the motion.
   * @return the string of the motion.
   */
  String toString();

  /**
   * Set the copy of the shape.
   * @param shape the shape.
   */
  void setCopyOfShape(AbstractShape shape);

  /**
   * Get the copy of the shape.
   * @return the copy of the shape.
   */
  AbstractShape getCopyOfShape();
}
