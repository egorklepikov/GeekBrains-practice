package com.geekbrains.practice.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
  @FXML
  private GridPane sendMessageGrid;
  @FXML
  private TextField inputMessageButton;
  @FXML
  private AnchorPane mainScene;
  @FXML
  private AnchorPane leftAnchorPane;
  @FXML
  private AnchorPane rightAnchorPane;
  @FXML
  private GridPane rightGridPane;
  @FXML
  private TextArea messagesPanel;
  @FXML
  private Button sendMessageButton;
  @FXML
  private TextField inputMessage;

  @FXML
  public void sendMessageWithField(KeyEvent keyEvent) {
    if (keyEvent.getCode() == KeyCode.ENTER) {
      messagesPanel.appendText(inputMessage.getText());
      inputMessage.clear();
      inputMessage.requestFocus();
    }
  }

  @FXML
  public void sendMessageWithButton() {
    messagesPanel.appendText(inputMessage.getText());
    inputMessage.clear();
    inputMessage.requestFocus();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}
