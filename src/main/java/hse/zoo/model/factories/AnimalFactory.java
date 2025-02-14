package hse.zoo.model.factories;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.AnimalData;

/**
 * Factory for creating animals.
 */
public interface AnimalFactory {
  Animal createAnimal(AnimalData animalData);
}