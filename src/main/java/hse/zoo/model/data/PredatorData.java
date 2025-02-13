package hse.zoo.model.data;

import hse.zoo.model.data.AnimalData;

/**
 * Data record for predators.
 */
public record PredatorData(AnimalData animalData, int attackPower) {
}
