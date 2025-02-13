package hse.zoo.model.animals.herbivores;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.Herbivorous;
import hse.zoo.model.data.HerbivorousData;

/**
 * A herbivorous animal.
 */
public abstract class HerbivorousAnimal extends Animal implements Herbivorous {
  private final int kindnessAmount;

  /**
   * Constructor for the HerbivorousAnimal class.
   *
   * @param herbivorousData The data for the herbivorous animal.
   */
  public HerbivorousAnimal(HerbivorousData herbivorousData) {
    super(herbivorousData.animalData());
    this.kindnessAmount = herbivorousData.kindnessAmount();
  }

  @Override
  public int getKindnessAmount() {
    return kindnessAmount;
  }
}
