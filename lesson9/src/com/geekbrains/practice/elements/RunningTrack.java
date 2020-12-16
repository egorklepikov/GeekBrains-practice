package com.geekbrains.practice.elements;

import com.geekbrains.practice.creatures.ICreature;

public class RunningTrack implements IBarrier {
  @Override
  public void performAction(ICreature creature) {
    creature.run();
  }
}
