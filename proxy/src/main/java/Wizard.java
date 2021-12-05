import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Wizard {

  private final String name;

  @Override
  public String toString () {
    return "Wizard{" +
        "name='" + name + '\'' +
        '}';
  }
}
