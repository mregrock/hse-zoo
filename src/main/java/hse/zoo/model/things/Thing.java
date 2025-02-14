package hse.zoo.model.things;

import hse.zoo.model.InventoryItem;
import hse.zoo.model.data.ThingData;

/**
 * Class for all things in the zoo.
 */
public abstract class Thing extends InventoryItem {
  protected final int cost;

  /**
   * Constructor for the Thing class.
   *
   * @param thingData The data for the thing.
   */
  public Thing(ThingData thingData) {
    super(thingData.getInventoryItemData());
    this.cost = thingData.getCost();
  }

  /**
   * Get the cost of the thing.
   *
   * @return The cost of the thing.
   */
  public int getCost() {
    return cost;
  }
}
