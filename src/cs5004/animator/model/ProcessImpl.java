package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * It is an implementation of Process interface. It is almost the most important part of the model.
 * It uses two linkedhasmaps to contain the shapes and motions we need to execute the view.
 */
public class ProcessImpl implements ProcessInterface {

  protected final LinkedHashMap<String, AbstractShape> mapOfShape;
  protected final LinkedHashMap<String, List<AbstractMotion>> mapOfMotions;
  private int canvasWidth;
  private int canvasHeight;
  private int canvasX;
  private int canvasY;
  private int endTime;
  private double speed;

  /**
   * Represent the constructor of process.
   */
  public ProcessImpl() {
    this.mapOfShape = new LinkedHashMap<>();
    this.mapOfMotions = new LinkedHashMap<>();
  }

  /**
   * Determine whether has the shape or not .
   *
   * @param uniqueCode the only code to determine the shape.
   * @return true if has this shape with the uniquecode and false if not .
   */
  @Override
  public boolean hasShape(String uniqueCode) {
    return this.mapOfShape.containsKey(uniqueCode);
  }

  /**
   * Get the shapes in the list.
   *
   * @return the list of current shapes in the mapofShape.
   */
  @Override
  public List<AbstractShape> getShapes() {

    List<AbstractShape> shapes = new ArrayList<>(mapOfShape.values());
    return shapes;
  }

  /**
   * Get the list of shapes.
   *
   * @return the list of shapes.
   */
  @Override
  public HashMap<String, AbstractShape> getMapOfShape() {
    return this.mapOfShape;
  }

  /**
   * Get one of the certain shape by the uniquecode.
   *
   * @param uniqueCode the only one code for a shape.
   * @return the shape if we have the shape in list.
   */
  @Override
  public AbstractShape getCertainShape(String uniqueCode) {
    if (!hasShape(uniqueCode)) {
      throw new IllegalArgumentException("Don't have such shape.");
    }
    return this.mapOfShape.get(uniqueCode);
  }

  /**
   * Get the shape's all motions.
   *
   * @return the shape's all motions.
   */
  @Override
  public ArrayList<AbstractMotion> getMotions(String uniqueCode) {
    ArrayList<AbstractMotion> motions = new ArrayList<AbstractMotion>(
        mapOfMotions.get(uniqueCode));
    return motions;
  }

