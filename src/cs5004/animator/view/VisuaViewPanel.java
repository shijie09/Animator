package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Represent the class of panel.
 */
public class VisuaViewPanel extends JPanel {

  int panelX;
  int panelY;
  List<AbstractShape> shapeList;

  /**
   * Constructor of panel.
   *
   * @param shapeList shape list used in the panel.
   */
  public VisuaViewPanel(List<AbstractShape> shapeList) {
    super(true);
    this.shapeList = shapeList;
    setBackground(Color.WHITE);
    setBorder(new LineBorder(Color.DARK_GRAY, 10));
    setVisible(true);
  }

  public void setShapeList(List<AbstractShape> shapeList) {
    this.shapeList = shapeList;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Graphics2D graphics2D = (Graphics2D) graphics;
    if (this.shapeList == null) {
      throw new IllegalArgumentException("NOTHING WILL BE PAINT");

    }
    for (AbstractShape shape : shapeList) {
      if (shape.getShapeType() == Shapes.RECTANGLE) {

        graphics2D.setColor(shape.getColor());
        Rectangle2D shapeForDraw = new Rectangle2D.Double(panelX + shape.getX(),
            panelY + shape.getY(), shape.getWidth(),
            shape.getHeight());
        graphics2D.draw(shapeForDraw);
        graphics2D.fill(shapeForDraw);

      } else if (shape.getShapeType() == Shapes.ELLIPSE) {
        graphics2D.setColor(shape.getColor());
        Ellipse2D shapeForDraw = new Double(panelX + shape.getX(), panelY + shape.getY(),
            shape.getWidth(),
            shape.getHeight());
        graphics2D.draw(shapeForDraw);
        graphics2D.fill(shapeForDraw);


      }
    }

  }

  public void setPanelX(int panelX) {
    this.panelX = panelX;
  }

  public void setPanelY(int panelY) {
    this.panelY = panelY;
  }

  public int getPanelX() {
    return panelX;
  }

  public int getPanelY() {
    return panelY;
  }
}
