package hse.zoo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import hse.zoo.model.Zoo;
import hse.zoo.model.animals.Animal;
import hse.zoo.model.animals.herbivores.Elephant;
import hse.zoo.model.animals.herbivores.HerbivorousAnimal;
import hse.zoo.model.animals.herbivores.Rabbit;
import hse.zoo.model.animals.predators.Wolf;
import hse.zoo.model.data.AddAnimalState;
import hse.zoo.model.data.HerbivorousData;
import hse.zoo.model.data.OmnivorousData;
import hse.zoo.model.data.PredatorData;
import hse.zoo.model.factories.ConcreteAnimalFactory;
import java.util.ArrayList;
import java.util.List;

import hse.zoo.model.factories.HerbivorousFactory;
import hse.zoo.model.factories.OmnivorousFactory;
import hse.zoo.model.factories.PredatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


@ExtendWith(MockitoExtension.class)
class ZooServiceImplTest {

  @Mock
  private Zoo zoo;

  @Mock
  private HerbivorousFactory herbivorousFactory;

  @Mock
  private PredatorFactory predatorFactory;

  @Mock
  private OmnivorousFactory omnivorousFactory;

  @InjectMocks
  private ConcreteAnimalFactory animalFactory;

  @InjectMocks
  private VeterinaryClinicServiceImpl veterinaryClinicService;
  @InjectMocks
  private ZooServiceImpl zooService;

  @BeforeEach
  void setUp() {
    zooService = new ZooServiceImpl(zoo, animalFactory, veterinaryClinicService);
  }

  @Test
  void addAnimal() {
    HerbivorousData animalData = new HerbivorousData(1, "Rabbit", 10, 100, 8);
    when(herbivorousFactory.createAnimal(animalData)).thenReturn(new Rabbit(animalData));
    AddAnimalState result = zooService.addAnimal(animalData);
    assertEquals(AddAnimalState.SUCCESS, result);


  }

  @Test
  void addSickAnimal() {
    HerbivorousData animalData = new HerbivorousData(1, "Rabbit", 10, -5, 8);
    when(herbivorousFactory.createAnimal(animalData)).thenReturn(new Rabbit(animalData));
    AddAnimalState result = zooService.addAnimal(animalData);
    assertEquals(AddAnimalState.ILL_ANIMAL, result);
  }

  @Test
  void addInvalidAnimal() {
    HerbivorousData animalData = new HerbivorousData(1, "aboba", 10, 100, 5);
    when(herbivorousFactory.createAnimal(animalData)).thenThrow(new IllegalArgumentException());
    AddAnimalState result = zooService.addAnimal(animalData);
    assertEquals(AddAnimalState.INVALID_ANIMAL, result);
  }


  @Test
  void getTotalFoodConsumption() {
    List<Animal> animals = new ArrayList<>();
    Animal rabbit1 = mock(Animal.class);
    Animal rabbit2 = mock(Animal.class);

    when(rabbit1.getFoodConsumption()).thenReturn(5);
    when(rabbit2.getFoodConsumption()).thenReturn(7);

    animals.add(rabbit1);
    animals.add(rabbit2);
    when(zoo.getAllAnimals()).thenReturn(animals);

    int totalConsumption = zooService.getTotalFoodConsumption();

    assertEquals(12, totalConsumption);
  }

  @Test
  void getAnimalsForPettingZoo() {
    HerbivorousAnimal rabbit = new Rabbit(new HerbivorousData(1, "Rabbit", 10, 100, 8));
    HerbivorousAnimal elephant = new Elephant(new HerbivorousData(2, "Elephant", 100, 1000, 3));

    Animal lion = new Wolf(new PredatorData(3, "Wolf", 100, 1000, 5));
  
    List<Animal> animals = new ArrayList<>();
    animals.add(rabbit);
    animals.add(elephant);
    animals.add(lion);

    when(zoo.getAllAnimals()).thenReturn(animals);
    List<Animal> pettingZooAnimals = zooService.getAnimalsForPettingZoo();

    assertEquals(1, pettingZooAnimals.size());

    assertTrue(pettingZooAnimals.contains(rabbit));
    assertFalse(pettingZooAnimals.contains(elephant));
    assertFalse(pettingZooAnimals.contains(lion));
  }

  @Test
  void getZoo() {
    Zoo returnedZoo = zooService.getZoo();

    assertEquals(zoo, returnedZoo);
  }

  @Test
  void getAllAnimals() {
    List<Animal> animals = new ArrayList<>();
    animals.add(mock(Animal.class));
    animals.add(mock(Animal.class));
    when(zoo.getAllAnimals()).thenReturn(animals);

    List<Animal> result = zooService.getAllAnimals();

    assertEquals(animals, result);
    verify(zoo).getAllAnimals();
  }

  @Test
  void getAnimalById_found() {
    Animal rabbit = mock(Animal.class);
    when(rabbit.getId()).thenReturn(123);
    List<Animal> animals = new ArrayList<>();
    animals.add(rabbit);
    animals.add(mock(Animal.class));
    when(zoo.getAllAnimals()).thenReturn(animals);

    Animal foundAnimal = zooService.getAnimalById(123);

    assertNotNull(foundAnimal);
    assertEquals(123, foundAnimal.getId());
    assertSame(rabbit, foundAnimal);
  }

  @Test
  void getAnimalById_notFound() {
    List<Animal> animals = new ArrayList<>();
    animals.add(mock(Animal.class));
    when(zoo.getAllAnimals()).thenReturn(animals);

    Animal foundAnimal = zooService.getAnimalById(456);

    assertNull(foundAnimal);
  }
}
