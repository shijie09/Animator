package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.ProcessImpl;
import cs5004.animator.model.ProcessInterface;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * The entry of the final project.
 */
public final class EasyAnimator {

  /**
   * The main method of the project.
   * @param args the inputs.
   * @throws IOException when the args are not correct.
   */
  public static void main(String[] args) throws IOException {
    ProcessInterface model = new ProcessImpl();
    String inputFile = "";
    String outputFile = "";
    double speed = 0;
    String viewType = "";
    try {
      for (int i = 0; i < args.length; i += 2) {
        if (args[i].equalsIgnoreCase("-in")) {
          inputFile = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-out")) {
          outputFile = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-view")) {
          viewType = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-speed")) {
          speed = Integer.parseInt(args[i + 1]);
        } else {
          throw new IllegalArgumentException("Arguments is not valid");
        }
      }

    }  catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(
          null, "Speed is not an integer", "ArgumentError", JOptionPane.ERROR_MESSAGE);

    }
    catch (IndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(
          null,
          "Command-Line error: arguments should be the right number.",
          "ArgumentError",
          JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null,
          "Something wrong-Check it.",
          "UnknownError",
          JOptionPane.ERROR_MESSAGE);
    }

    if (inputFile.equalsIgnoreCase("") || !inputFile.contains(".txt")) {
      JOptionPane.showMessageDialog(
          null, "Invalid inputFile", "InputFileError", JOptionPane.ERROR_MESSAGE);
    }

    if (speed == 0) {
      speed = 1;
    }

    try {
      AnimationBuilder<ProcessInterface> builder =
          new ProcessImpl.OneBuilder(model);
      String basicPath = new File("").getAbsolutePath();
      Readable readable = new FileReader(basicPath + "/" + inputFile);
      AnimationReader.parseFile(readable, builder);

    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Model Error", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(
          null, "Invalid Input file", "Input File Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    model.setSpeed(speed);
    ViewInterface view = ViewFactory.getView(model, viewType, outputFile, speed);
    Controller controller = new Controller(view, model);
    controller.runAnimation();
  }
}
