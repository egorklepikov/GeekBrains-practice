package com.geekbrains.training.ui.game;

public class CellConverter {
  public int[] convert(int x, int y) {
    return new int[]{convertX(x), convertY(y)};
  }

  private int convertX(int x) {
    return x / GameUtils.getInstance().getCellWidth();
  }

  private int convertY(int y) {
    return y / GameUtils.getInstance().getCellHeight();
  }
}