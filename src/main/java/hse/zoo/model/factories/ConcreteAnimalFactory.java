package hse.zoo.model.factories;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.HerbivorousData;
import hse.zoo.model.data.OmnivorousData;
import hse.zoo.model.data.PredatorData;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Concrete factory for creating animals.
 */
@Component
public class ConcreteAnimalFactory implements AnimalFactory {

  private final Map<Class<? extends AnimalData>, AnimalFactory> factoryMap;

  /**
   * Constructor for the ConcreteAnimalFactory.
   *
   * @param herbivorousFactory The herbivorous factory.
   * @param predatorFactory The predator factory.
   * @param omnivorousFactory The omnivorous factory.
   */
  @Autowired
  public ConcreteAnimalFactory(HerbivorousFactory herbivorousFactory,
                               PredatorFactory predatorFactory,
                               OmnivorousFactory omnivorousFactory) {
    this.factoryMap = new HashMap<>();
    this.factoryMap.put(HerbivorousData.class, herbivorousFactory);
    this.factoryMap.put(PredatorData.class, predatorFactory);
    this.factoryMap.put(OmnivorousData.class, omnivorousFactory);
  }

  /**
   * Create an animal.
   *
   * @param animalData The data for the animal.
   * @return The created animal.
   */
  @Override
  public Animal createAnimal(AnimalData animalData) {
    AnimalFactory factory = factoryMap.get(animalData.getClass());
    try {
      if (factory != null) {
        return factory.createAnimal(animalData);
      }
    }
    catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Unsupported animal or animal type: "
                                       + animalData.getClass().getName());
    }
    throw new IllegalArgumentException("Unsupported fabric type: " + animalData.getClass().getName());
  }
}
