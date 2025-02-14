package hse.zoo.model.factories;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.predators.PredatorAnimal;
import hse.zoo.model.animals.predators.Tiger;
import hse.zoo.model.animals.predators.Wolf;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.PredatorData;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

/**
 * Factory for creating predator animals.
 */
@Component
public class PredatorFactory implements AnimalFactory {

  private final Map<String, Function<PredatorData, PredatorAnimal>> predatorCreators;

  /**
   * Constructor for the PredatorFactory.
   */
  public PredatorFactory() {
    predatorCreators = new HashMap<>();
    predatorCreators.put("Tiger", Tiger::new);
    predatorCreators.put("Wolf", Wolf::new);
  }

  @Override
  public Animal createAnimal(AnimalData animalData) {
    if (animalData instanceof PredatorData) {
      PredatorData predatorData = (PredatorData) animalData;
      Function<PredatorData, PredatorAnimal> creator = predatorCreators.get(predatorData.getName());
      if (creator != null) {
        return creator.apply(predatorData);
      }
    }
    throw new IllegalArgumentException("Unsupported animal type for PredatorFactory: " 
                                       + animalData.getName());
  }

}