import lombok.Getter;
import lombok.Setter;

/**
 * Encapsulates all of the information that a desktop client needs to display a product
 */
@Getter
@Setter
public class DesktopProduct {

  /**
   * the price of the product
   */
  private String price;
  /**
   * the path to the image of the product
   */
  private String imagePath;
}
