package com.geekbrains.practice.creatures;

public class Cat implements ICreature {
  private int catPowerRun;
  private int catPowerJump;

  public Cat(int catPowerRun, int catPowerJump) {
    this.catPowerRun = catPowerRun;
    this.catPowerJump = catPowerJump;
  }

  @Override
  public boolean run(int barrierLength) {
    boolean isRun = catPowerRun >= barrierLength;
    if (isRun) {
      System.out.println(Cat.class.getCanonicalName() + " ran successfully...");
    } else {
      System.out.println(Cat.class.getCanonicalName() + " cannot run anymore...");
    }
    return isRun;
  }

  @Override
  public boolean jump(int barrierHeight) {
    boolean isJump = catPowerJump >= barrierHeight;
    if (isJump) {
      System.out.println(Cat.class.getCanonicalName() + " jumped successfully...");
    } else {
      System.out.println(Cat.class.getCanonicalName() + " cannot jump anymore...");
    }
    return isJump;
  }

  public int getCatPowerRun() {
    return catPowerRun;
  }

  public void setCatPowerRun(int catPower) {
    this.catPowerRun = catPower;
  }

  public int getCatPowerJump() {
    return catPowerJump;
  }

  public void setCatPowerJump(int catPowerJump) {
    this.catPowerJump = catPowerJump;
  }
}
