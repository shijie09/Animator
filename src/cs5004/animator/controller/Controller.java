package cs5004.animator.controller;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;
import cs5004.animator.view.ViewInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Represent the controller.
 */
public class Controller {

  private ViewInterface view;
  private ProcessInterface model;
  private double speed;
  private int tick;

  /**
   * Constructor of the controller.
   *
   * @param view  the view.
   * @param model the model.
   */
  public Controller(ViewInterface view, ProcessInterface model) {

    this.view = view;
    this.model = model;
    this.tick = 0;
    this.speed = model.getSpeed();

  }

  /**
   * Determine which type of view to be showed.
   *
   * @throws IOException when something wrong with svgview.
   */
  public void runAnimation() throws IOException {
    if (view.typeOfView().equalsIgnoreCase("textview")) {
      runTextView();
    } else if (view.typeOfView().equalsIgnoreCase("svgview")) {
      runSvgView();
    } else if (view.typeOfView().equalsIgnoreCase("visualview")) {
      runVisualView();
    }
  }

  private void runTextView() {
    System.out.println(view.viewInString());
  }

  private void runSvgView() throws IOException {
    if (this.view.getOutputFile().equalsIgnoreCase("")) {
      System.out.println(this.view.viewInString());
    } else {
      BufferedWriter writer = new BufferedWriter(new FileWriter(this.view.getOutputFile()));
      writer.write(this.view.viewInString());
      writer.close();
    }
  }

  private void runVisualView() {

    while (tick <= this.model.getEndTime()) {
      List<AbstractShape> shapeList = model.getState(tick);
      this.view.getCurrentView(shapeList);
      tick++;
      try {
        Thread.sleep((long) ((long) 100 / speed));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public ViewInterface getView() {
    return this.view;
  }

  public ProcessInterface getModel() {
    return this.model;
  }

}
