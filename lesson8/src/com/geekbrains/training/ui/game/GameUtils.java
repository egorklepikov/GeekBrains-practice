package com.geekbrains.training.ui.game;

public class GameUtils {
  private static GameUtils instance;
  private int fieldSizeX;
  private int fieldSizeY;
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
    return gameFieldWidth / fieldSizeX;
  }

  public int getCellHeight() {
    return gameFieldHeight / fieldSizeY;
  }

  public int getFieldSizeX() {
    return fieldSizeX;
  }

  public void setFieldSizeX(int fieldSizeX) {
    this.fieldSizeX = fieldSizeX;
  }

  public int getFieldSizeY() {
    return fieldSizeY;
  }

  public void setFieldSizeY(int fieldSizeY) {
    this.fieldSizeY = fieldSizeY;
  }

  public int getGameFieldWidth() {
    return gameFieldWidth;
  }

  public void setGameFieldWidth(int gameFieldWidth) {
    this.gameFieldWidth = gameFieldWidth;
  }

  public int getGameFieldHeight() {
    return gameFieldHeight;
  }

  public void setGameFieldHeight(int gameFieldHeight) {
    this.gameFieldHeight = gameFieldHeight;
  }
}
