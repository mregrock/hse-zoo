package hse.zoo.model.data;

/**
 * Data class for predators.
 *
 */
public class PredatorData extends AnimalData {
  protected final int attackPower;

  /**
   * Constructor for the PredatorData class.
   *
   * @param id The id of the animal.
   * @param name The name of the animal.
   * @param foodConsumption The amount of food the animal consumes.
   * @param health The health of the animal.
   * @param attackPower The attack power the animal has.
   */
  public PredatorData(int id, String name, int foodConsumption, int health, int attackPower) {
    super(id, name, foodConsumption, health);
    this.attackPower = attackPower;
  }

  /**
   * Get the predator data.
   *
   * @return The predator data.
   */
  public PredatorData getPredatorData() {
    return new PredatorData(id, name, foodConsumption, health, attackPower);
  }

  /**
   * Get the attack power.
   *
   * @return The attack power.
   */
  public int getAttackPower() {
    return attackPower;
  }
}
