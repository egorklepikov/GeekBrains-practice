package com.geekbrains.training.entry;

import com.geekbrains.training.model.Cat;
import com.geekbrains.training.model.Plate;

public class Main {
  public static void main(String[] args) {
    Cat cat = new Cat("Murzik");
    Plate plate = new Plate(100);
    cat.eat(plate, 10);
    plate.info();
  }

  public static void printValue(Integer a) {
    System.out.println("value= " + a);
  }

  public static void printInt(int i) {
    System.out.println("value= " + i);
  }
}
