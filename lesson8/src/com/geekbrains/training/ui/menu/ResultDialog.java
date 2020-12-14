package com.geekbrains.training.ui.menu;

import com.geekbrains.training.ui.Constants;
import com.geekbrains.training.ui.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class ResultDialog extends JDialog {
  public ResultDialog() {
    setModal(true);
    setSize(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
    centerDialog();
    setTitle("Result...");
  }

  private void centerDialog() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
      dimension.width / 2 - this.getSize().width / 2,
      dimension.height / 2 - this.getSize().height / 2
    );
  }

  public void showDialog(boolean isPlayerWon, GamePanel gamePanel) {
    String message;
    if (isPlayerWon) {
      message = "Congratulations! You did it.";
    } else {
      message = "AI won...";
    }
    JLabel resultLabel = new JLabel(message, SwingConstants.CENTER);
    resultLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
    JButton tryAgainButton = new JButton("Click here to play again");
    tryAgainButton.addActionListener(e -> {
      setVisible(false);
      new SettingsDialog(gamePanel).setVisible(true);
    });
    add(resultLabel);
    add(tryAgainButton, BorderLayout.SOUTH);
    setVisible(true);
  }
}
