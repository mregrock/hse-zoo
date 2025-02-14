package hse.zoo.model.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.Rabbit;
import hse.zoo.model.animals.omnivores.Monkey;
import hse.zoo.model.animals.predators.Wolf;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.HerbivorousData;
import hse.zoo.model.data.OmnivorousData;
import hse.zoo.model.data.PredatorData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteAnimalFactoryTest {

  private HerbivorousFactory herbivorousFactory;
  private PredatorFactory predatorFactory;
  private OmnivorousFactory omnivorousFactory;
  private ConcreteAnimalFactory concreteAnimalFactory;

  @BeforeEach
  void setUp() {
    herbivorousFactory = mock(HerbivorousFactory.class);
    predatorFactory = mock(PredatorFactory.class);
    omnivorousFactory = mock(OmnivorousFactory.class);
    concreteAnimalFactory = new ConcreteAnimalFactory(herbivorousFactory, predatorFactory, omnivorousFactory);
  }

  @Test
  void createHerbivorousAnimal() {
    HerbivorousData rabbitData = new HerbivorousData(1, "Rabbit", 10, 100, 8);
    Rabbit rabbit = new Rabbit(rabbitData);
    when(herbivorousFactory.createAnimal(rabbitData)).thenReturn(rabbit);

    Animal createdAnimal = concreteAnimalFactory.createAnimal(rabbitData);
    assertEquals(rabbit, createdAnimal);
  }

  @Test
  void createPredatorAnimal() {
    PredatorData wolfData = new PredatorData(2, "Wolf", 15, 200, 5);
    Wolf wolf = new Wolf(wolfData);
    when(predatorFactory.createAnimal(wolfData)).thenReturn(wolf);

    Animal createdAnimal = concreteAnimalFactory.createAnimal(wolfData);
    assertEquals(wolf, createdAnimal);
  }

  @Test
  void createOmnivorousAnimal() {
    OmnivorousData monkeyData = new OmnivorousData(3, "Monkey", 5, 50, 3, 11);
    Monkey monkey = new Monkey(monkeyData);
    when(omnivorousFactory.createAnimal(monkeyData)).thenReturn(monkey);

    Animal createdAnimal = concreteAnimalFactory.createAnimal(monkeyData);
    assertEquals(monkey, createdAnimal);
  }

  @Test
  void createUnsupportedAnimal() {
    AnimalData unsupportedData = new AnimalData(4, "Unsupported", 5, 50);
    assertThrows(IllegalArgumentException.class, () -> {
      concreteAnimalFactory.createAnimal(unsupportedData);
    });
  }
}