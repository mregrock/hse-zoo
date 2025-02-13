package hse.zoo.model.animals.omnivores;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.AnimalData;
import hse.zoo.model.data.OmnivorousData;

/**
 * An omnivorous animal.
 *
 */
public abstract class OmnivorousAnimal extends Animal implements Omnivorous {
  private final int kindnessAmount;
  private final int attackPower;

  /**
   * Constructor for the OmnivorousAnimal class.
   *
   * @param omnivorousData The data for the omnivorous animal.
   */
  public OmnivorousAnimal(OmnivorousData omnivorousData) {
    super(omnivorousData.animalData());
    this.kindnessAmount = omnivorousData.kindnessAmount();
    this.attackPower = omnivorousData.attackPower();
  }

  @Override
  public int getKindnessAmount() {
    return kindnessAmount;
  }

  @Override
  public int getAttackPower() {
    return attackPower;
  }
}
