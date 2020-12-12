package com.geekbrains.training.ui.game;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cross {
  private BufferedImage image;
  private final int x;
  private final int y;
  private final int cellCoordinateX;
  private final int cellCoordinateY;

  public Cross(int cellCoordinateX, int cellCoordinateY) {
    try {
      image = ImageIO.read(new File("C:\\Users\\egork\\IdeaProjects\\GeekBrains - practice\\lesson8\\src\\cross.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.cellCoordinateX = cellCoordinateX;
    this.cellCoordinateY = cellCoordinateY;
    this.x = cellCoordinateX * GameUtils.getInstance().getCellWidth();
    this.y = cellCoordinateY * GameUtils.getInstance().getCellHeight();
  }

  public BufferedImage getImage() {
    return image;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getCellCoordinateX() {
    return cellCoordinateX;
  }

  public int getCellCoordinateY() {
    return cellCoordinateY;
  }
}
