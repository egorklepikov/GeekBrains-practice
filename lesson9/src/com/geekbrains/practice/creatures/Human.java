package com.geekbrains.practice.creatures;

public class Human implements ICreature {
  private int humanPowerRun;
  private int humanPowerJump;

  @Override
  public boolean run(int barrierLength) {
    return humanPowerRun >= barrierLength;
  }

  @Override
  public boolean jump(int barrierHeight) {
    return humanPowerJump >= barrierHeight;
  }

  public int getHumanPowerRun() {
    return humanPowerRun;
  }

  public void setHumanPowerRun(int humanPowerRun) {
    this.humanPowerRun = humanPowerRun;
  }

  public int getHumanPowerJump() {
    return humanPowerJump;
  }

  public void setHumanPowerJump(int humanPowerJump) {
    this.humanPowerJump = humanPowerJump;
  }
}
