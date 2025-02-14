package hse.zoo.model.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hse.zoo.model.animals.herbivores.Elephant;
import hse.zoo.model.animals.herbivores.Rabbit;
import hse.zoo.model.data.HerbivorousData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HerbivorousFactoryTest {

  private HerbivorousFactory herbivorousFactory;

  @BeforeEach
  void setUp() {
    herbivorousFactory = new HerbivorousFactory();
  }

  @Test
  void createRabbit() {
    HerbivorousData rabbitData = new HerbivorousData(1, "Rabbit", 10, 100, 8);
    Rabbit rabbit = (Rabbit) herbivorousFactory.createAnimal(rabbitData);
    assertEquals("Rabbit", rabbit.getName());
    assertEquals(10, rabbit.getFoodConsumption());
    assertEquals(100, rabbit.getHealth());
    assertEquals(8, rabbit.getKindnessAmount());
  }

  @Test
  void createElephant() {
    HerbivorousData elephantData = new HerbivorousData(2, "Elephant", 15, 200, 5);
    Elephant elephant = (Elephant) herbivorousFactory.createAnimal(elephantData);
    assertEquals("Elephant", elephant.getName());
    assertEquals(15, elephant.getFoodConsumption());
    assertEquals(200, elephant.getHealth());
    assertEquals(5, elephant.getKindnessAmount());
  }

  @Test
  void createUnsupportedAnimal() {
    HerbivorousData unsupportedData = new HerbivorousData(3, "Unsupported", 5, 50, 3);
    assertThrows(IllegalArgumentException.class, () -> {
      herbivorousFactory.createAnimal(unsupportedData);
    });
  }
}