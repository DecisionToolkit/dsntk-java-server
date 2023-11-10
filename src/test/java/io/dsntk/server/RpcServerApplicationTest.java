package io.dsntk.server;

import io.dsntk.server.rest.controllers.RpcController;
import io.dsntk.server.rest.controllers.SystemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = RpcServerApplication.class)
public class RpcServerApplicationTest {

  @Autowired
  private SystemController systemController;

  @Autowired
  private RpcController rpcController;

  @Test
  public void contextLoads() {
    assertThat(systemController).isNotNull();
    assertNotNull(rpcController);
  }
}
