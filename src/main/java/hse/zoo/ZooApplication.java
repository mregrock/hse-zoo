package hse.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Zoo Application.
 */
@SpringBootApplication
public class ZooApplication {
  /**
   * Main method to run the Zoo Application.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(ZooApplication.class, args);
  }
}