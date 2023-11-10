package io.dsntk.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class of the Java RPC server.
 */
@Slf4j
@SpringBootApplication
public class RpcServerApplication implements ApplicationRunner {

  /**
   * Port number of the server.
   */
  @Value("${server.port}")
  private Integer port;

  @Value("${app.version}")
  private String appVersion;

  @Value("${app.name}")
  private String appName;

  /**
   * Application entrypoint.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(RpcServerApplication.class, args);
  }

  /**
   * Callback function called after server is started.
   *
   * @param args Arguments passed to application.
   */
  @Override
  public void run(ApplicationArguments args) {
    log.info("{}, version {}", appName, appVersion);
    log.info("Java RPC server started on port: {}", port);
  }
}
