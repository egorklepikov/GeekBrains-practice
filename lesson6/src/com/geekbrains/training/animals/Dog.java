package com.geekbrains.training.animals;

public class Dog extends Animal {
  public static int dogsCount;

  public Dog(String name) {
    super(name);
    dogsCount++;
  }

  @Override
  public void run(int roadLength) {
    if (roadLength <= 500) {
      System.out.println(getName() + " ran " + roadLength + " meters");
    } else {
      System.out.println(getName() + " cannot run more that 500 meters.");
    }
  }

  @Override
  public void swim(int roadLength) {
    if (roadLength <= 10) {
      System.out.println(getName() + " swim " + roadLength + " meters");
    } else {
      System.out.println(getName() + " cannot swim more that 10 meters.");
    }
  }
}