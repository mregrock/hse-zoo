package hse.zoo.model.data;

/**
 * Data class for inventory items.
 */

public class InventoryItemData {
  protected final int id;
  protected final String name;

  /**
   * Constructor for the InventoryItemData class.
   *
   * @param id The id of the inventory item.
   * @param name The name of the inventory item.
   */
  public InventoryItemData(int id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Get the inventory item data.
   *
   * @return The inventory item data.
   */
  public InventoryItemData getInventoryItemData() {
    return new InventoryItemData(id, name);
  }

  /**
   * Get the id.
   *
   * @return The id.
   */
  public int getId() {
    return id;
  }

  /**
   * Get the name.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }
}
