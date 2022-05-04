package cs5004.animator.view;

import cs5004.animator.model.ProcessInterface;

/**
 * Represent the viewfactory.
 */
public class ViewFactory {

  /**
   * It is a constructor of the view factory.
   * @param model the model used in the view factory.
   * @param viewType the type of the shape.
   * @param output the output.
   * @param speed the speed of the animaiton.
   * @return the right view.
   */
  public static ViewInterface getView(ProcessInterface model, String viewType, String output,
      double speed) {
    ViewInterface view = null;
    try {
      if (viewType.equalsIgnoreCase("svg") && (output == null || output.isEmpty())) {
        view = new SvgView(model, speed);
      } else if (viewType.equalsIgnoreCase("svg")) {
        view = new SvgView(model, speed, output);
      } else if (viewType.equalsIgnoreCase("text")) {
        view = new TextView(model);
      } else if (viewType.equalsIgnoreCase("visual")) {
        view = new VisualView(model);
      }
    } catch (Exception e) {
      System.out.println("Something wrong.");
    }
    return view;
  }

}
