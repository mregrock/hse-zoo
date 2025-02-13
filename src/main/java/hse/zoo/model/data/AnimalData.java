package hse.zoo.model.data;

import hse.zoo.model.data.InventoryItemData;

/**
 * Data record for animals.
 *
 * @param inventoryItemData The data for the inventory item.
 * @param foodConsumption The amount of food the animal consumes.
 */
public record AnimalData(InventoryItemData inventoryItemData, int foodConsumption) {
}
