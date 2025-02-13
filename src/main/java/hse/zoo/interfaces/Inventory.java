package hse.zoo.interfaces;

/**
 * Interface for all inventory items in the zoo.
 */
public interface Inventory {
  /**
   * Get the id of inventory item.
   *
   * @return The id of inventory item.
   */
  int getId();

  /**
    * Get the name of the inventory item.
    *
    * @return The name of the inventory item.
    */
  String getName();
}
