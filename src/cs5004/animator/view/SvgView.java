package cs5004.animator.view;

import cs5004.animator.model.AbstractMotion;
import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;
import cs5004.animator.model.Shapes;

import java.util.List;

/**
 * Represents a Svgview class.
 */
public class SvgView implements ViewInterface {

  private ProcessInterface model;
  private double speed;
  private String outputFile;

  /**
   * Constructor of svg view.
   *
   * @param model the model of the animation.
   * @param speed the speed of the animation.
   */
  public SvgView(ProcessInterface model, double speed) {
    if (model == null || speed <= 0) {
      throw new IllegalArgumentException("Input is wrong");
    }
    this.model = model;
    this.speed = speed;
    this.outputFile = "";
  }

  /**
   * Another constructor of the svg view.
   *
   * @param model      the model of the animation.
   * @param speed      the speed of the animation.
   * @param outputFile outputfile.
   */
  public SvgView(ProcessInterface model, double speed, String outputFile) {
    if (model == null || speed <= 0) {
      throw new IllegalArgumentException("Input is wrong");
    }
    this.model = model;
    this.speed = speed;
    this.outputFile = outputFile;
  }

  /**
   * Get the string of the shape type.
   *
   * @return the string of the shape type.
   */
  @Override
  public String typeOfView() {
    return ViewType.SVGVIEW.name();
  }

