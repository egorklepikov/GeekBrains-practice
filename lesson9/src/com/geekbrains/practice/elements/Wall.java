package com.geekbrains.practice.elements;

import com.geekbrains.practice.creatures.ICreature;

public class Wall implements IBarrier {
  @Override
  public void performAction(ICreature creature) {
    creature.jump();
  }
}
