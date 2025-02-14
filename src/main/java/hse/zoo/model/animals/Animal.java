package hse.zoo.model.animals;

import hse.zoo.interfaces.Alive;
import hse.zoo.model.InventoryItem;
import hse.zoo.model.data.AnimalData;

/**
 * Class for all animals in the zoo.
 */
public abstract class Animal extends InventoryItem implements Alive {
  protected final int foodConsumption;
  protected final int health;

  /**
   * Constructor for the Animal class.
   *
   * @param animalData The data for the animal.
   */
  public Animal(AnimalData animalData) {
    super(animalData.getInventoryItemData());
    this.foodConsumption = animalData.getFoodConsumption();
    this.health = animalData.getHealth();
  }

  /**
   * Get the amount of food the animal consumes.
   *
   * @return The amount of food the animal consumes.
   */
  public int getFoodConsumption() {
    return foodConsumption;
  }

  /**
   * Get the health of the animal.
   *
   * @return The health of the animal.
   */
  public int getHealth() {
    return health;
  }
}
