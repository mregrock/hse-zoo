package hse.zoo.services;

import hse.zoo.model.animals.Animal;

/**
 * Veterinary clinic service interface.
 */
public interface VeterinaryClinicService {
  /**
   * Check the health of an animal.
   *
   * @param animal The animal to check.
   * @return True if the animal is healthy, false otherwise.
   */
  boolean checkHealth(Animal animal);
}