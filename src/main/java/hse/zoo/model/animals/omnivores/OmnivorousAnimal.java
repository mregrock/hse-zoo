package hse.zoo.model.animals.omnivores;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.OmnivorousData;

/**
 * An omnivorous animal.
 *
 */
public abstract class OmnivorousAnimal extends Animal implements Omnivorous {
  protected final int kindnessAmount;
  protected final int attackPower;

  /**
   * Constructor for the OmnivorousAnimal class.
   *
   * @param omnivorousData The data for the omnivorous animal.
   */
  public OmnivorousAnimal(OmnivorousData omnivorousData) {
    super(omnivorousData.getAnimalData());
    this.kindnessAmount = omnivorousData.getKindnessAmount();
    this.attackPower = omnivorousData.getAttackPower();
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
