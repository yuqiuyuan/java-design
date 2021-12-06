import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * An adapter to communicate with the Image microservice
 */
@Component
@Slf4j
public class ImageClientImpl implements ImageClient {

  @Override
  public String getImageUrl () {
    var httpClient = HttpClient.newHttpClient();
    var httpGet = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:50005/image-path")).build();
    try {
      HttpResponse<String> httpResponse = httpClient.send(httpGet, BodyHandlers.ofString());
      logResponse(httpResponse);
    } catch (IOException e) {
      log.error("Failure occurred while getting image path", e);
      e.printStackTrace();
    } catch (InterruptedException e) {
      log.error("Failure occurred while getting image path", e);
      Thread.currentThread().interrupt();
    }
    return null;
  }

  private void logResponse (HttpResponse<String> httpResponse) {
    if (isSuccessResponse(httpResponse.statusCode())) {
      log.info("Image path received successfully~!");
    } else {
      log.warn("Image path request failed~!");
    }
  }

  private boolean isSuccessResponse (int responseCode) {
    return responseCode >= 200 && responseCode <= 299;
  }
}
