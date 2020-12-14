package com.geekbrains.training.ui.menu;

import com.geekbrains.training.ui.Constants;
import com.geekbrains.training.ui.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog {
  private final JTextField gameFieldSizeField;
  private final JTextField requiredElementsField;

  public SettingsDialog(GamePanel gamePanel) {
    setModal(true);
    setSize(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
    centerDialog();
    setTitle("Select settings");
    setLayout(new GridBagLayout());

    gameFieldSizeField = new JTextField(10);
    requiredElementsField = new JTextField(10);
    JButton startGameButton = new JButton("Start game");
    startGameButton.addActionListener(e -> {
      gamePanel.startGame(Integer.parseInt(gameFieldSizeField.getText()), Integer.parseInt(requiredElementsField.getText()));
      setVisible(false);
    });

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(new JLabel("Input game field size: "), constraints);
    constraints.gridx = 1;
    constraints.gridy = 0;
    add(gameFieldSizeField, constraints);
    constraints.gridx = 0;
    constraints.gridy = 1;
    add(new JLabel("Input game field size: "), constraints);
    constraints.gridx = 1;
    constraints.gridy = 1;
    add(requiredElementsField, constraints);
    constraints.gridx = 0;
    constraints.gridy = 2;
    add(startGameButton, constraints);

    setSize(400, 200);
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
