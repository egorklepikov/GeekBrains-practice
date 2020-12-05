package com.geekbrains.training.model;

public class Plate {
  private int food;

  public Plate(int food) {
    this.food = food;
  }

  @SuppressWarnings("unused")
  public int getFood() {
    return food;
  }

  @SuppressWarnings("unused")
  public void setFood(int food) {
    this.food = food;
  }

  public boolean isPlateValid(int amountFood) {
    return !(amountFood < 0 || food - amountFood < 0);
  }

  public void decreaseFood(int amount) {
    food -= amount;
    System.out.println(food);
  }
}
