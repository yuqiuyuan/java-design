import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ApiGateway aggregates calls to microservices based on the needs of the individual clients
 */
@RestController
public class ApiGateway {

  @Resource
  private ImageClient imageClient;
  @Resource
  private PriceClient priceClient;

  /**
   * Retrieves products information that desktop clients need.
   *
   * @return Product information for clients on a desktop
   */
  @GetMapping("/desktop")
  public DesktopProduct getProduceDesktop () {
    var desktopProduct = new DesktopProduct();
    desktopProduct.setImagePath(imageClient.getImageUrl());
    desktopProduct.setPrice(priceClient.getPrice());
    return desktopProduct;
  }


  /**
   * Retrieves product information that mobile need
   *
   * @return Product information for clients on a mobile device
   */
  @GetMapping("/mobile")
  public MobileProduct getProductMobile () {
    MobileProduct mobileProduct = new MobileProduct();
    mobileProduct.setPrice(priceClient.getPrice());
    return mobileProduct;
  }
}
