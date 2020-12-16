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
    return catPowerRun >= barrierLength;
  }

  @Override
  public boolean jump(int barrierHeight) {
    return catPowerJump >= barrierHeight;
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
