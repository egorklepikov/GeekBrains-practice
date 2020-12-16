package com.geekbrains.practice.creatures;

public class Robot implements ICreature {
  @Override
  public void run() {
    System.out.println(Robot.class.getCanonicalName() + " is running...");
  }

  @Override
  public void jump() {
    System.out.println(Robot.class.getCanonicalName() + " is jumping...");
  }
}