package hse.zoo.model.factories;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.Elephant;
import hse.zoo.model.animals.herbivores.HerbivorousAnimal;
import hse.zoo.model.animals.herbivores.Rabbit;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.HerbivorousData;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

/**
 * Factory for creating herbivorous animals.
 */
@Component
public class HerbivorousFactory implements AnimalFactory {

  private final Map<String, Function<HerbivorousData, HerbivorousAnimal>> herbivorousCreators;

  /**
   * Constructor for the HerbivorousFactory class.
   */
  public HerbivorousFactory() {
    herbivorousCreators = new HashMap<>();
    herbivorousCreators.put("Rabbit", Rabbit::new);
    herbivorousCreators.put("Elephant", Elephant::new);
  }

  @Override
  public Animal createAnimal(AnimalData animalData) {
    if (animalData instanceof HerbivorousData) {
      HerbivorousData herbivorousData = (HerbivorousData) animalData;
      Function<HerbivorousData, HerbivorousAnimal> creator = 
               herbivorousCreators.get(herbivorousData.getName());
      if (creator != null) {
        return creator.apply(herbivorousData);
      }
    }
    throw new IllegalArgumentException("Unsupported animal type for HerbivorousFactory: " 
                                       + animalData.getName());
  }


}