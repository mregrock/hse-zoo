package hse.zoo.view;

import static org.mockito.Mockito.*;

import hse.zoo.model.animals.Animal;
import hse.zoo.model.data.*;
import hse.zoo.view.ConsoleView;
import hse.zoo.services.VeterinaryClinicService;
import hse.zoo.services.ZooService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ConsoleViewTest {

  @Mock
  private ZooService zooService;

  @Mock
  private VeterinaryClinicService veterinaryClinicService;

  @Mock
  private Scanner scanner;

  @InjectMocks
  private ConsoleView consoleView;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testAddAnimal() throws Exception {
    when(scanner.nextLine()).thenReturn("Herbivorous", "1", "Rabbit", "10", "100", "8");
    when(zooService.addAnimal(any(HerbivorousData.class))).thenReturn(AddAnimalState.SUCCESS);

    Method method = ConsoleView.class.getDeclaredMethod("addAnimal");
    method.setAccessible(true);
    method.invoke(consoleView);

    verify(zooService).addAnimal(any(HerbivorousData.class));
  }

  @Test
  void testShowAllAnimals() throws Exception {
    List<Animal> animals = new ArrayList<>();
    Animal rabbit = mock(Animal.class);
    when(rabbit.getId()).thenReturn(1);
    when(rabbit.getName()).thenReturn("Rabbit");
    animals.add(rabbit);

    when(zooService.getAllAnimals()).thenReturn(animals);

    Method method = ConsoleView.class.getDeclaredMethod("showAllAnimals");
    method.setAccessible(true);
    method.invoke(consoleView);

    verify(zooService).getAllAnimals();
  }

  @Test
  void testShowTotalFoodConsumption() throws Exception {
    when(zooService.getTotalFoodConsumption()).thenReturn(100);

    Method method = ConsoleView.class.getDeclaredMethod("showTotalFoodConsumption");
    method.setAccessible(true);
    method.invoke(consoleView);

    verify(zooService).getTotalFoodConsumption();
  }

  @Test
  void testShowAnimalsForPettingZoo() throws Exception {
    List<Animal> animals = new ArrayList<>();
    Animal rabbit = mock(Animal.class);
    animals.add(rabbit);

    when(zooService.getAnimalsForPettingZoo()).thenReturn(animals);

    Method method = ConsoleView.class.getDeclaredMethod("showAnimalsForPettingZoo");
    method.setAccessible(true);
    method.invoke(consoleView);

    verify(zooService).getAnimalsForPettingZoo();
  }

  @Test
  void testCheckAnimalHealth() throws Exception {
    List<Animal> animals = new ArrayList<>();
    Animal rabbit = mock(Animal.class);
    when(rabbit.getId()).thenReturn(1);
    when(rabbit.getName()).thenReturn("Rabbit");
    animals.add(rabbit);

    when(zooService.getAllAnimals()).thenReturn(animals);
    when(scanner.nextInt()).thenReturn(1);
    when(zooService.getAnimalById(1)).thenReturn(rabbit);
    when(veterinaryClinicService.checkHealth(rabbit)).thenReturn(true);

    Method method = ConsoleView.class.getDeclaredMethod("checkAnimalHealth");
    method.setAccessible(true);
    method.invoke(consoleView);

    verify(veterinaryClinicService).checkHealth(rabbit);
  }
}