package com.geekbrains.practice.creatures;

public class Robot implements ICreature {
  private int robotPowerRun;
  private int robotPowerJump;

  @Override
  public boolean run(int barrierLength) {
    return robotPowerRun >= barrierLength;
  }

  @Override
  public boolean jump(int barrierHeight) {
    return robotPowerJump >= barrierHeight;
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
