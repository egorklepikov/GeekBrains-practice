package com.geekbrains.training.model;

public class Cat {
  private final String name;
  private boolean isHungry;

  public Cat(String name) {
    this.name = name;
    isHungry = true;
  }

  public String getName() {
    return name;
  }

  public void eat(Plate plate, int amountFood) {
    if (plate.isPlateValid(amountFood)) {
      plate.decreaseFood(amountFood);
      isHungry = false;
      System.out.println(name + " is happy and ready to run.");
    }
  }

  public boolean isHungry() {
    return isHungry;
  }
}
