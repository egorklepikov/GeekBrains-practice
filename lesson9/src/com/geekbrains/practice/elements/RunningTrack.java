package com.geekbrains.practice.elements;

import com.geekbrains.practice.creatures.ICreature;

public class RunningTrack implements IBarrier {
  private int runningTrackLength;

  @Override
  public boolean performAction(ICreature creature) {
    return creature.run(runningTrackLength);
  }

  public int getRunningTrackLength() {
    return runningTrackLength;
  }

  public void setRunningTrackLength(int runningTrackLength) {
    this.runningTrackLength = runningTrackLength;
  }
}
