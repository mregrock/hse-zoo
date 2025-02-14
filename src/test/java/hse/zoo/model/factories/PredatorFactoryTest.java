package hse.zoo.model.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hse.zoo.model.animals.predators.Wolf;
import hse.zoo.model.animals.predators.Tiger;
import hse.zoo.model.data.PredatorData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PredatorFactoryTest {

  private PredatorFactory PredatorFactory;

  @BeforeEach
  void setUp() {
    PredatorFactory = new PredatorFactory();
  }

  @Test
  void createWolf() {
    PredatorData wolfData = new PredatorData(1, "Wolf", 10, 100, 8);
    Wolf wolf = (Wolf) PredatorFactory.createAnimal(wolfData);
    assertEquals("Wolf", wolf.getName());
    assertEquals(10, wolf.getFoodConsumption());
    assertEquals(100, wolf.getHealth());
    assertEquals(8, wolf.getAttackPower());
  }

  @Test
  void createTiger() {
    PredatorData tigerData = new PredatorData(2, "Tiger", 15, 200, 5);
    Tiger tiger = (Tiger) PredatorFactory.createAnimal(tigerData);
    assertEquals("Tiger", tiger.getName());
    assertEquals(15, tiger.getFoodConsumption());
    assertEquals(200, tiger.getHealth());
    assertEquals(5, tiger.getAttackPower());
  }

  @Test
  void createUnsupportedAnimal() {
    PredatorData unsupportedData = new PredatorData(3, "Unsupported", 5, 50, 3);
    assertThrows(IllegalArgumentException.class, () -> {
      PredatorFactory.createAnimal(unsupportedData);
    });
  }
}