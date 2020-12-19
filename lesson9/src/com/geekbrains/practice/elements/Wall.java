package com.geekbrains.practice.elements;

import com.geekbrains.practice.creatures.ICreature;

public class Wall implements IBarrier {
  private int wallLength;

  public Wall(int wallLength) {
    this.wallLength = wallLength;
  }

  @Override
  public boolean performAction(ICreature creature) {
    return creature.jump(wallLength);
  }

  public int getWallLength() {
    return wallLength;
  }

  public void setWallLength(int wallLength) {
    this.wallLength = wallLength;
  }
}
