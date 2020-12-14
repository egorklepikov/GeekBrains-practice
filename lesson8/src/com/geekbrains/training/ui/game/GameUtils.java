package com.geekbrains.training.ui.game;

public class GameUtils {
  private static GameUtils instance;
  private int fieldSize;
  private int gameFieldWidth;
  private int gameFieldHeight;

  private GameUtils() {

  }

  public static GameUtils getInstance() {
    if (instance == null) {
      instance = new GameUtils();
    }
    return instance;
  }

  public int getCellWidth() {
    return gameFieldWidth / fieldSize;
  }

  public int getCellHeight() {
    return gameFieldHeight / fieldSize;
  }

  public int getFieldSize() {
    return fieldSize;
  }

  public void setFieldSize(int fieldSize) {
    this.fieldSize = fieldSize;
  }

  public void setGameFieldWidth(int gameFieldWidth) {
    this.gameFieldWidth = gameFieldWidth;
  }

  public void setGameFieldHeight(int gameFieldHeight) {
    this.gameFieldHeight = gameFieldHeight;
  }
}
