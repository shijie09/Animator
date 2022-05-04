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
 * A test for Svg view.
 */
public class SvgViewTest {

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
    rec1 = new Rectangle(0, 0, 10, 10, 10, 10, 10, "R1", 10, 20);
    elli1 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E1", 10, 30);
    model.addShape(rec1);
    model.addShape(elli1);
    model.addMove(elli1, 0, 0, 2, 2, 11, 12);
    model.addMove(elli1, 2, 2, 4, 2, 14, 15);
    model.addMove(elli1, 2, 2, 4, 2, 12, 13);
    model.addChangeColor(elli1, 0, 0, 0, 3, 3, 3, 14, 15);

  }

  /**
   * Test invalid input of speed is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInput2() {
    new SvgView(model, -2);
  }

  /**
   * Test invalid input of model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInput() {
    new SvgView(null, 2);
  }


  /**
   * Test the type of view.
   */
  @Test
  public void typeOfView() {
    SvgView svgView = new SvgView(model, 100);
    assertEquals("SVGVIEW", svgView.typeOfView());
  }

  /**
   * Test the view in string is right or not.
   */
  @Test
  public void viewInString() {
    actual = "<svg width=\"0\" height=\"0\" viewBox=\"0 0 0 0\" version=\"1.1\"\n"
        + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R1\" x=\"0\" y=\"0\" width=\"10\" height=\"10\" fill=\"rgb(10,10,10 )\""
        + " visibility=\"visible\" >\n"
        + "</rect>\n"
        + "<ellipse id=\"E1\" cx=\"0\" cy=\"0\" rx=\"10\" ry=\"10\" fill=\"rgb(10,10,10 )\""
        + " visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"120.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"120.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"110.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"120.0ms\" dur=\"10.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"120.0ms\" dur=\"10.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"10.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,0)\" to=\"rgb(3,3,3)\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>";
    SvgView svgView = new SvgView(model, 100);
    assertEquals("SVGVIEW", svgView.typeOfView());
    assertEquals(actual, svgView.viewInString());
  }

  /**
   * Test the view in string of given buildings-txt input file is right or not.
   */
  @Test
  public void viewInStringOfBuildings() throws FileNotFoundException {

    String basicPath = new File("").getAbsolutePath();
    Readable readable = new FileReader(basicPath + "/buildingstest.txt");
    AnimationReader.parseFile(readable, builder);
    ViewInterface svgView = new SvgView(model, 10);
    actual = "<svg width=\"800\" height=\"800\" viewBox=\"0 0 800 800\" version=\"1.1\"\n"
        + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R1\" x=\"0\" y=\"0\" width=\"10\" height=\"10\" fill=\"rgb(10,10,10 )\" "
        + "visibility=\"visible\" >\n"
        + "</rect>\n"
        + "<ellipse id=\"E1\" cx=\"0\" cy=\"0\" rx=\"10\" ry=\"10\" fill=\"rgb(10,10,10 )\" "
        + "visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cx\""
        + " from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1200.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1200.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1100.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"0\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1200.0ms\" dur=\"100.0ms\" attributeName=\"cx\" "
        + "from=\"2\" to=\"4\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1200.0ms\" dur=\"100.0ms\" attributeName=\"cy\" "
        + "from=\"2\" to=\"2\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1400.0ms\" dur=\"100.0ms\" attributeName=\"fill\""
        + " from=\"rgb(0,0,0)\" to=\"rgb(3,3,3)\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
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

    assertEquals(actual, svgView.viewInString());
  }
}