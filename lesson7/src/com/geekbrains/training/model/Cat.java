package com.geekbrains.training.model;

public class Cat {
  private String name;

  public Cat(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void eat(Plate plate) {
    System.out.println("cat " + name + " eat...");
    plate.decreaseFood(10);
  }
}
