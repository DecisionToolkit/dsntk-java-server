package io.dsntk.server.rest.controllers;

import io.dsntk.server.RpcServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = RpcServerApplication.class)
public class SystemControllerTest {

  @Value(value = "${local.server.port}")
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void greetingShouldReturnDefaultMessage() {
    assertThat(this.restTemplate.getForObject("http://127.0.0.1:" + port + "/api/rest/v1/system/info", String.class))
      .contains("{\"data\":{\"name\":\"Java RPC server for Decision Toolkit\",\"version\":\"0.0.1\"}}");
  }
}
