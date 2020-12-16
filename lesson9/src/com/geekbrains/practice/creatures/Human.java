package com.geekbrains.practice.creatures;

public class Human implements ICreature {
  @Override
  public void run() {
    System.out.println(Human.class.getCanonicalName() + " is running...");
  }

  @Override
  public void jump() {
    System.out.println(Human.class.getCanonicalName() + " is jumping...");
  }
}
