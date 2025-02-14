package hse.zoo.model;

import hse.zoo.model.animals.Animal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Zoo class.
 */
@Getter
@Setter
@Component
public class Zoo {
  private List<Animal> animals = new ArrayList<>();

  public void addAnimal(Animal animal) {
    animals.add(animal);
  }

  public List<Animal> getAllAnimals() {
    return new ArrayList<>(animals);
  }
}