package hse.zoo.model.data;

public enum AddAnimalState {
  /**
   * The animal was added successfully.
   */
  SUCCESS,
  /**
   * Invalid animal.
   */
  INVALID_ANIMAL,
  /**
   * The animal was not added because it was ill.
   */
  ILL_ANIMAL,
}
