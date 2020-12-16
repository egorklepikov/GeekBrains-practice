package com.geekbrains.practice.entry;

import com.geekbrains.practice.creatures.Cat;
import com.geekbrains.practice.creatures.Human;
import com.geekbrains.practice.creatures.ICreature;
import com.geekbrains.practice.creatures.Robot;
import com.geekbrains.practice.elements.IBarrier;
import com.geekbrains.practice.elements.RunningTrack;
import com.geekbrains.practice.elements.Wall;

public class Main {
  public static void main(String[] args) {
    ICreature[] creatures = {
      new Cat(),
      new Human(),
      new Robot()
    };
    IBarrier[] barriers = {
      new Wall(),
      new RunningTrack()
    };
    startChallenge(creatures, barriers);
  }

  private static void startChallenge(ICreature[] creatures, IBarrier[] barriers) {
    for (ICreature creature : creatures) {
      for (IBarrier barrier : barriers) {
        barrier.performAction(creature);
      }
    }
  }
}
