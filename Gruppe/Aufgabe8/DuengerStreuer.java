@AuthorClass(author="Jakub Zarzycki")
public class DuengerStreuer extends Maschine{
  private final double behaelter;

  public DuengerStreuer(double vol) {
    this.behaelter = vol;
  }

  public MaybeNumber getBehaelter() { return new Some(this.behaelter); }
}