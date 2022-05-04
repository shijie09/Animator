package cs5004.animator.view;

import static org.junit.Assert.assertEquals;

import cs5004.animator.model.Ellipse;
import cs5004.animator.model.ProcessImpl;
import cs5004.animator.model.ProcessImpl.OneBuilder;
import cs5004.animator.model.ProcessInterface;
import cs5004.animator.model.Rectangle;
import cs5004.animator.util.AnimationReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;



/**
 * A test for textview.
 */
public class TextViewTest {

  String actual = "";
  ProcessInterface model;
  OneBuilder builder;
  Rectangle rec1;
  Ellipse elli1;

  /**
   * Construct some instances for test.
   */
  @Before
  public void setUp() {
    model = new ProcessImpl();
    builder = new OneBuilder(model);

  }

  /**
   * Test the view in string is right or not.
   */
  @Test
  public void viewInString() {
    model = new ProcessImpl();
    builder = new OneBuilder(model);
    actual =
        "Create RECTANGLE R1 with color ( Red: 10 Green: 10 Blue:10 ) and with  corner (0,0), "
            + "width 10 and height 10.\n"
            + "Create ELLIPSE E1 with color ( Red: 10 Green: 10 Blue:10 ) and with  center (0,0), "
            + "radius 10 and  10.\n"
            + "\n"
            + "R1 appears at time t = 10 and disappear at time t = 20.\n"
            + "E1 appears at time t = 10 and disappear at time t = 30.\n"
            + "\n"
            + "E1 moves from (0,0) to ( 2,2) from time t= 11 to time t= 12.\n"
            + "E1 moves from (2,2) to ( 4,2) from time t= 12 to time t= 13.\n"
            + "E1 moves from (2,2) to ( 4,2) from time t= 14 to time t= 15.\n"
            + "E1 changes from color(Red: 0 Green: 0 Blue:0) to color(Red: 3 Green: 3 Blue:3 from "
            + "time t= 14 to 15.\n";
    rec1 = new Rectangle(0, 0, 10, 10, 10, 10, 10, "R1", 10, 20);
    elli1 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E1", 10, 30);
    model.addShape(rec1);
    model.addShape(elli1);
    model.addMove(elli1, 0, 0, 2, 2, 11, 12);
    model.addMove(elli1, 2, 2, 4, 2, 14, 15);
    model.addMove(elli1, 2, 2, 4, 2, 12, 13);
    model.addChangeColor(elli1, 0, 0, 0, 3, 3, 3, 14, 15);
    assertEquals(actual, model.toString());
    TextView textView = new TextView(model);
    assertEquals("TEXTVIEW", textView.typeOfView());
    assertEquals(actual, textView.viewInString());
  }

  /**
   * Test the file provided is in right text view or not .
   *
   * @throws FileNotFoundException when it is wrong.
   */
  @Test
  public void viewInStringOfBuildings() throws FileNotFoundException {

    String basicPath = new File("").getAbsolutePath();
    Readable readable = new FileReader(basicPath + "/buildingstest.txt");
    AnimationReader.parseFile(readable, builder);
    ViewInterface textview = new TextView(model);
    assertEquals(
        "Create RECTANGLE background with color ( Red: 33 Green: 94 Blue:248 ) and with  "
            + "corner (0,0), width 800 and height 800.\n"
            + "Create RECTANGLE B0 with color ( Red: 0 Green: 0 Blue:0 ) and with  corner (80,424)"
            + ", "
            + "width 100 and height 326.\n"
            + "Create RECTANGLE B1 with color ( Red: 0 Green: 0 Blue:0 ) and with  corner (260,365)"
            + ", "
            + "width 100 and height 385.\n"
            + "Create RECTANGLE B2 with color ( Red: 0 Green: 0 Blue:0 ) and with  corner (440,375)"
            + ", "
            + "width 100 and height 375.\n"
            + "Create RECTANGLE B3 with color ( Red: 0 Green: 0 Blue:0 ) and with  corner (620,445)"
            + ","
            + " width 100 and height 305.\n"
            + "\n"
            + "background appears at time t = 1 and disappear at time t = 200.\n"
            + "B0 appears at time t = 1 and disappear at time t = 200.\n"
            + "B1 appears at time t = 1 and disappear at time t = 200.\n"
            + "B2 appears at time t = 1 and disappear at time t = 200.\n"
            + "B3 appears at time t = 1 and disappear at time t = 200.\n"
            + "\n"
            + "background moves from (0,0) to ( 0,0) from time t= 1 to time t= 1.\n"
            + "background moves from (0,0) to ( 0,0) from time t= 1 to time t= 50.\n"
            + "B0 moves from (80,424) to ( 80,424) from time t= 1 to time t= 1.\n"
            + "B0 moves from (80,424) to ( 80,424) from time t= 1 to time t= 200.\n"
            + "B1 moves from (260,365) to ( 260,365) from time t= 1 to time t= 1.\n"
            + "B1 moves from (260,365) to ( 260,365) from time t= 1 to time t= 200.\n"
            + "B2 moves from (440,375) to ( 440,375) from time t= 1 to time t= 1.\n"
            + "B2 moves from (440,375) to ( 440,375) from time t= 1 to time t= 200.\n"
            + "B3 moves from (620,445) to ( 620,445) from time t= 1 to time t= 1.\n"
            + "B3 moves from (620,445) to ( 620,445) from time t= 1 to time t= 200.\n"
            + "background changes from color(Red: 33 Green: 94 Blue:248) to color(Red: 16 "
            + "Green: 45 Blue:248 from time t= 50 to 90.\n"
            + "background moves from (0,0) to ( 0,0) from time t= 90 to time t= 200.\n",
        textview.viewInString());
  }

  /**
   * Test getting the right type of view.
   */
  @Test
  public void typeOfView() {
    model = new ProcessImpl();
    builder = new OneBuilder(model);
    actual =
        "Create RECTANGLE R1 with color ( Red: 10 Green: 10 Blue:10 ) and with  corner (0,0),"
            + " width 10 and height 10.\n"
            + "Create ELLIPSE E1 with color ( Red: 10 Green: 10 Blue:10 ) and with  center (0,0),"
            + " radius 10 and  10.\n"
            + "\n"
            + "R1 appears at time t = 10 and disappear at time t = 20.\n"
            + "E1 appears at time t = 10 and disappear at time t = 30.\n"
            + "\n"
            + "E1 moves from (0,0) to ( 2,2) from time t= 11 to time t= 12.\n"
            + "E1 moves from (2,2) to ( 4,2) from time t= 12 to time t= 13.\n"
            + "E1 moves from (2,2) to ( 4,2) from time t= 14 to time t= 15.\n"
            + "E1 changes from color(Red: 0 Green: 0 Blue:0) to color(Red: 3 Green: 3 Blue:3 from "
            + "time t= 14 to 15.\n";
    rec1 = new Rectangle(0, 0, 10, 10, 10, 10, 10, "R1", 10, 20);
    elli1 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E1", 10, 30);
    model.addShape(rec1);
    model.addShape(elli1);
    model.addMove(elli1, 0, 0, 2, 2, 11, 12);
    model.addMove(elli1, 2, 2, 4, 2, 14, 15);
    model.addMove(elli1, 2, 2, 4, 2, 12, 13);
    model.addChangeColor(elli1, 0, 0, 0, 3, 3, 3, 14, 15);
    assertEquals(actual, model.toString());
    TextView textView = new TextView(model);
    assertEquals("TEXTVIEW", textView.typeOfView());
  }
}