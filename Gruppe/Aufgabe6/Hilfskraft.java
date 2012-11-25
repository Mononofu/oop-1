import java.util.List;

public class Hilfskraft extends Bediener {
  public Hilfskraft(String n, Skin s, Software sw) {
    super(n, s, sw);
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }
}
