public class Kaempfer extends Beschuetzer {
  public Kaempfer(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public boolean accept(Inspector visitor) {
    visitor.visit(this);
  }
}