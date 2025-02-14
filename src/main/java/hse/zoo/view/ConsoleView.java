package hse.zoo.view;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.*;
import hse.zoo.services.VeterinaryClinicService;
import hse.zoo.services.ZooService;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Console view for the zoo application.
 */
@Component
public class ConsoleView {

  private final ZooService zooService;
  private final VeterinaryClinicService veterinaryClinicService;
  private final Scanner scanner;

  /**
   * Constructor for the ConsoleView class.
   *
   * @param zooService The zoo service.
   * @param veterinaryClinicService The veterinary clinic service.
   */
  @Autowired
  public ConsoleView(ZooService zooService, VeterinaryClinicService veterinaryClinicService) {
    this.zooService = zooService;
    this.veterinaryClinicService = veterinaryClinicService;
    this.scanner = new Scanner(System.in);
  }

  /**
   * Start the console view.
   */
  public void start() {
    while (true) {
      System.out.println("\nChoose an action:");
      System.out.println("1. Add an animal");
      System.out.println("2. Show all animals");
      System.out.println("3. Show total food consumption");
      System.out.println("4. Show animals for petting zoo");
      System.out.println("5. Check animal health");
      System.out.println("6. Exit");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> addAnimal();
        case 2 -> showAllAnimals();
        case 3 -> showTotalFoodConsumption();
        case 4 -> showAnimalsForPettingZoo();
        case 5 -> checkAnimalHealth();
        case 6 -> {
          return;
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  /**
   * Add an animal to the zoo.
   */
  private void addAnimal() {
    System.out.println("Enter animal type (Herbivorous, Predator, Omnivorous):");
    final String type = scanner.nextLine().toLowerCase();

    System.out.println("Enter animal ID:");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter animal name:");
    String name = scanner.nextLine();

    System.out.println("Enter food consumption:");
    int foodConsumption = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter health:");
    int health = scanner.nextInt();
    scanner.nextLine();

    AnimalData animalData = null;

    switch (type.toLowerCase()) {
      case "herbivorous" -> {
        System.out.println("Enter kindness amount:");
        int kindnessAmount = scanner.nextInt();
        scanner.nextLine();
        animalData = new HerbivorousData(id, name, foodConsumption, health, kindnessAmount);
      }
      case "predator" -> {
        System.out.println("Enter power attack:");
        int powerAttack = scanner.nextInt();
        scanner.nextLine();
        animalData = new PredatorData(id, name, foodConsumption, health, powerAttack);
      }
      case "omnivorous" -> {
        System.out.println("Enter kindness amount:");
        final int omnivorousKindnessAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter power attack:");
        int omnivorousPowerAttack = scanner.nextInt();
        scanner.nextLine();
        animalData = new OmnivorousData(id, name, foodConsumption, health, omnivorousKindnessAmount,
                omnivorousPowerAttack);
      }
      default -> {
        System.out.println("Invalid animal type.");
        return;
      }
    }
    AddAnimalState result = zooService.addAnimal(animalData);
    switch (result) {
      case SUCCESS -> System.out.println("Animal added successfully.");
      case ILL_ANIMAL -> System.out.println("Animal was not added due to illness.");
      case INVALID_ANIMAL -> System.out.println("Invalid animal.");
    }
  }

  /**
   * Show all animals in the zoo.
   */
  private void showAllAnimals() {
    List<Animal> animals = zooService.getAllAnimals();
    if (animals.isEmpty()) {
      System.out.println("No animals in the zoo.");
      return;
    }
    System.out.println("Animals in the zoo:");
    for (Animal animal : animals) {
      System.out.println("  - " + animal.getClass().getSimpleName() + ", ID: " 
                         + animal.getId() + ", Name: " + animal.getName());
    }
  }

  /**
   * Show the total food consumption in the zoo.
   */
  private void showTotalFoodConsumption() {
    int totalConsumption = zooService.getTotalFoodConsumption();
    System.out.println("Total food consumption: " + totalConsumption + " kg");
  }

  /**
   * Show the animals suitable for petting zoo.
   */
  private void showAnimalsForPettingZoo() {
    List<Animal> pettingZooAnimals = zooService.getAnimalsForPettingZoo();
    if (pettingZooAnimals.isEmpty()) {
      System.out.println("No animals suitable for petting zoo.");
      return;
    }
    System.out.println("Animals for petting zoo:");
    for (Animal animal : pettingZooAnimals) {
      System.out.println("  - " + animal.getClass().getSimpleName() + ", ID: " 
                         + animal.getId() + ", Name: " + animal.getName());
    }
  }

  /**
   * Check the health of an animal.
   */
  private void checkAnimalHealth() {
    List<Animal> animals = zooService.getAllAnimals();
    if (animals.isEmpty()) {
      System.out.println("No animals in the zoo to check.");
      return;
    }

    System.out.println("Available animals:");
    for (Animal animal : animals) {
      System.out.println("  - ID: " + animal.getId() + ", Name: " + animal.getName());
    }

    System.out.println("Enter the ID of the animal to check:");
    int animalId = scanner.nextInt();
    scanner.nextLine();

    Animal selectedAnimal = zooService.getAnimalById(animalId);

    if (selectedAnimal == null) {
      System.out.println("Animal with ID " + animalId + " not found.");
      return;
    }

    boolean isHealthy = veterinaryClinicService.checkHealth(selectedAnimal);
    if (isHealthy) {
      System.out.println("The animal (" + selectedAnimal.getName() + ") is healthy.");
    } else {
      System.out.println("The animal (" + selectedAnimal.getName() + ") is not healthy.");
    }
  }
}