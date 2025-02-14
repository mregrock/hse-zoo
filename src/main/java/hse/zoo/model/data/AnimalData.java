package hse.zoo.model.data;

/**
 * Data class for animals.
 *
 */

public class AnimalData extends InventoryItemData {
  protected final int foodConsumption;
  protected final int health;

  /**
   * Constructor for the AnimalData class.
   *
   * @param id The id of the animal.
   * @param name The name of the animal.
   * @param foodConsumption The amount of food the animal consumes.
   * @param health The health of the animal.
   */
  public AnimalData(int id, String name, int foodConsumption, int health) {
    super(id, name);
    this.foodConsumption = foodConsumption;
    this.health = health;
  }

  /**
   * Get the animal data.
   *
   * @return The animal data.
   */
  public AnimalData getAnimalData() {
    return new AnimalData(id, name, foodConsumption, health);
  }

  /**
   * Get the food consumption.
   *
   * @return The food consumption.
   */
  public int getFoodConsumption() {
    return foodConsumption;
  }

  /**
   * Get the health.
   *
   * @return The health.
   */
  public int getHealth() {
    return health;
  }
}
