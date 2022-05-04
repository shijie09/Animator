package cs5004.animator.view;

/**
 * Represent a enum of view type.
 */
public enum ViewType {
  TEXTVIEW,VISUALVIEW,SVGVIEW;

  /**
   * Get the string of view type.
   * @return the string of view type.
   */
  public String toString() {
    return this.name();
  }
}
