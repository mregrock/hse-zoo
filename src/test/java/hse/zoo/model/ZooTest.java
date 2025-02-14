package hse.zoo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.Rabbit;
import hse.zoo.model.data.HerbivorousData;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZooTest {

  private Zoo zoo;

  @BeforeEach
  void setUp() {
    zoo = new Zoo();
  }

  @Test
  void addAnimal() {
    HerbivorousData rabbitData = new HerbivorousData(1, "Rabbit", 10, 100, 8);
    Animal rabbit = new Rabbit(rabbitData);
    zoo.addAnimal(rabbit);

    List<Animal> animals = zoo.getAllAnimals();
    assertEquals(1, animals.size());
    assertTrue(animals.contains(rabbit));
  }

  @Test
  void getAllAnimals() {
    HerbivorousData rabbitData = new HerbivorousData(1, "Rabbit", 10, 100, 8);
    Animal rabbit = new Rabbit(rabbitData);
    zoo.addAnimal(rabbit);

    HerbivorousData anotherRabbitData = new HerbivorousData(2, "Rabbit", 5, 80, 6);
    Animal anotherRabbit = new Rabbit(anotherRabbitData);
    zoo.addAnimal(anotherRabbit);

    List<Animal> animals = zoo.getAllAnimals();
    assertEquals(2, animals.size());
    assertTrue(animals.contains(rabbit));
    assertTrue(animals.contains(anotherRabbit));
  }
}