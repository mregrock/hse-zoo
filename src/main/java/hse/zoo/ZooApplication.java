package hse.zoo;

import hse.zoo.view.ConsoleView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
    ConfigurableApplicationContext context = SpringApplication.run(ZooApplication.class, args);
    ConsoleView consoleView = context.getBean(ConsoleView.class);
    consoleView.start();
  }
}