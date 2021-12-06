import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceClientImpl implements PriceClient {

  @Override
  public String getPrice () {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:50006/price")).build();
    try {
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
      logResponse(httpResponse);
    } catch (IOException e) {
      log.error("Failure occurred while getting price info", e);
      e.printStackTrace();
    } catch (InterruptedException e) {
      log.error("Failure occurred while getting price info", e);
      Thread.currentThread().interrupt();
    }
    return null;
  }

  private void logResponse (HttpResponse<String> httpResponse) {
    if (isSuccessResponse(httpResponse.statusCode())) {
      log.info("Price info received successfully");
    } else {
      log.warn("Price info request failed");
    }
  }

  private boolean isSuccessResponse (int statusCode) {
    return statusCode >= 200 && statusCode <= 299;
  }
}