  @Override
  public String viewInString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<svg width=\"");
    stringBuilder.append(model.getCanvasWidth());
    stringBuilder.append("\" height=\"");
    stringBuilder.append(model.getCanvasHeight());
    stringBuilder.append("\" viewBox=\"");
    stringBuilder.append(model.getCanvasX());
    stringBuilder.append(" ");
    stringBuilder.append(model.getCanvasY());
    stringBuilder.append(" ");
    stringBuilder.append(model.getCanvasWidth());
    stringBuilder.append(" ");
    stringBuilder.append(model.getCanvasHeight());
    stringBuilder.append("\" version=\"1.1\"\n\txmlns=\"http://www.w3.org/2000/svg\">\n");
    for (AbstractShape shape : model.getShapes()) {
      if (shape == null) {
        throw new IllegalArgumentException("Shapelist is null");
      }
      StringBuilder stringBuilderShape = new StringBuilder();
      if (shape.getShapeType() == Shapes.RECTANGLE) {
        stringBuilderShape.append("<rect id=\"");
        stringBuilderShape.append(shape.getUniqueCode());
        stringBuilderShape.append("\" x=\"");
        stringBuilderShape.append(shape.getX());
        stringBuilderShape.append("\" y=\"");
        stringBuilderShape.append(shape.getY());
        stringBuilderShape.append("\" width=\"");
        stringBuilderShape.append(shape.getWidth());
        stringBuilderShape.append("\" height=\"");
        stringBuilderShape.append(shape.getHeight());
        stringBuilderShape.append("\" fill=\"rgb(");
        stringBuilderShape.append(shape.getR());
        stringBuilderShape.append(",");
        stringBuilderShape.append(shape.getG());
        stringBuilderShape.append(",");
        stringBuilderShape.append(shape.getB());
        stringBuilderShape.append(" )\" visibility=\"visible\" >\n");
      } else if (shape.getShapeType() == Shapes.ELLIPSE) {
        stringBuilderShape.append("<ellipse id=\"");
        stringBuilderShape.append(shape.getUniqueCode());
        stringBuilderShape.append("\" cx=\"");
        stringBuilderShape.append(shape.getX());
        stringBuilderShape.append("\" cy=\"");
        stringBuilderShape.append(shape.getY());
        stringBuilderShape.append("\" rx=\"");
        stringBuilderShape.append(shape.getWidth());
        stringBuilderShape.append("\" ry=\"");
        stringBuilderShape.append(shape.getHeight());
        stringBuilderShape.append("\" fill=\"rgb(");
        stringBuilderShape.append(shape.getR());
        stringBuilderShape.append(",");
        stringBuilderShape.append(shape.getG());
        stringBuilderShape.append(",");
        stringBuilderShape.append(shape.getB());
        stringBuilderShape.append(" )\" visibility=\"visible\" >\n");
      }

      stringBuilder.append(stringBuilderShape);
      StringBuilder stringBuilderMotion = new StringBuilder();
      List<AbstractMotion> shapeList = model.getMotions(shape.getUniqueCode());
      for (AbstractMotion motionSvg : shapeList) {
        switch (motionSvg.getMotion()) {
          case CHANGECOLOR: {
            stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
            stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
            stringBuilderMotion.append("ms\" dur=\"");
            stringBuilderMotion.append(
                (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
            stringBuilderMotion.append("ms\" attributeName=\"fill\" from=\"rgb(");
            stringBuilderMotion.append(motionSvg.getStartR());
            stringBuilderMotion.append(",");
            stringBuilderMotion.append(motionSvg.getStartG());
            stringBuilderMotion.append(",");
            stringBuilderMotion.append(motionSvg.getStartB());
            stringBuilderMotion.append(")\" to=\"rgb(");
            stringBuilderMotion.append(motionSvg.getEndR());
            stringBuilderMotion.append(",");
            stringBuilderMotion.append(motionSvg.getEndG());
            stringBuilderMotion.append(",");
            stringBuilderMotion.append(motionSvg.getEndB());
            stringBuilderMotion.append(")\" fill=\"freeze\" />\n");
            break;

          }
          case CHANGESIZE: {
            stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
            stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
            stringBuilderMotion.append("ms\" dur=\"");
            stringBuilderMotion.append(
                (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
            if (motionSvg.getShapeType() == Shapes.RECTANGLE) {
              stringBuilderMotion.append("ms\" attributeName=\"width\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartWidth());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndWidth());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
              stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
              stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
              stringBuilderMotion.append("ms\" dur=\"");
              stringBuilderMotion.append(
                  (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
              stringBuilderMotion.append("ms\" attributeName=\"height\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartHeight());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndHeight());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
            } else if (motionSvg.getShapeType() == Shapes.ELLIPSE) {
              stringBuilderMotion.append("ms\" attributeName=\"rx\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartWidth());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndWidth());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
              stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
              stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
              stringBuilderMotion.append("ms\" dur=\"");
              stringBuilderMotion.append(
                  (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);

              stringBuilderMotion.append("ms\" attributeName=\"ry\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartHeight());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndHeight());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
            }
            break;
          }
          case CHANGEPOSITION: {
            stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
            stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
            stringBuilderMotion.append("ms\" dur=\"");
            stringBuilderMotion.append(
                (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
            if (motionSvg.getShapeType() == Shapes.RECTANGLE) {
              stringBuilderMotion.append("ms\" attributeName=\"x\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartX());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndX());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
              stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
              stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
              stringBuilderMotion.append("ms\" dur=\"");
              stringBuilderMotion.append(
                  (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
              stringBuilderMotion.append("ms\" attributeName=\"y\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartY());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndY());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
            } else if (motionSvg.getShapeType() == Shapes.ELLIPSE) {
              stringBuilderMotion.append("ms\" attributeName=\"cx\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartX());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndX());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
              stringBuilderMotion.append("<animate attributeType=\"xml\" begin=\"");
              stringBuilderMotion.append(motionSvg.getStartTime() * 1000 / this.speed);
              stringBuilderMotion.append("ms\" dur=\"");
              stringBuilderMotion.append(
                  (motionSvg.getEndTime() - motionSvg.getStartTime()) * 1000 / this.speed);
              stringBuilderMotion.append("ms\" attributeName=\"cy\" from=\"");
              stringBuilderMotion.append(motionSvg.getStartY());
              stringBuilderMotion.append("\" to=\"");
              stringBuilderMotion.append(motionSvg.getEndY());
              stringBuilderMotion.append("\" fill=\"freeze\" />\n");
            }
            break;
          }
          default: {
            throw new IllegalArgumentException("Should not have such error.");
          }

        }
        stringBuilder.append(stringBuilderMotion);

      }
      if (shape.getShapeType() == Shapes.ELLIPSE) {
        stringBuilder.append("</ellipse>\n");
      } else if (shape.getShapeType() == Shapes.RECTANGLE) {
        stringBuilder.append("</rect>\n");
      }
    }
    stringBuilder.append("</svg>");
    return stringBuilder.toString();
  }

  /**
   * Get the current tick shapes.Used in visual view.
   *
   * @param shapeList he current tick shapes.
   */
  @Override
  public void getCurrentView(List<AbstractShape> shapeList) {
    throw new IllegalArgumentException("SVGView dose not support this getcurrentview method.");

  }

  /**
   * Get the model.
   *
   * @return the model.
   */
  @Override
  public ProcessInterface getModel() {
    return this.model;
  }

  /**
   * Get the output file.
   *
   * @return the output file.
   */
  @Override
  public String getOutputFile() {
    return this.outputFile;
  }
}
