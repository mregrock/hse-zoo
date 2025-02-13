package hse.zoo.model.data;

import hse.zoo.model.data.AnimalData;

/**
 * Data record for herbivorous animals.
 *
 * @param animalData The data for the animal.
 * @param kindnessAmount The amount of kindness the animal has.
 */
public record HerbivorousData(AnimalData animalData, int kindnessAmount) {
}
