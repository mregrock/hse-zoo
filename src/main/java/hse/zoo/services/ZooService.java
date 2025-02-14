package hse.zoo.services;

import hse.zoo.model.Zoo;
import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.AddAnimalState;
import java.util.List;

/**
 * Zoo service interface.
 */
public interface ZooService {
  /**
   * Add an animal to the zoo.
   *
   * @param animalData The data for the animal.
   *
   * @return AddAnimalState after executing addAnimal operation.
   */
  AddAnimalState addAnimal(AnimalData animalData);

  /**
   * Get the total food consumption.
   *
   * @return The total food consumption.
   */
  int getTotalFoodConsumption();

  /**
   * Get the animals for petting zoo.
   *
   * @return The animals for petting zoo.
   */
  List<Animal> getAnimalsForPettingZoo();

  /**
   * Get the zoo.
   *
   * @return The zoo.
   */
  Zoo getZoo();

  List<Animal> getAllAnimals();

  Animal getAnimalById(int id);
}