package hse.zoo.model.data;

/**
 * Data class for omnivorous animals.
 *
 */
public class OmnivorousData extends AnimalData {

  protected final int kindnessAmount;
  protected final int attackPower;

  /**
   * Constructor for the OmnivorousData class.
   *
   * @param id The id of the animal.
   * @param name The name of the animal.
   * @param foodConsumption The amount of food the animal consumes.
   * @param health The health of the animal.
   * @param kindnessAmount The amount of kindness the animal has.
   * @param attackPower The attack power the animal has.
   */
  public OmnivorousData(int id, String name, int foodConsumption, int health, int kindnessAmount, 
                        int attackPower) {
    super(id, name, foodConsumption, health);
    this.kindnessAmount = kindnessAmount;
    this.attackPower = attackPower;
  }

  /**
   * Get the omnivorous data.
   *
   * @return The omnivorous data.
   */
  public OmnivorousData getOmnivorousData() {
    return new OmnivorousData(id, name, foodConsumption, health, kindnessAmount, attackPower);
  }

  /**
   * Get the kindness amount.
   *
   * @return The kindness amount.
   */
  public int getKindnessAmount() {
    return kindnessAmount;
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
