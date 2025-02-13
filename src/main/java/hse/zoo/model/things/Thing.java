package hse.zoo.model.things;

import hse.zoo.model.InventoryItem;
import hse.zoo.model.data.InventoryItemData;

/**
 * Class for all things in the zoo.
 */
public abstract class Thing extends InventoryItem {

  /**
   * Constructor for the Thing class.
   *
   * @param inventoryItemData The data for the thing.
   */
  public Thing(InventoryItemData inventoryItemData) {
    super(inventoryItemData);
  }
}
