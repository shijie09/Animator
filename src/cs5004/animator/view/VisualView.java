package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollBar;

/**
 * Represent a visual view.
 */
public class VisualView extends JFrame implements ViewInterface {

  private ProcessInterface model;

  private VisuaViewPanel visuaViewPanel;

  /**
   * Constructor of visual view.
   *  @param model the model.
   *
   */
  public VisualView(ProcessInterface model) {
    super();
    int frameX = model.getCanvasX();
    int frameY = model.getCanvasY();
    int frameWidth = model.getCanvasWidth();
    int frameHeight = model.getCanvasHeight();
    this.model = model;
    this.setTitle("SHIJIEAnimation");
    this.setBounds(frameX, frameY, frameWidth, frameHeight);
    this.getPreferredSize();
    this.visuaViewPanel = new VisuaViewPanel(model.getShapes());
    this.visuaViewPanel.setVisible(true);
    this.add(this.visuaViewPanel, BorderLayout.CENTER);

    class VerticalListener implements AdjustmentListener {

      /**
       * Invoked when the value of the adjustable has changed.
       *
       * @param e the event to be processed
       */
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        setPanelX(e.getValue());
      }

    }

    class HorizonListener implements AdjustmentListener {

      /**
       * Invoked when the value of the adjustable has changed.
       *
       * @param e the event to be processed
       */
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        setPanelY(e.getValue());
      }
    }

    JScrollBar verticalScorllBar = new JScrollBar(JScrollBar.VERTICAL, 0, 30, -100, 100);
    JScrollBar horizonScorllBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 30, -100, 100);
    verticalScorllBar.addAdjustmentListener(new HorizonListener());
    horizonScorllBar.addAdjustmentListener(new VerticalListener());
    this.getContentPane().add(verticalScorllBar, BorderLayout.WEST);
    this.getContentPane().add(horizonScorllBar, BorderLayout.NORTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public String typeOfView() {
    return ViewType.VISUALVIEW.name();
  }

  /**
   * Get the view in string,not for visual view.
   *
   * @return the view in string.
   */
  @Override
  public String viewInString() {
    throw new IllegalArgumentException("Visualview does not support view in string.");
  }

  /**
   * Get the current tick shapes.Used in visual view.
   *
   * @param shapeList he current tick shapes.
   */
  @Override
  public void getCurrentView(List<AbstractShape> shapeList) {
    this.revalidate();
    this.visuaViewPanel.setShapeList(shapeList);
    this.repaint();
  }

  private void setPanelX(int x) {
    this.visuaViewPanel.setPanelX(x);
  }

  private void setPanelY(int y) {
    this.visuaViewPanel.setPanelY(y);
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
    throw new IllegalArgumentException("Outputfile is not supported in textview.");
  }


}
