package com.geekbrains.training.ui.menu;

import com.geekbrains.training.ui.Constants;

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

  public void showDialog(boolean isPlayerWon) {
    String message;
    if (isPlayerWon) {
      message = "Congratulations! You did it.";
    } else {
      message = "AI won...";
    }
    JLabel resultLabel = new JLabel(message, SwingConstants.CENTER);
    resultLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
    add(resultLabel);
    setVisible(true);
  }
}
