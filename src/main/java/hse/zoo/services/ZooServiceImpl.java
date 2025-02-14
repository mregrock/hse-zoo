package hse.zoo.services;

import hse.zoo.model.Zoo;
import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.HerbivorousAnimal;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.AddAnimalState;
import hse.zoo.model.factories.ConcreteAnimalFactory;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Zoo service implementation.
 */
@Service
public class ZooServiceImpl implements ZooService {

  private final Zoo zoo;
  private final ConcreteAnimalFactory animalFactory;

  private final VeterinaryClinicService veterinaryClinicService;

  @Autowired
  public ZooServiceImpl(Zoo zoo, ConcreteAnimalFactory animalFactory, VeterinaryClinicService veterinaryClinicService) {
    this.zoo = zoo;
    this.animalFactory = animalFactory;
    this.veterinaryClinicService = veterinaryClinicService;
  }

  @Override
  public AddAnimalState addAnimal(AnimalData animalData) {
    try {
      Animal animal = animalFactory.createAnimal(animalData);
      if (!veterinaryClinicService.checkHealth(animal)) {
        return AddAnimalState.ILL_ANIMAL;
      }
      zoo.addAnimal(animal);
      return AddAnimalState.SUCCESS;
    } catch (IllegalArgumentException e) {
      return AddAnimalState.INVALID_ANIMAL;
    }
  }

  @Override
  public int getTotalFoodConsumption() {
    return zoo.getAllAnimals().stream()
              .mapToInt(Animal::getFoodConsumption)
              .sum();
  }

  @Override
  public List<Animal> getAnimalsForPettingZoo() {
    return zoo.getAllAnimals().stream()
            .filter(animal -> animal instanceof HerbivorousAnimal)
            .map(animal -> (HerbivorousAnimal) animal)
            .filter(herbivore -> {
              return herbivore.getKindnessAmount() > 5;
            })
            .collect(Collectors.toList());
  }

  @Override
  public Zoo getZoo() {
    return zoo;
  }

  @Override
  public List<Animal> getAllAnimals() {
    return zoo.getAllAnimals();
  }

  @Override
  public Animal getAnimalById(int id) {
    return zoo.getAllAnimals().stream()
            .filter(animal -> animal.getId() == id)
            .findFirst()
            .orElse(null);
  }
}