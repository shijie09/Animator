package cs5004.animator.controller;

import static org.junit.Assert.assertEquals;

import cs5004.animator.model.ProcessImpl;
import cs5004.animator.model.ProcessImpl.OneBuilder;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Test for controller.
 */
public class ControllerTest {

  ProcessImpl model;
  AnimationBuilder builder;
  String basicPath;

  /**
   * Construct some instances for test.
   *
   */
  @Before
  public void setUp() {
    model = new ProcessImpl();
    builder = new OneBuilder(model);
    basicPath = new File("").getAbsolutePath();
  }

  /**
   * Test the set up of the controller.
   */
  @Test
  public void testSetup() {
    model.setSpeed(10);
    ViewInterface viewText = ViewFactory.getView(model, "text", "", 10);
    Controller controller = new Controller(viewText, model);
    assertEquals(10, controller.getModel().getSpeed(), 0.01);

  }

  /**
   * Test the controller right or not when run animation of textview.
   *
   * @throws IOException when it is wrong.
   */
  @Test
  public void runAnimationOfText() throws IOException {
    Readable readable = new FileReader(basicPath + "/buildingstest.txt");
    AnimationReader.parseFile(readable, builder);
    model.setSpeed(10);
    ViewInterface viewText = ViewFactory.getView(model, "text", "", 10);
    Controller controller = new Controller(viewText, model);
    assertEquals(10, controller.getModel().getSpeed(), 0.01);
    controller.runAnimation();
    String actual =
        "Create RECTANGLE background with color ( Red: 33 Green: 94 Blue:248 ) and with  "
            + "corner (0,0), width 800 and height 800.\n"
            + "Create RECTANGLE B0 with color ( Red: 0 Green: 0 Blue:0 ) and with  "
            + "corner (80,424), width 100 and height 326.\n"
            + "Create RECTANGLE B1 with color ( Red: 0 Green: 0 Blue:0 ) and with "
            + " corner (260,365), width 100 and height 385.\n"
            + "Create RECTANGLE B2 with color ( Red: 0 Green: 0 Blue:0 ) and with "
            + " corner (440,375), width 100 and height 375.\n"
            + "Create RECTANGLE B3 with color ( Red: 0 Green: 0 Blue:0 ) and with "
            + " corner (620,445), width 100 and height 305.\n"
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
            + "background changes from color(Red: 33 Green: 94 Blue:248) to color(Red: 16"
            + " Green: 45 Blue:248 from time t= 50 to 90.\n"
            + "background moves from (0,0) to ( 0,0) from time t= 90 to time t= 200.\n";
    assertEquals(actual, viewText.viewInString());


  }

  /**
   * Test the controller right or not when run animation of svgview.
   *
   * @throws IOException when it is wrong.
   */
  @Test
  public void runAnimationOfSvg() throws IOException {
    Readable readable = new FileReader(basicPath + "/buildingstest.txt");
    AnimationReader.parseFile(readable, builder);
    model.setSpeed(10);
    ViewInterface viewSvg = ViewFactory.getView(model, "svg", "", 10);
    Controller controller = new Controller(viewSvg, model);
    assertEquals(10, controller.getModel().getSpeed(), 0.01);
    controller.runAnimation();
    String actual = "<svg width=\"800\" height=\"800\" viewBox=\"0 0 800 800\" version=\"1.1\"\n"
        + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\""
        + " fill=\"rgb(33,94,248 )\" visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\""
        + " from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"x\""
        + " from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"x\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"5000.0ms\" dur=\"4000.0ms\" "
        + "attributeName=\"fill\" "
        + "from=\"rgb(33,94,248)\" to=\"rgb(16,45,248)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"x\""
        + " from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" attributeName=\"y\""
        + " from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"5000.0ms\" dur=\"4000.0ms\" attributeName=\""
        + "fill\" from=\"rgb(33,94,248)\" to=\"rgb(16,45,248)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"9000.0ms\" dur=\"11000.0ms\" attributeName=\"x\""
        + " from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"9000.0ms\" dur=\"11000.0ms\" attributeName=\"y\" "
        + "from=\"0\" to=\"0\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "<rect id=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0 )\" "
        + "visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"80\" to=\"80\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"424\" to=\"424\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"80\" to=\"80\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"424\" to=\"424\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"x\" "
        + "from=\"80\" to=\"80\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"y\""
        + " from=\"424\" to=\"424\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "<rect id=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0 )\""
        + " visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\""
        + " from=\"260\" to=\"260\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"365\" to=\"365\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"260\" to=\"260\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"365\" to=\"365\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"x\""
        + " from=\"260\" to=\"260\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"y\""
        + " from=\"365\" to=\"365\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "<rect id=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0 )\" "
        + "visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\""
        + " from=\"440\" to=\"440\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"375\" to=\"375\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"440\" to=\"440\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\""
        + " from=\"375\" to=\"375\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"x\" "
        + "from=\"440\" to=\"440\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"y\" "
        + "from=\"375\" to=\"375\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "<rect id=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0 )\""
        + " visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"620\" to=\"620\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"445\" to=\"445\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
        + "from=\"620\" to=\"620\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
        + "from=\"445\" to=\"445\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"x\" "
        + "from=\"620\" to=\"620\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" attributeName=\"y\" "
        + "from=\"445\" to=\"445\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>";
    assertEquals(actual, viewSvg.viewInString());

  }

}