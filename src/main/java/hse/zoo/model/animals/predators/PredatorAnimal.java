package hse.zoo.model.animals.predators;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.PredatorData;

/**
 * An animal that is a predator.
 */
public abstract class PredatorAnimal extends Animal implements Predator {
  protected final int attackPower;

  /**
   * Constructor for the PredatorAnimal class.
   *
   * @param predatorData The data for the predator animal.
   */
  public PredatorAnimal(PredatorData predatorData) {
    super(predatorData.getAnimalData());
    this.attackPower = predatorData.getAttackPower();
  }

  @Override
  public int getAttackPower() {
    return attackPower;
  }
}
