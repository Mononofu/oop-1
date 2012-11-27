/* auto-generated - change in class_generator.py */
import java.util.List;

public abstract class Android {
  private final String seriennr;
  private Skin s;
  private Software sw;
  private double leistung;

  public Android(String n, Skin s, Software sw,double leistung) {
    this.seriennr = n;
    this.s = s;
    this.sw = sw;
    this.leistung=leistung;
  }

  public String getSerial() {
    return seriennr;
  }

  public double leistung(){
    return leistung;
  }

  public Sicherheitsstufe getSecurity() {
    return sw.getSecurity();
  }

  public List<Android> accept(Inspector visitor) {
    return visitor.visit(this);
  }

  public List<Android> inspectSkin(SkinInspector visitor) {
    return s.accept(visitor);
  }

  public List<Android> inspectSoftware(SoftwareInspector visitor) {
    return sw.accept(visitor);
  }

  public List<Android> inspectSecurity(SicherheitsstufenInspector visitor) {
    return sw.inspectSecurity(visitor);
  }
}
