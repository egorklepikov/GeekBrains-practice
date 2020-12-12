package com.geekbrains.training.ui.game;

import com.geekbrains.training.gamelogic.GameLogic;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseInputListener {
  private boolean isGameStarted;
  private final ArrayList<GameElement> gameElements;
  private CellConverter cellConverter;
  private GameLogic gameLogic;

  public GamePanel() {
    setBackground(new Color(224, 224, 224));
    addMouseListener(this);
    gameElements = new ArrayList<>();
    isGameStarted = false;
  }

  public void startGame(int xSize, int ySize) {
    isGameStarted = true;
    GameUtils.getInstance().setFieldSizeX(xSize);
    GameUtils.getInstance().setFieldSizeY(ySize);
    GameUtils.getInstance().setGameFieldWidth(getWidth());
    GameUtils.getInstance().setGameFieldHeight(getHeight());
    gameLogic = new GameLogic();
    gameLogic.initGameField(xSize);
    cellConverter = new CellConverter();
    revalidate();
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    if (isGameStarted) {
      Graphics2D graphics2D = (Graphics2D) g;
      graphics2D.setStroke(new BasicStroke(2));
      graphics2D.setColor(Color.white);
      drawRows(graphics2D);
      drawColumns(graphics2D);
      drawGameElements(g);
    }
  }

  private void drawGameElements(Graphics graphics) {
    for (GameElement gameElement : gameElements) {
      if (gameElement != null) {
        graphics.drawImage(
          gameElement.getImage(),
          gameElement.getX(),
          gameElement.getY(),
          GameUtils.getInstance().getCellWidth(),
          GameUtils.getInstance().getCellHeight(),
          null
        );
      }
    }
  }

  private void drawColumns(Graphics2D graphics2D) {
    Rectangle panelBounds = this.getBounds();
    int[] previousCoordinates = new int[4];
    for (int xSizeIndex = 0; xSizeIndex < GameUtils.getInstance().getFieldSizeY() - 1; xSizeIndex++) {
      if (xSizeIndex == 0) {
        previousCoordinates = drawColumn(GameUtils.getInstance().getFieldSizeY(), graphics2D, panelBounds);
      } else {
        previousCoordinates = drawColumn(GameUtils.getInstance().getFieldSizeY(), graphics2D, panelBounds, previousCoordinates);
      }
    }
  }

  private int[] drawColumn(int step, Graphics2D graphics2D, Rectangle panelBounds) {
    int[] xy1 = {panelBounds.x + panelBounds.width / step, panelBounds.y};
    int[] xy2 = {panelBounds.x + panelBounds.width / step, panelBounds.height};
    graphics2D.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
    return new int[]{xy1[0], xy1[1], xy2[0], xy2[1]};
  }

  private int[] drawColumn(int step, Graphics2D graphics2D, Rectangle panelBounds, int[] previousCoordinates) {
    int[] xy1 = {previousCoordinates[0] + panelBounds.x + panelBounds.width / step, panelBounds.y};
    int[] xy2 = {previousCoordinates[2] + panelBounds.x + panelBounds.width / step, panelBounds.height};
    graphics2D.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
    return new int[]{xy1[0], xy1[1], xy2[0], xy2[1]};
  }

  private void drawRows(Graphics2D graphics2D) {
    Rectangle panelBounds = this.getBounds();
    int[] previousCoordinates = new int[4];
    for (int xSizeIndex = 0; xSizeIndex < GameUtils.getInstance().getFieldSizeX() - 1; xSizeIndex++) {
      if (xSizeIndex == 0) {
        previousCoordinates = drawRow(GameUtils.getInstance().getFieldSizeX(), graphics2D, panelBounds);
      } else {
        previousCoordinates = drawRow(GameUtils.getInstance().getFieldSizeX(), graphics2D, panelBounds, previousCoordinates);
      }
    }
  }

  private int[] drawRow(int step, Graphics2D graphics2D, Rectangle panelBounds) {
    int[] xy1 = {panelBounds.x, panelBounds.x + panelBounds.height / step};
    int[] xy2 = {panelBounds.width, panelBounds.x + panelBounds.height / step};
    graphics2D.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
    return new int[]{xy1[0], xy1[1], xy2[0], xy2[1]};
  }

  private int[] drawRow(int step, Graphics2D graphics2D, Rectangle panelBounds, int[] previousCoordinates) {
    int[] xy1 = {previousCoordinates[0], previousCoordinates[1] + panelBounds.height / step};
    int[] xy2 = {panelBounds.width, previousCoordinates[3] + panelBounds.height / step};
    graphics2D.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
    return new int[]{xy1[0], xy1[1], xy2[0], xy2[1]};
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (playerTurn(e)) {
      System.out.println("Player won");
    } else if (aiTurn()) {
      System.out.println("AI won");
    } else {
      System.out.println("continue");
    }
    revalidate();
    repaint();
  }

  private boolean aiTurn() {
    int[] cell = gameLogic.nextAiTurn();
    addNewZero(cell[1], cell[0]);
    return gameLogic.checkWinners(cell[1], cell[0]) == -1;
  }

  private boolean playerTurn(MouseEvent e) {
    int[] cell = addNewCross(e.getX(), e.getY());
    gameLogic.nextPlayerTurn(cell[1], cell[0]);
    return gameLogic.checkWinners(cell[1], cell[0]) == 1;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    //Method unused
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    //Method unused
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    //Method unused
  }

  @Override
  public void mouseExited(MouseEvent e) {
    //Method unused
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    //Method unused
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    //Method unused
  }

  private int[] addNewCross(int x, int y) {
    int[] cellCoordinates = cellConverter.convert(x, y);
    gameElements.add(new Cross(cellCoordinates[0], cellCoordinates[1]));
    return cellCoordinates;
  }

  private void addNewZero(int x, int y) {
    gameElements.add(new Zero(x, y));
  }
}