package com.geekbrains.training.ui.game;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Zero extends GameElement {
  public Zero(int cellCoordinateX, int cellCoordinateY) {
    super(cellCoordinateX, cellCoordinateY);
    try {
      image = ImageIO.read(new File("C:\\Users\\egork\\IdeaProjects\\GeekBrains - practice\\lesson8\\src\\zero.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
