package com.geekbrains.practice.creatures;

public class Robot implements ICreature {
  private int robotPowerRun;
  private int robotPowerJump;

  public Robot(int robotPowerRun, int robotPowerJump) {
    this.robotPowerRun = robotPowerRun;
    this.robotPowerJump = robotPowerJump;
  }

  @Override
  public boolean run(int barrierLength) {
    boolean isRun = robotPowerRun >= barrierLength;
    if (isRun) {
      System.out.println(Robot.class.getCanonicalName() + " ran successfully...");
    } else {
      System.out.println(Robot.class.getCanonicalName() + " cannot run anymore...");
    }
    return isRun;
  }

  @Override
  public boolean jump(int barrierHeight) {
    boolean isJump = robotPowerJump >= barrierHeight;
    if (isJump) {
      System.out.println(Robot.class.getCanonicalName() + " jumped successfully...");
    } else {
      System.out.println(Robot.class.getCanonicalName() + " cannot jump anymore...");
    }
    return isJump;
  }

  public int getRobotPowerRun() {
    return robotPowerRun;
  }

  public void setRobotPowerRun(int robotPowerRun) {
    this.robotPowerRun = robotPowerRun;
  }

  public int getRobotPowerJump() {
    return robotPowerJump;
  }

  public void setRobotPowerJump(int robotPowerJump) {
    this.robotPowerJump = robotPowerJump;
  }
}
