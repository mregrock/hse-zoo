package hse.zoo.model.data;

/**
 * Data class for herbivorous animals.
 *
 */
public class HerbivorousData extends AnimalData {
  protected final int kindnessAmount;

  /**
   * Constructor for the HerbivorousData class.
   *
   * @param id The id of the animal.
   * @param name The name of the animal.
   * @param foodConsumption The amount of food the animal consumes.
   * @param health The health of the animal.
   * @param kindnessAmount The amount of kindness the animal has.
   */
  public HerbivorousData(int id, String name, int foodConsumption, int health, int kindnessAmount) {
    super(id, name, foodConsumption, health);
    this.kindnessAmount = kindnessAmount;
  }

  /**
   * Get the herbivorous data.
   *
   * @return The herbivorous data.
   */
  public HerbivorousData getHerbivorousData() {
    return new HerbivorousData(id, name, foodConsumption, health, kindnessAmount);
  }

  /**
   * Get the kindness amount.
   *
   * @return The kindness amount.
   */
  public int getKindnessAmount() {
    return kindnessAmount;
  }
}
