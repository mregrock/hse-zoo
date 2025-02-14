package hse.zoo.model.factories;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.omnivores.Monkey;
import hse.zoo.model.animals.omnivores.OmnivorousAnimal;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.OmnivorousData;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

/**
 * Factory for creating omnivorous animals.
 */
@Component
public class OmnivorousFactory implements AnimalFactory {

  private final Map<String, Function<OmnivorousData, OmnivorousAnimal>> omnivorousCreators;

  public OmnivorousFactory() {
    omnivorousCreators = new HashMap<>();
    omnivorousCreators.put("Monkey", Monkey::new);
  }

  @Override
  public Animal createAnimal(AnimalData animalData) {
    if (animalData instanceof OmnivorousData) {
      OmnivorousData omnivorousData = (OmnivorousData) animalData;
      Function<OmnivorousData, OmnivorousAnimal> creator = 
               omnivorousCreators.get(omnivorousData.getName());
      if (creator != null) {
        return creator.apply(omnivorousData);
      }
    }
    throw new IllegalArgumentException("Unsupported animal type for OmnivorousFactory: " 
                                       + animalData.getName());
  }

}