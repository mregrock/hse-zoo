package hse.zoo.model;

import hse.zoo.interfaces.Inventory;
import hse.zoo.model.data.InventoryItemData;

/**
 * Class for all inventory items in the zoo.
 */
public abstract class InventoryItem implements Inventory {
  protected final String name;
  protected final int id;

  /**
   * Constructor for the InventoryItem class.
   *
   * @param inventoryItemData The data for the inventory item.
   */
  public InventoryItem(InventoryItemData inventoryItemData) {
    this.id = inventoryItemData.getId();
    this.name = inventoryItemData.getName();
  }

  /**
   * Get the name of the inventory item.
   *
   * @return The name of the inventory item.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Get the id of inventory item.
   *
   * @return The inventory item id.
   */
  @Override
  public int getId() {
    return id;
  }

}
