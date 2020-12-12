package com.geekbrains.training.ui.game;

import java.awt.image.BufferedImage;

public abstract class GameElement {
  protected BufferedImage image;
  protected int x;
  protected int y;
  protected int cellCoordinateX;
  protected int cellCoordinateY;

  public GameElement(int cellCoordinateX, int cellCoordinateY) {
    this.cellCoordinateX = cellCoordinateX;
    this.cellCoordinateY = cellCoordinateY;
    this.x = cellCoordinateX * GameUtils.getInstance().getCellWidth();
    this.y = cellCoordinateY * GameUtils.getInstance().getCellHeight();
  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getCellCoordinateX() {
    return cellCoordinateX;
  }

  public void setCellCoordinateX(int cellCoordinateX) {
    this.cellCoordinateX = cellCoordinateX;
  }

  public int getCellCoordinateY() {
    return cellCoordinateY;
  }

  public void setCellCoordinateY(int cellCoordinateY) {
    this.cellCoordinateY = cellCoordinateY;
  }
}
