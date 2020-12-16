package com.geekbrains.practice.logic;

public class Cat implements ICreature {
  @Override
  public void run() {
    System.out.println(Cat.class.getCanonicalName() + " is running...");
  }

  @Override
  public void jump() {
    System.out.println(Cat.class.getCanonicalName() + " is jumping...");
  }
}
