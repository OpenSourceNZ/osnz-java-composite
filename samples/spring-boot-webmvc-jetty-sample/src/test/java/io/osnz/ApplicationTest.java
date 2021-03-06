package io.osnz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Kefeng Deng (deng@51any.com)
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void shouldReturnCorrectResponseBody() {
    String body = this.restTemplate.getForObject("/", String.class);
    Assertions.assertEquals("Hello World", body);
  }

  @Test
  public void shouldReturnUpStatus() {
    String body = this.restTemplate.getForObject("/actuator/health", String.class);
    Assertions.assertEquals("{\"status\":\"UP\"}", body);
  }

}
