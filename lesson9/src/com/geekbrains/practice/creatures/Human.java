package com.geekbrains.practice.creatures;

public class Human implements ICreature {
  private int humanPowerRun;
  private int humanPowerJump;

  public Human(int humanPowerRun, int humanPowerJump) {
    this.humanPowerRun = humanPowerRun;
    this.humanPowerJump = humanPowerJump;
  }

  @Override
  public boolean run(int barrierLength) {
    boolean isRun = humanPowerRun >= barrierLength;
    if (isRun) {
      System.out.println(Human.class.getCanonicalName() + " ran successfully...");
    } else {
      System.out.println(Human.class.getCanonicalName() + " cannot run anymore...");
    }
    return isRun;
  }

  @Override
  public boolean jump(int barrierHeight) {
    boolean isJump = humanPowerJump >= barrierHeight;
    if (isJump) {
      System.out.println(Human.class.getCanonicalName() + " jumped successfully...");
    } else {
      System.out.println(Human.class.getCanonicalName() + " cannot jump anymore...");
    }
    return isJump;
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
