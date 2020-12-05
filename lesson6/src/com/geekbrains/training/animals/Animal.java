package com.geekbrains.training.animals;

public abstract class Animal {
  private final String name;
  public static int animalsCount;

  public abstract void run(int roadLength);
  public abstract void swim(int roadLength);

  public Animal(String name) {
    this.name = name;
    animalsCount++;
  }

  public String getName() {
    return name;
  }
}