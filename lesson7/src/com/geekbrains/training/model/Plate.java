package com.geekbrains.training.model;

public class Plate {
  private int food;

  public Plate(int food) {
    this.food = food;
  }

  public int getFood() {
    return food;
  }

  public void decreaseFood(int amount) {
    if (amount < 0 || food - amount < 0) {
      System.out.println("Place is empty or cannot be used");
      return;
    }
    food -= amount;
  }

  public void info() {
    System.out.println("Food: " + food);
  }
}
