package hse.zoo.model.animals;

import hse.zoo.interfaces.Alive;
import hse.zoo.model.InventoryItem;
import hse.zoo.model.data.AnimalData;

/**
 * Class for all animals in the zoo.
 */
public abstract class Animal extends InventoryItem implements Alive {
  private final int foodConsumption;

  /**
   * Constructor for the Animal class.
   *
   * @param animalData The data for the animal.
   */
  public Animal(AnimalData animalData) {
    super(animalData.inventoryItemData());
    this.foodConsumption = animalData.foodConsumption();
  }

  /**
   * Get the amount of food the animal consumes.
   *
   * @return The amount of food the animal consumes.
   */
  public int getFoodConsumption() {
    return foodConsumption;
  }
}
