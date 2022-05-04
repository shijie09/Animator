package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.util.List;

/**
 * Represents a text view .
 */
public class TextView implements ViewInterface {

  ProcessInterface processModel;


  /**
   *  Constructor of the textview.
   * @param processModel the model used in the view.
   */
  public TextView(ProcessInterface processModel) {
    if (processModel == null) {
      throw new IllegalArgumentException("Input is null.");
    }
    this.processModel = processModel;
  }


  /**
   * Get the view in string,not for visual view.
   * @return the view in string.
   */
  @Override
  public String viewInString() {
    return this.processModel.toString();
  }

  /**
   * Get the current tick shapes.Used in visual view.
   * @param shapeList the current tick shapes.
   */
  @Override
  public void getCurrentView(List<AbstractShape> shapeList) {
    throw new IllegalArgumentException("Textview does not support get current view");
  }

  /**
   * Get the model.
   * @return the model.
   */
  @Override
  public ProcessInterface getModel() {
    return this.processModel;
  }

  /**
   * Get the output file.
   * @return the output file.
   */
  @Override
  public String getOutputFile() {
    throw new IllegalArgumentException("Outputfile is not supported in textview.");
  }

  @Override
  public String typeOfView() {
    return ViewType.TEXTVIEW.name();
  }


}
