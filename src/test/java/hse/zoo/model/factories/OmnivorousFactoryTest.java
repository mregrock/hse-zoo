package hse.zoo.model.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hse.zoo.model.animals.omnivores.Monkey;
import hse.zoo.model.data.OmnivorousData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OmnivorousFactoryTest {

  private OmnivorousFactory OmnivorousFactory;

  @BeforeEach
  void setUp() {
    OmnivorousFactory = new OmnivorousFactory();
  }

  @Test
  void createMonkey() {
    OmnivorousData MonkeyData = new OmnivorousData(1, "Monkey", 10, 100, 8, 10);
    Monkey monkey = (Monkey) OmnivorousFactory.createAnimal(MonkeyData);
    assertEquals("Monkey", monkey.getName());
    assertEquals(10, monkey.getFoodConsumption());
    assertEquals(100, monkey.getHealth());
    assertEquals(8, monkey.getKindnessAmount());
    assertEquals(10, monkey.getAttackPower());
  }

  @Test
  void createUnsupportedAnimal() {
    OmnivorousData unsupportedData = new OmnivorousData(3, "Unsupported", 5, 50, 3, 11);
    assertThrows(IllegalArgumentException.class, () -> {
      OmnivorousFactory.createAnimal(unsupportedData);
    });
  }
}