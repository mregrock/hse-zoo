package hse.zoo.model.data;

import hse.zoo.model.data.AnimalData;

/**
 * Data record for omnivorous animals.
 *
 * @param animalData The data for the animal.
 * @param kindnessAmount The amount of kindness the animal has.
 * @param attackPower The attack power the animal has.
 */
public record OmnivorousData(AnimalData animalData, int kindnessAmount, int attackPower) {
}
