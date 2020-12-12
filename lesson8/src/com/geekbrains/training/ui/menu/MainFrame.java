package com.geekbrains.training.ui.menu;

import com.geekbrains.training.ui.Constants;
import com.geekbrains.training.ui.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
  private final SettingsDialog settingsDialog;

  public static void main(String[] args) {
    new MainFrame();
  }

  public MainFrame() {
    setTitle("Tic Tac Toe");
    setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    centerFrame();

    GamePanel gamePanel = new GamePanel();
    settingsDialog = new SettingsDialog(gamePanel);

    JButton startGameButton = new JButton();
    startGameButton.setText("Start game");
    startGameButton.addActionListener(e -> settingsDialog.showDialog());

    add(gamePanel, BorderLayout.CENTER);
    add(startGameButton, BorderLayout.SOUTH);
    setVisible(true);
  }

  private void centerFrame() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
      dimension.width / 2 - this.getSize().width / 2,
      dimension.height / 2 - this.getSize().height / 2
    );
  }
}
