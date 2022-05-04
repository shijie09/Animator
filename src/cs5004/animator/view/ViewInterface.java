package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.util.List;

/**
 * Represent a view interface.
 */
public interface ViewInterface {

  /**
   * Get the string of the shape type.
   * @return the string of the shape type.
   */
  String typeOfView();

  /**
   * Get the view in string,not for visual view.
   * @return the view in string.
   */
  String viewInString();

  /**
   * Get the current tick shapes.Used in visual view.
   * @param shapeList he current tick shapes.
   */
  void getCurrentView(List<AbstractShape> shapeList);

  /**
   * Get the model.
   * @return the model.
   */
  ProcessInterface getModel();

  /**
   * Get the output file.
   * @return the output file.
   */
  String getOutputFile();
}
