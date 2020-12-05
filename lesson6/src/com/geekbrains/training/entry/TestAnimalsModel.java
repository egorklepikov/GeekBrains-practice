package com.geekbrains.training.entry;

import com.geekbrains.training.animals.Animal;
import com.geekbrains.training.animals.Cat;
import com.geekbrains.training.animals.Dog;

import java.util.Random;

public class TestAnimalsModel {
  private static final Random random = new Random();

  public static void main(String[] args) {
    Animal[] animals = {
      new Cat("Barsik"),
      new Cat("Katerina"),
      new Dog("Sten"),
      new Dog("Scot")
    };
    testRunMethod(animals);
    testSwimMethod(animals);
    printAnimalsCount();
    printCatsCount();
    printDogsCount();
  }

  private static void printDogsCount() {
    System.out.println("Dogs: " + Dog.dogsCount);
  }

  private static void printCatsCount() {
    System.out.println("Cats: " + Cat.catsCount);
  }

  private static void printAnimalsCount() {
    System.out.println("Total animals: " + Animal.animalsCount);
  }

  private static void testSwimMethod(Animal[] animals) {
    for (Animal animal : animals) {
      animal.swim(random.nextInt(14));
    }
  }

  private static void testRunMethod(Animal[] animals) {
    for (Animal animal : animals) {
      animal.run(random.nextInt(600));
    }
  }
}
