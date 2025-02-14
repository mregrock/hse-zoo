package hse.zoo.model.data;

/**
 * Data class for things in the zoo.
 *
 */
public class ThingData extends InventoryItemData {
  protected final int cost;

  /**
   * Constructor for the ThingData class.
   *
   * @param id The id of the thing.
   * @param name The name of the thing.
   * @param cost The cost of the thing.
   */
  public ThingData(int id, String name, int cost) {
    super(id, name);
    this.cost = cost;
  }

  /**
   * Get the thing data.
   *
   * @return The thing data.
   */
  public ThingData getThingData() {
    return new ThingData(id, name, cost);
  }

  /**
   * Get the cost.
   *
   * @return The cost.
   */
  public int getCost() {
    return cost;
  }
}
