package com.geekbrains.training.ui.menu;

import com.geekbrains.training.ui.Constants;
import com.geekbrains.training.ui.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog {
  private final JButton startGame;
  private final JSlider gameFieldX;
  private final JSlider getGameFieldY;
  private final JLabel selectGameFieldXLabel;
  private final JLabel selectGameFieldYLabel;

  public SettingsDialog(GamePanel gamePanel) {
    setModal(true);
    setSize(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
    centerDialog();
    setTitle("Select settings");

    selectGameFieldXLabel = new JLabel("Enter X value:");
    selectGameFieldYLabel = new JLabel("Enter Y value:");

    gameFieldX = new JSlider();
    gameFieldX.setMinimum(3);
    gameFieldX.setMaximum(9);
    gameFieldX.setMajorTickSpacing(1);
    gameFieldX.setMinorTickSpacing(1);
    gameFieldX.setPaintTicks(true);
    gameFieldX.setPaintLabels(true);

    getGameFieldY = new JSlider();
    getGameFieldY.setMinimum(3);
    getGameFieldY.setMaximum(9);
    getGameFieldY.setMajorTickSpacing(1);
    getGameFieldY.setMinorTickSpacing(1);
    getGameFieldY.setPaintTicks(true);
    getGameFieldY.setPaintLabels(true);

    JPanel slidersPanel = new JPanel();
    slidersPanel.setLayout(new GridLayout(4, 2));
    slidersPanel.add(selectGameFieldXLabel);
    slidersPanel.add(gameFieldX);
    slidersPanel.add(selectGameFieldYLabel);
    slidersPanel.add(getGameFieldY);

    startGame = new JButton();
    startGame.setText("Continue");
    startGame.addActionListener(e -> {
      gamePanel.startGame(gameFieldX.getValue(), getGameFieldY.getValue());
      setVisible(false);
    });

    add(startGame, BorderLayout.SOUTH);
    add(slidersPanel, BorderLayout.CENTER);
    pack();
  }

  private void centerDialog() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
      dimension.width / 2 - this.getSize().width / 2,
      dimension.height / 2 - this.getSize().height / 2
    );
  }

  public void showDialog() {
    setVisible(true);
  }
}
