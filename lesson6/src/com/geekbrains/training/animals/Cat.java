package com.geekbrains.training.animals;

public class Cat extends Animal {
  public static int catsCount;

  public Cat(String name) {
    super(name);
    catsCount++;
  }

  @Override
  public void run(int roadLength) {
    if (roadLength <= 200) {
      System.out.println(getName() + " ran " + roadLength + " meters.");
    } else {
      System.out.println(getName() + " cannot run more that 200 meters.");
    }
  }

  @Override
  public void swim(int roadLength) {
    System.out.println("Cat is unable to swim.");
  }
}

