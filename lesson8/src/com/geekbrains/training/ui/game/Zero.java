package com.geekbrains.training.ui.game;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Zero extends GameElement {
  public Zero(int cellCoordinateX, int cellCoordinateY) {
    super(cellCoordinateX, cellCoordinateY);
    try {
      image = ImageIO.read(new File("lesson8\\assets\\zero.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
