package com.geekbrains.training.ui.game;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Cross extends GameElement {
  public Cross(int cellCoordinateX, int cellCoordinateY) {
    super(cellCoordinateX, cellCoordinateY);
    try {
      image = ImageIO.read(new File("C:\\Users\\egork\\IdeaProjects\\GeekBrains - practice\\lesson8\\src\\cross.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