  /**
   * Add a shape to the hashmap list.
   *
   * @param shape the shape need to put in the list.
   */
  @Override
  public void addShape(AbstractShape shape) throws IllegalArgumentException {

    if (mapOfShape.containsKey(shape.getUniqueCode())) {
      throw new IllegalArgumentException("The shape with this uniquecode has already exist.");
    } else if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      if (shape.getShapeType().equals(Shapes.ELLIPSE) || shape.getShapeType()
          .equals(Shapes.RECTANGLE)) {
        this.mapOfShape.put(shape.getUniqueCode(), shape);
        this.mapOfMotions.put(shape.getUniqueCode(), new ArrayList<>());
      } else {
        throw new IllegalArgumentException("Need to add a new shape type in the enum.");
      }
    }
  }

  /**
   * Add a shape to the hashmap list.
   *
   * @param shape         the shape.
   * @param x             the x coordinate.
   * @param y             the y  coordinate.
   * @param width         width of the shape.
   * @param height        height of the shape.
   * @param r             the red contribute of color.
   * @param g             the green.
   * @param b             the blue.
   * @param uniqueCode    the unique code to determine the shape.
   * @param appearTime    appear time.
   * @param disappearTime disappear time.
   */

  @Override
  public void addShape(Shapes shape, int x, int y, int width, int height,
      int r, int g, int b, String uniqueCode, int appearTime, int disappearTime) {
    if (width < 0 || height < 0 || r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255
        || appearTime < 0 || disappearTime < 0 || disappearTime < appearTime) {
      throw new IllegalArgumentException(
          "Can not creat a shape because the value is wrong.Check it");
    }
    if (mapOfShape.containsKey(uniqueCode)) {
      throw new IllegalArgumentException("The shape with this uniquecode has already exist.");
    }
    if (shape.equals(Shapes.ELLIPSE)) {
      AbstractShape shapeNew = new Ellipse(x, y, width, height, r, g, b, uniqueCode, appearTime,
          disappearTime);
      mapOfShape.put(uniqueCode, shapeNew);
      this.mapOfMotions.put(uniqueCode, new ArrayList<>());
    } else if (shape.equals(Shapes.RECTANGLE)) {
      AbstractShape shapeNew = new Rectangle(x, y, width, height, r, g, b, uniqueCode, appearTime,
          disappearTime);
      mapOfShape.put(uniqueCode, shapeNew);
      this.mapOfMotions.put(uniqueCode, new ArrayList<>());
    } else {
      throw new IllegalArgumentException("Need to add a new shape type in the enum.");
    }
  }

  /**
   * Remove one existed shape.
   *
   * @param uniqueCode the need-remove shape's uniquecode.
   */
  @Override
  public void removeShape(String uniqueCode) {
    if (mapOfShape.containsKey(uniqueCode)) {
      mapOfShape.remove(uniqueCode);
    } else {
      throw new IllegalArgumentException("shape doesn't exist.");
    }
  }

  /**
   * A helper method to determine whether motion is confilct.
   *
   * @param shape     the shape.
   * @param motion    the motion.
   * @param timeStart start time.
   * @param timeEnd   end time.
   * @return true if time not conflict and false if confilct.
   */
  private boolean confilctingOneTime(AbstractShape shape, Motions motion, int timeStart,
      int timeEnd) {
    for (List<AbstractMotion> motionsList : this.mapOfMotions.values()) {
      for (AbstractMotion m : motionsList) {
        if (Objects.equals(shape.getUniqueCode(), m.getUniqueCode())) {
          if (motion == m.getMotion()) {
            if ((m.getStartTime() < timeStart && m.getEndTime() > timeEnd) || (
                m.getStartTime() > timeStart && m.getEndTime() < timeEnd) || (
                m.getStartTime() < timeStart && m.getEndTime() > timeStart) || (
                m.getStartTime() < timeEnd && m.getEndTime() > timeEnd)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Represent the change position motion.
   *
   * @param shape     the shape which needs to change position.
   * @param startX    the start x coordinate of the shape.
   * @param startY    the start y coordinate of the shape.
   * @param endX      the end x coordinate of the shape.
   * @param endY      the end y coordinate of the shape.
   * @param startTime the start time of the shape.
   * @param endTime   the end time of the shape.
   */
  @Override
  public void addMove(AbstractShape shape, int startX, int startY, int endX, int endY,
      int startTime,
      int endTime) {
    if (startTime > endTime || startTime < 0) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGEPOSITION, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key)
        .add(new ChangePosition(shape, shape.getUniqueCode(), startX, startY, endX, endY,
            startTime, endTime));
  }

  /**
   * Represent the change color motion.
   *
   * @param shape     the shape which needs to change color.
   * @param startR    the start red value of shape.
   * @param startG    the start green value of shape.
   * @param startB    the start blue value of shape.
   * @param endR      the end red value of shape.
   * @param endG      the end green value of shape.
   * @param endB      the end blue value of shape.
   * @param startTime the start time of the shape.
   * @param endTime   the end time of the shape.
   */
  @Override
  public void addChangeColor(AbstractShape shape, int startR, int startG, int startB, int endR,
      int endG, int endB, int startTime, int endTime) {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGECOLOR, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key)
        .add(new ChangeColor(shape, shape.getUniqueCode(), startR, startG, startB, endR,
            endG, endB, startTime, endTime));
  }

  /**
   * Represent the change size motion.
   *
   * @param shape       the shape which needs to change size.
   * @param starWidth   the start width of shape.
   * @param startHeight the start height of shape.
   * @param endWidth    the end width of shape.
   * @param endHeight   the end height of shape.
   * @param startTime   the start time of the shape.
   * @param endTime     the end time of the shape.
   */
  @Override
  public void addChangeSize(AbstractShape shape, int starWidth, int startHeight, int endWidth,
      int endHeight, int startTime, int endTime) {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGESIZE, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key).add(new ChangeSize(shape, shape.getUniqueCode(), starWidth, startHeight,
        endWidth, endHeight, startTime, endTime));

  }

  /**
   * Get a list of shapes in a give tick.
   *
   * @param tick the given time.
   * @return a list of shapes.
   */
  @Override
  public List<AbstractShape> getState(int tick) {
    if (tick < 0) {
      throw new IllegalArgumentException("tick shouldn't be negative int.");
    }
    List<AbstractShape> processCopy = new ArrayList<>();
    for (List<AbstractMotion> motionList : mapOfMotions.values()) {
      for (AbstractMotion motion : motionList) {
        if (motion.getStartTime() <= tick && motion.getEndTime() >= tick) {
          float startTime = motion.getStartTime();
          float endTime = motion.getEndTime();
          float tweening = 0;
          if (endTime == startTime) {
            tweening = 1;
          } else {
            tweening = (tick - startTime) / (endTime - startTime);
          }
          switch (motion.getMotion()) {
            case CHANGEPOSITION: {
              int startX = motion.getStartX();
              int startY = motion.getStartY();
              int endX = motion.getEndX();
              int endY = motion.getEndY();
              float tickX = (startX * (1 - tweening) + endX * tweening);
              float tickY = (startY * (1 - tweening) + endY * tweening);
              int newX = Math.round(tickX);
              int newY = Math.round(tickY);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setX(newX);
              shape.setY(newY);
              processCopy.add(shape);
              break;
            }
            case CHANGECOLOR: {
              int startR = motion.getStartR();
              int startG = motion.getStartG();
              int startB = motion.getStartB();
              int endR = motion.getEndR();
              int endG = motion.getEndG();
              int endB = motion.getEndB();
              float tickR = (startR * (1 - tweening) + endR * tweening);
              float tickG = (startG * (1 - tweening) + endG * tweening);
              float tickB = (startB * (1 - tweening) + endB * tweening);
              int newR = Math.round(tickR);
              int newG = Math.round(tickG);
              int newB = Math.round(tickB);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setR(newR);
              shape.setG(newG);
              shape.setB(newB);
              shape.setColor(newR, newG, newB);
              processCopy.add(shape);
              break;

            }
            case CHANGESIZE: {
              int startWidth = motion.getStartWidth();
              int startHeight = motion.getStartHeight();
              int endWidth = motion.getEndWidth();
              int endHeight = motion.getEndHeight();
              float tickWidth = startWidth * (1 - tweening) + endWidth * tweening;
              float tickHeight = startHeight * (1 - tweening) + endHeight * tweening;
              int newWidth = Math.round(tickWidth);
              int newHeight = Math.round(tickHeight);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setWidth(newWidth);
              shape.setHeight(newHeight);
              processCopy.add(shape);
              break;
            }
            default: {
              throw new IllegalArgumentException("Should not have such exception.");
            }
          }
        }
      }
    }
    return processCopy;
  }

  /**
   * The toString method helps execute the textview.
   *
   * @return a string represent the animation.
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (AbstractShape shape : mapOfShape.values()) {
      stringBuilder.append(
          "Create " + shape.getShapeType().toString() + " "
              + shape.getUniqueCode() + " with color ( Red: " + shape.getR() + " Green: "
              + shape.getG() + " Blue:" + shape.getB() + " ) and with ");
      String positiontype = "";
      String positionOriginal = "";
      String widthAndHeight = "";
      positionOriginal = "(" + shape.getX() + "," + shape.getY() + "),";
      if (shape.getShapeType() == Shapes.RECTANGLE) {
        positiontype = " corner ";
        widthAndHeight = " width " + shape.getWidth() + " and height " + shape.getHeight();


      }
      if (shape.getShapeType() == Shapes.ELLIPSE) {
        positiontype = " center ";
        widthAndHeight = " radius " + shape.getWidth() + " and  " + shape.getHeight();
      }
      stringBuilder.append(positiontype);
      stringBuilder.append(positionOriginal);
      stringBuilder.append(widthAndHeight);
      stringBuilder.append(".\n");
    }
    stringBuilder.append("\n");
    for (AbstractShape shape : mapOfShape.values()) {
      stringBuilder.append(shape.getUniqueCode());
      stringBuilder.append(" appears at time t = ");
      stringBuilder.append(shape.getAppearTime());
      stringBuilder.append(" and disappear at time t = ");
      stringBuilder.append(shape.getDisappearTime());
      stringBuilder.append(".\n");
    }
    stringBuilder.append("\n");
    List<ArrayList<String>> list = new ArrayList<>();
    int number = 0;
    for (String shapeInList : this.mapOfShape.keySet()) {
      for (AbstractMotion motionInTheShapeList : this.mapOfMotions.get(shapeInList)) {
        list.add(new ArrayList<>());
        list.get(number).add(Double.toString(motionInTheShapeList.getStartTime()));
        list.get(number).add(motionInTheShapeList.toString());
        number++;
      }
    }
    list.sort(Comparator.comparingDouble(o -> Double.parseDouble(o.get(0))));
    for (ArrayList<String> listOutput : list) {
      stringBuilder.append(listOutput.get(1));
    }
    return stringBuilder.toString();
  }

  /**
   * Set the x coordinate of the canvas.
   *
   * @param x the x coordinate of the canvas.
   */
  @Override
  public void setCanvasX(int x) {
    this.canvasX = x;
  }

  /**
   * Set the y coordinate of the canvas.
   *
   * @param y the y coordinate of the canvas.
   */
  @Override
  public void setCanvasY(int y) {
    this.canvasY = y;
  }

  /**
   * Get the x coordinate of the canvas.
   *
   * @return the x coordinate of the canvas.
   */
  @Override
  public int getCanvasX() {
    return this.canvasX;
  }

  /**
   * Get the y coordinate of the canvas.
   *
   * @return the y coordinate of the canvas.
   */
  @Override
  public int getCanvasY() {
    return this.canvasY;
  }

  /**
   * Set the width of the canvas.
   *
   * @param canvasWidth the width of the width.
   */
  @Override
  public void setCanvasWidth(int canvasWidth) {
    this.canvasWidth = canvasWidth;
  }

  /**
   * Set the height of the canvas.
   *
   * @param canvasHeight the height of the canvas.
   */
  @Override
  public void setCanvasHeight(int canvasHeight) {
    this.canvasHeight = canvasHeight;
  }

  /**
   * Get the width of the canvas.
   *
   * @return the width of the canvas.
   */
  @Override
  public int getCanvasWidth() {
    return this.canvasWidth;
  }

  /**
   * Get the height of the canvas.
   *
   * @return the height of the canvas.
   */
  @Override
  public int getCanvasHeight() {
    return this.canvasHeight;
  }

  /**
   * Get the end time of the animation.
   *
   * @return the end time of the animation.
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Set the end time of the animation.
   *
   * @param endTime the end time of the animation.
   */
  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  /**
   * Set the speed of the animation.
   *
   * @param speed the speed of the animation.
   */
  @Override
  public void setSpeed(double speed) {
    this.speed = speed;
  }

  /**
   * Get the speed of the animation.
   *
   * @return the speed of the animation.
   */
  @Override
  public double getSpeed() {
    return this.speed;
  }

  /**
   * It is a class of builder of the animation using the processImpl.
   */
  public static final class OneBuilder implements AnimationBuilder<ProcessInterface> {

    private ProcessInterface model;

    /**
     * Constructor of the builder.
     *
     * @param model the model we pass to the builder.
     */
    public OneBuilder(ProcessInterface model) {
      this.model = model;
    }

    /**
     * Constructs a final document.
     *
     * @return the newly constructed document
     */
    @Override
    public ProcessInterface build() {
      return this.model;
    }

    /**
     * Specify the bounding box to be used for the animation.
     *
     * @param x      The leftmost x value
     * @param y      The topmost y value
     * @param width  The width of the bounding box
     * @param height The height of the bounding box
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> setBounds(int x, int y, int width, int height) {
      this.model.setCanvasX(x);
      this.model.setCanvasY(y);
      this.model.setCanvasWidth(width);
      this.model.setCanvasHeight(height);
      return this;
    }

    /**
     * Adds a new shape to the growing document.
     *
     * @param name The unique name of the shape to be added. No shape with this name should already
     *             exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
     *             shapes is unspecified, but should include "ellipse" and "rectangle" as a
     *             minimum.
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> declareShape(String name, String type) {
      if (type.equalsIgnoreCase("rectangle")) {
        this.model.addShape(new Rectangle(name));
      } else if (type.equalsIgnoreCase("ellipse")) {
        this.model.addShape(new Ellipse(name));
      } else {
        throw new IllegalArgumentException("Must be rectangle or ellipse");
      }
      return this;
    }

    /**
     * Adds a transformation to the growing document.
     *
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
     * @param t1   The start time of this transformation
     * @param x1   The initial x-position of the shape
     * @param y1   The initial y-position of the shape
     * @param w1   The initial width of the shape
     * @param h1   The initial height of the shape
     * @param r1   The initial red color-value of the shape
     * @param g1   The initial green color-value of the shape
     * @param b1   The initial blue color-value of the shape
     * @param t2   The end time of this transformation
     * @param x2   The final x-position of the shape
     * @param y2   The final y-position of the shape
     * @param w2   The final width of the shape
     * @param h2   The final height of the shape
     * @param r2   The final red color-value of the shape
     * @param g2   The final green color-value of the shape
     * @param b2   The final blue color-value of the shape
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {
      if (t2 > model.getEndTime()) {
        model.setEndTime(t2);
      }
      AbstractShape currentShape = this.model.getMapOfShape().get(name);
      if (!currentShape.getInitFlag() || currentShape.getAppearTime() > t1) {
        currentShape.setX(x1);
        currentShape.setY(y1);
        currentShape.setWidth(w1);
        currentShape.setHeight(h1);
        currentShape.setR(r1);
        currentShape.setG(g1);
        currentShape.setB(b1);
        currentShape.setColor(r1, g1, b1);
        currentShape.setAppearTime(t1);
        currentShape.setDisappearTime(t2);
        currentShape.setInitFlag(true);
      }
      if (currentShape.getDisappearTime() < t2) {
        currentShape.setDisappearTime(t2);
      }
      if (x2 - x1 != 0 || y2 - y1 != 0) {
        model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      if (w2 - w1 != 0 || h2 - h1 != 0) {
        model.addChangeSize(model.getCertainShape(name), w1, h1, w2, h2, t1, t2);
      }
      if (r2 - r1 != 0 || g2 - g1 != 0 || b2 - b1 != 0) {
        model.addChangeColor(model.getCertainShape(name), r1, g1, b1, r2, g2, b2, t1, t2);
      }
      if (t1 - t2 != 0 && (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2
          && b1 == b2)) {
        this.model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      if (t1 == t2) {
        this.model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      return this;
    }
  }
}