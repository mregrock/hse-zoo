package hse.zoo.services;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.AnimalData;
import org.springframework.stereotype.Service;

/**
 * Veterinary clinic service implementation.
 */
@Service
public class VeterinaryClinicServiceImpl implements VeterinaryClinicService {
  @Override
  public boolean checkHealth(Animal animal) {
    return animal.getHealth() > 0;
  }
}