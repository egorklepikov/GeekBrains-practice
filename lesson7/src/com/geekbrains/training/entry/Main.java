package com.geekbrains.training.entry;

import com.geekbrains.training.model.Cat;
import com.geekbrains.training.model.Plate;

public class Main {
  public static void main(String[] args) {
    Plate plate = new Plate(40);
    Cat[] cats = {
        new Cat("Matrin"),
        new Cat("Alex"),
        new Cat("Katerina"),
        new Cat("Katerina"),
        new Cat("Katerina"),
        new Cat("Katerina"),
        new Cat("Katerina"),
        new Cat("Murzik")
    };
    goEat(cats, plate);
    checkCatsSatisfaction(cats);
  }

  private static void goEat(Cat[] cats, Plate plate) {
    for (Cat cat : cats) {
      cat.eat(plate, 10);
    }
  }

  private static void checkCatsSatisfaction(Cat[] cats) {
    for (Cat cat : cats) {
      if (cat.isHungry()) {
        System.out.println(cat.getName() + " is disappointed. The plate needs to be filled.");
      } else {
        System.out.println(cat.getName() + " is happy and ready to run.");
      }
    }
  }
}
